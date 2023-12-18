<template>
  <div style="display: flex; justify-content: center; margin-top: 100px;">
      <ul class="accordion" style="margin-left: 20%; margin-right: 20%; margin-bottom: 200px; ">
          <h2 style="font-weight: bold; margin-top: 100px;">장바구니 페이지</h2>
          <p v-if="cstore.cartlist.length == 0">장바구니에 담은 상품이 없습니다.</p>
          <table v-if="cstore.cartlist.length > 0" class="table" style="text-align: center;">
              <tr>
                  <th>No.</th>
                  <th>사진</th>
                  <th>상품명</th>
                  <th>수량</th>
                  <th>가격</th>
                  <th></th>
              </tr>
              <MyCartItem v-for="(cart, index) in cstore.cartlist" :key="cart.id" :cart="cart" :index="index" />
          </table>
          <button  @click="buyCart" class="button button--antiman button--round-l button--text-medium"><i class="button__icon icon icon-plus"></i><span>구매하기</span></button>
      
      </ul>
      
  </div>
</template>

<script setup>

import { useCartStore } from '@/stores/cart'
import { useUserStore } from '@/stores/user'
import MyCartItem from './MyCartItem.vue';

const cstore = useCartStore()
const ustore = useUserStore()

const buyCart = function () {
  cstore.addTotalPrice()
  cstore.buyCart();
}

</script>

<style scoped>






ul {
  list-style: none;
}

.accordion {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.table {
  width: 1300px;


}
th{
  border-bottom: 1px solid #444444;
  padding: 10px;
  /* margin: auto; */
  font-size: 25px;
}


/* .button {
float: left;
min-width: 150px;
max-width: 250px;

display: block;
margin: 1em;
padding: 1em 2em;
border: none;
background: none;
color: inherit;
vertical-align: middle;
position: relative;
z-index: 1;
-webkit-backface-visibility: hidden;
-moz-osx-font-smoothing: grayscale;
}
.button:focus {
outline: none;
}

.button--text-medium {
font-weight: 500;
}
.button--round-l {
border-radius: 40px; */
/* }
.button--antiman {
background: none;
border: none;
height: 60px;
}
.button--antiman.button--inverted,
.button--antiman.button--inverted-alt {
-webkit-transition: color 0.3s;
transition: color 0.3s;
-webkit-transition-timing-function: cubic-bezier(0.75, 0, 0.125, 1);
transition-timing-function: cubic-bezier(0.75, 0, 0.125, 1);
}
.button--antiman > span {
padding-left: 0.35em;
}
.button--antiman::before,
.button--antiman::after {
content: '';
z-index: -1;
border-radius: inherit;
pointer-events: none;
position: absolute;
top: 0;
left: 0;
width: 100%;
height: 100%;
-webkit-backface-visibility: hidden;
-webkit-transition: -webkit-transform 0.3s, opacity 0.3s;
transition: transform 0.3s, opacity 0.3s;
-webkit-transition-timing-function: cubic-bezier(0.75, 0, 0.125, 1);
transition-timing-function: cubic-bezier(0.75, 0, 0.125, 1);
}
.button--antiman::before {
border: 2px solid #37474f;
opacity: 0;
-webkit-transform: scale3d(1.2, 1.2, 1);
transform: scale3d(1.2, 1.2, 1);
}
.button--antiman.button--border-thin::before {
border-width: 1px;
}
.button--antiman.button--border-medium::before {
border-width: 2px;
}
.button--antiman.button--border-thick::before {
border-width: 3px;
}
.button--antiman.button--inverted::before {
border-color: #7986cb;
}
.button--antiman.button--inverted-alt::before {
border-color: #3f51b5;
}
.button--antiman::after {
background: #fff;
}
.button--antiman.button--inverted::after {
background: #7986cb;
}
.button--antiman.button--inverted-alt::after {
background: #3f51b5;
}
.button--antiman.button--inverted:hover {
color: #7986cb;
}
.button--antiman.button--inverted-alt:hover {
color: #3f51b5;
}
.button--antiman:hover::before {
opacity: 1;
-webkit-transform: scale3d(1, 1, 1);
transform: scale3d(1, 1, 1);
}
.button--antiman:hover::after {
opacity: 0;
-webkit-transform: scale3d(0.8, 0.8, 1);
transform: scale3d(0.8, 0.8, 1); */
/* } */

button {
  margin-top: 3%;
  text-decoration: none;
  color: #f1f0f0;
  background-color: rgba(61, 61, 61, 0.8);
  padding: 1% 2%;
  border-radius: 20px;
  border: 10px solid rgba(61, 61, 61, 0.8);
  font-weight: 550;
  font-size: 20px;
  border-style: none;
  transition: background-color 0.3s ease;
  width: 250px;

}

button:hover {
  color: rgba(61, 61, 61, 0.8);
  background-color: #fff;
  border: 1px solid rgba(61, 61, 61, 0.8);
}
</style>