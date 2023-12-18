<template>
    <tr>
        <td>{{ index + 1 }}</td>
        <td><img :src="imgUrl" style="width:150px"></td>
        <td>{{ cart.productName }}</td>
        <td>{{ cart.cnt }}</td>
        <td>{{ cart.price }}</td>
    </tr>
</template>

<script setup>

import { computed, watch } from 'vue'
import{ref} from 'vue'
import { useCartStore } from '@/stores/cart';

const cstore = useCartStore()

const props = defineProps({
    cart: {
        type: Object,
        default: null,
    },
    index: {
        type: Number,
    },
    user:{
        type: Object,
    }
})

const imgUrl = computed(() => {
  return new URL(`../../assets/`+props.cart.img,import.meta.url);
});

</script>

<style scoped>
td{
  font-size: 25px;
}
tr{
    line-height: 5rem;

}

</style>
