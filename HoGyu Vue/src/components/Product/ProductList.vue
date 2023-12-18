<template>
  <div style="background-color: #ededed; margin-top: 100px;">
    <div style="display: flex; justify-content: center; padding-top: 100px; ">
      <span class="box-1">
        <div class="btn btn-one ac1"  :class="{'act_button': all }" @click="showAll">
          <span style="absoulte-size: large;">ALL</span>
        </div>
      </span>
      
      <span class="box-1">
        <div class="btn btn-one ac3" :class="{'act_button': wear && !all}" @click="showWear">
          <span style="margin-top: 150px;">WEAR</span>
        </div>
      </span>
      <span class="box-1">
        <div class="btn btn-one ac4" :class="{'act_button': mach && !all }"  @click="showMach">
          <span  style="margin-top: 150px;">MACHINE</span>
        </div>
      </span>
      <span class="box-1">
        <div class="btn btn-one ac2" :class="{'act_button': food && !all }" @click="showFood">
          <span  style="margin-top: 150px;">FOOD</span>
        </div>
      </span>
    </div>
    <br>
    <hr style="width: 90%; margin: 0 auto; margin-top: 50px;">
    <br>

    <div class="list-container" style="margin-right: 100px;">
      <div v-show="mach">
        <p style="margin-left:80px; font-size: 50px; margin-bottom: 60px;">MACHINE</p>
        <div class="pro-container">
          <ProductListItem style="margin: 0 auto;" v-for="product in store.productMachList" :key="product.productId" :product="product" />
        </div>
      </div>
      
      <div v-show="food">
        <p style="margin-left:80px; font-size: 50px; margin-bottom: 60px;">FOOD</p>
        <div class="pro-container" >
          <ProductListItem style="margin: 0 auto;" v-for="product in store.productFoodList" :key="product.productId" :product="product" />
        </div>
      </div>

      <div v-show="wear">
        <p style="margin-left:80px; font-size: 50px; margin-bottom: 60px;">WEAR</p>
        <div class="pro-container">
          <ProductListItem style="margin: 0 auto;" v-for="product in store.productWearList" :key="product.productId" :product="product" />
        </div>
      </div>

      
    </div>
  </div>
</template>

<script setup>
import ProductListItem from './ProductListItem.vue';
import { useProductStore } from '@/stores/product'
import { onMounted, ref } from 'vue';
const store = useProductStore()

onMounted(() => {
  store.getProductFoodList()
  store.getProductWearList()
  store.getProductMachList()
})

const all = ref(true)
const wear = ref(true)
const food = ref(true)
const mach = ref(true)

const showAll = function () {
  wear.value = true;
  all.value = true;
  food.value = true;
  mach.value = true;
}

const showFood = function () {
  all.value = false;
  wear.value = false;
  food.value = true;
  mach.value = false;
}

const showWear = function () {
  all.value = false;
  wear.value = true;
  food.value = false;
  mach.value = false;
}

const showMach = function () {
  all.value = false;
  wear.value = false;
  food.value = false;
  mach.value = true;
}
</script>

<style scoped>
.box-1{
  margin: 0px 30px;
}

.pro-container {
  display: grid;
  grid-template-columns: repeat(4, 1fr);

}

.list-container {
  margin-top: 40px;
  margin-left: 100px;
}

/* html,
body {
  width: 100%;
  height: 100%;
  overflow: hidden;
  margin: 0;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  font-family: 'Open Sans Condensed', sans-serif;
} */

div[class=box] {
  height: 33.33%;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}


.btn {
  line-height: 50px;
  height: 80px;
  text-align: center;
  width: 300px;
  cursor: pointer;
  padding-top: 10px;
}

/* 
========================
    BUTTON ONE
========================
*/
.btn-one {
  color: #383838;
  transition: all 0.3s;
  position: relative;
  font-size: xx-large;
}

.btn-one span {
  transition: all 0.3s;
}

.btn-one::before {
  content: '';
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1;
  opacity: 0;
  transition: all 0.3s;
  border-top-width: 1px;
  border-bottom-width: 1px;
  border-top-style: solid;
  border-bottom-style: solid;
  border-top-color: #383838(255, 255, 255, 0.5);
  border-bottom-color: #383838(255, 255, 255, 0.5);
  transform: scale(0.1, 1);
}

.btn-one:hover span {
  letter-spacing: 2px;
}

.btn-one:hover::before {
  opacity: 1;
  transform: scale(1, 1);
}

.btn-one::after {
  content: '';
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1;
  transition: all 0.3s;
  background-color: rgba(255, 255, 255, 0.1);
}


.btn-one:hover::after {

  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1;
  transition: all 0.3s;
  background-color: rgba(255, 255, 255, 0.1);
}
.btn-one:visited {

  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1;
  opacity: 0;
  transition: all 0.3s;
  border-top-width: 1px;
  border-bottom-width: 1px;
  border-top-style: solid;
  border-bottom-style: solid;
  border-top-color: #383838(255, 255, 255, 0.5);
  border-bottom-color: #383838(255, 255, 255, 0.5);
  transform: scale(0.1, 1);
}

.btn-one.clicked span {
  letter-spacing: 2px;
}

.btn-one.clicked::before {
  opacity: 1;
  transform: scale(1, 1);
}

.btn-one.clicked::after {
  background-color: rgba(255, 255, 255, 0.1);
}
.act_button {
color: #ffffff;
border-radius: 0%;
background-color:  rgb(178, 178, 178);


}


</style>
