<template>
  <div class="whole">
      <!-- <h3>상품 상세의 설명</h3> -->
      <img :src="imgUrl" style="width: 1300px; height:auto;">
  </div>
</template>

<script setup>
import { computed } from 'vue'
import { useProductStore } from '../../stores/product';
const store = useProductStore()

const imgUrl = computed(() => {
return new URL(`../../assets/`+store.product.detail,import.meta.url);
});

</script>

<style scoped>

.whole{
/* margin-top: 100px; */
display: flex;
/* justify-content: center; */
text-align: center;
padding-left: 14.5%;
}

</style>