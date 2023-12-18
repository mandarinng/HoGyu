<template>
    <div style="margin-top: 200px; margin-left: 100px;" >
        <span style="color: orangered;  font-size: 30px;">{{store.productSearchList.length}}</span>
        <span style="font-size: 30px;">개의 검색 결과</span>
        <hr style="margin: 50px 0px;">
        <div>
          <p v-if="store.productSearchList.length==0" style="color: #383838; font-size: 50px; text-align: center; font-weight: bold;">검색결과가 없습니다.</p>
          <div v-if="store.productSearchList.length>0" class="pro-container" >
            <product-search-item v-for="product in store.productSearchList"
            :key="product.productId" :product="product"></product-search-item>
          </div>
        </div>
    </div>
</template>

<script setup>
import ProductSearchItem from './ProductSearchItem.vue';
import { useProductStore } from '@/stores/product'

const store = useProductStore()




</script>

<style scoped>

.pro-container {
    display: grid;
    grid-template-columns: repeat(4, 1fr);
  
  }
  
  .list-container {
    margin-top: 40px;
    margin-left: 100px;
  }
  
</style>
