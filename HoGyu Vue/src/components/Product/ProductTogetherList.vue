<template>
  <div class="whole" style="margin: 10% 25%;  ">
    <h4 style="font-weight: bolder; font-size: 60px; color: #5a5a5a ; margin-left: 8%;">공동 구매 참여하기</h4><br>
      <div class="product">
        <img :src="imgUrl" class="productImg"><br>
        <div class="product-noimg">
        <h3 style="font-size: 50px;">{{pstore.product.productName}}</h3>
        <h4 style="margin-top: 20%; font-size: 30px;">개 당 {{ pstore.product.price }} 원</h4>
      </div>
      </div>
      <br><br><br>
        
        <button @click="togetherBuyStart">공동 구매 시작하기</button><br><br><br>
        <table class="table">
            <tr><th>No.</th><th>참여자</th><th>참여 인원</th><th></th></tr>
            <ProductTogetherItem v-for="(clients, index) in csstore.ClientsList"
            :key="clients.id" :clients="clients" :index="index"/>
        </table>
  </div>
</template>

<script setup>
import { useProductStore } from '@/stores/product';
import { useClientsStore } from '@/stores/clients';
import ProductTogetherItem from './ProductTogetherItem.vue';
import { ref, computed } from 'vue'

const pstore = useProductStore()
const csstore = useClientsStore()

const imgUrl = computed(() => {
  return new URL(`../../assets/`+pstore.product.img,import.meta.url);
});

const togetherBuyStart = function(){
  csstore.togetherBuyStart()
}
</script>

<style scoped>

.whole{
  /* margin-top: 50%; */
    /* padding-top: 20%; */
    text-align: center;
    background-color: rgba(253, 251, 251, 0.8);
    /* margin-bottom: 5%;
    margin-top: 5%; */
    /* padding-top: 5%; */
    padding: 3%;
    border-radius: 20px;
    width: 1500px;
    margin: 80px 300px;
  
}

.product {
    display: flex;
    /* text-align: center; */
    /* padding-left: 100px; */
    /* padding-right: 200px; */
    margin-left: 7%;
    /* align-items: center; */
    padding-top: 2%;

}

.product-noimg {
    padding-top: 8%;
    padding-left: 3%;
    /* padding-left: 500px; */
    flex-direction: column;
    text-align: left;
    color: #5a5a5a;
    margin-top: 5%;
    align-items: center;
    /* background-color: #bcbbbb; */

}

.productImg {
    margin-top: 20px;
    margin-right: 15px;
    width: 600px;
    height: 600px;
    object-fit: cover;
    /* padding: 1%; */
}

button {
    margin: 1%;
    text-decoration: none;
    color: rgba(61, 61, 61, 0.8);
    background-color: #acacac2a;
    border-radius: 10px;
    font-size: 30px;
    font-weight: 550;
    border-style: none;
    transition: background-color 0.3s ease;
    white-space: nowrap;
    width: 300px;
    height: 70px;
    margin-left: 70%;
    box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.2);
    
}

button:hover {
    color: #fafafae7;
    background-color: rgba(61, 61, 61, 0.8);
}

th{
    border-bottom: 1px solid #444444;
    padding: 10px;
    /* margin: auto; */
    font-size: 25px;
  }

  
</style>