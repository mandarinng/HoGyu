<template>
  <tr>
      <td>{{ index + 1 }}</td>
      <td><img :src="imgUrl" style="width:200px"></td>
      <td>{{ cart.productName }}</td>
      <td>{{ cart.cnt }}</td>
      <td>{{ cart.price }}</td>

      <div class="box bg-1">
        <button style="width: 100px; margin: 80px 0;" class="button button--winona button--border-thin button--round-s" @click="deleteCart" data-text="삭제하기"><span style="padding 5px">삭제하기</span></button>
      </div>
  </tr>
</template>

<script setup>

import { computed } from 'vue'

import {useCartStore} from '@/stores/cart'
const cstore = useCartStore()

const props = defineProps({
  cart: {
      type: Object,
      default: null,
  },
  index: {
      type: Number,

  }
})

const imgUrl = computed(() => {
return new URL(`../../assets/`+props.cart.img,import.meta.url);
});

const deleteCart = function(){
  console.log(props.cart.id)
  cstore.deleteCart(props.cart.id, props.cart.userId)
}

</script>

<style scoped>
td{
font-size: 25px;
}
tr{
  line-height: 5rem;
  border-bottom: 1px solid #c0c0c0;
}

.button {
float: left;
min-width: 130px;
max-width: 100px;

display: block;
margin: 1em;
padding: 5px;
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
.button > span {
vertical-align: middle;
}

/* Text color adjustments (we could stick to the "inherit" but that does not work well in Safari) */
.bg-1 .button {
color: #424242;
border-color: #4b4b4b;
}
.button--round-s {
border-radius: 5px;
}
.button--border-thin {
border: 1px solid;
}
.button--winona {
overflow: hidden;
padding: 0;
-webkit-transition: border-color 0.3s, background-color 0.3s;
transition: border-color 0.3s, background-color 0.3s;
-webkit-transition-timing-function: cubic-bezier(0.2, 1, 0.3, 1);
transition-timing-function: cubic-bezier(0.2, 1, 0.3, 1);
}
.button--winona::after {
content: attr(data-text);
position: absolute;
width: 100%;
height: 100%;
top: 0;
left: 0;
opacity: 0;
color: #3e3e3e;
-webkit-transform: translate3d(0, 25%, 0);
transform: translate3d(0, 25%, 0);
}
.button--winona > span {
display: block;
}
.button--winona.button--inverted {
color: #c7c7c7;
}
.button--winona.button--inverted:after {
color: #fff;
}
.button--winona::after,
.button--winona > span {
padding: 7px 3px;
-webkit-transition: -webkit-transform 0.3s, opacity 0.3s;
transition: transform 0.3s, opacity 0.3s;
-webkit-transition-timing-function: cubic-bezier(0.2, 1, 0.3, 1);
transition-timing-function: cubic-bezier(0.2, 1, 0.3, 1);
}
.button--winona:hover {
border-color: #aeaeae;
background-color: rgba(195, 195, 195, 0.1);
}
.button--winona.button--inverted:hover {
border-color: #474747;
background-color: #21333C;
}
.button--winona:hover::after {
opacity: 1;
-webkit-transform: translate3d(0, 0, 0);
transform: translate3d(0, 0, 0);
}
.button--winona:hover > span {
opacity: 0;
-webkit-transform: translate3d(0, -25%, 0);
transform: translate3d(0, -25%, 0);
}


</style>
