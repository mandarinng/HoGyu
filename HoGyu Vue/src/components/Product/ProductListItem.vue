<template>
    <div>
    <div @click="productDetail" class="product-container cropping" >
        <img :src="imgUrl">
        <p style="font-size: 25px; font-weight: 600; margin-top: 30px; margin-left: 20px;" >{{ product.productName }}</p>
        <p style="font-size: 25px; margin-bottom: 30px; margin-left: 20px;">{{ product.price }} 원</p>
    </div>
</div>
</template>

<script setup>

import { computed } from 'vue'
import { useProductStore } from '@/stores/product'

const store = useProductStore()

const props = defineProps({
    product: {
        type: Object,
        default: null,
    }
})

const imgUrl = computed(() => {
  return new URL(`../../assets/`+props.product.img,import.meta.url);
});

const productDetail = function(){
    store.productDetail(props.product.productId)
    console.log(props.product.productId)
}


</script>

<style scoped>
.product-container{
    display: flex;
    flex-direction: column;
    width: 550px;
}
img {
  max-width: 550px;
  width: 550px;
  height: 550px;
  object-fit: cover;
  border-radius: 10px;
}
</style>