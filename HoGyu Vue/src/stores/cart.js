import { ref } from 'vue'
import { defineStore } from 'pinia'
import {useRouter} from 'vue-router'
import axios from 'axios'

export const useCartStore = defineStore('cart', ()=>{

    const URL = "http://localhost:8080/api"
    
    // const reviewList = ref([])
    const router = useRouter()
    const totalPrice = ref(0);

    const cartlist = ref([])
    const getCartList = function(userId){
        console.log(userId)
        axios.get(`${URL}/cart/${userId}`)
        .then((res)=>{
            totalPrice.value = 0; 
            cartlist.value = res.data
            console.log(cartlist.value)
            router.push({name: 'myCart'})
        })
    }
    const putCart = function(cart, userId){
        axios.post(`${URL}/cart`, cart)
        .then(()=>{
            getCartList(userId)
            router.push({name:"myCart"})
        })
    }


    const deleteCart = function(cartId, userId){
        axios.delete(`${URL}/cart/${cartId}`)
        .then(()=>{
            getCartList(userId)
            router.push({name: "myCart"})
        })
    }

    const buyCart = function(){
        router.push({name: "myCartBuy"})
    }

  
    const addTotalPrice = function(){
        for(let cart of cartlist.value){
            totalPrice.value = totalPrice.value+cart.price
        }
        console.log('계산')
        console.log(totalPrice.value)
    }




    return {cartlist, getCartList, deleteCart,buyCart, addTotalPrice,totalPrice,putCart }
},{persist: true})
