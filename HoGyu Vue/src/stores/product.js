import { ref} from 'vue'
import { defineStore } from 'pinia'
import {useRouter} from 'vue-router'
import axios from 'axios'

export const useProductStore = defineStore('product', () => {
  
  const router = useRouter();
  const URL = "http://localhost:8080/api"

  const productFoodList = ref([])
  const productWearList = ref([])
  const productMachList = ref([])

  const getProductFoodList = function(){
    axios({
      url: URL+"/product",
      method: "Get",
      params: {
        category: "식품"
      }
    })
    .then((res)=>{
      productFoodList.value = res.data
    })
  }

  const getProductWearList = function(){
    axios({
      url: URL+"/product",
      method: "Get",
      params: {
        category: "의류"
      }
    })
    .then((res)=>{
      productWearList.value = res.data
    })
  }

  const getProductMachList = function(){
    axios({
      url: URL+"/product",
      method: "Get",
      params: {
        category: "기구"
      }
    })
    .then((res)=>{
      productMachList.value = res.data
    })
  }

  const product = ref({})
  const productDetail = function(productId){
    axios.get(`${URL}/product/${productId}`)
    .then((res)=>{
        product.value = res.data
        router.push({name: 'productExplain' ,  params: {productId: productId}})
    })
  }

  const productSearchList = ref([])
  const getProductSearchList = function(word){
    console.log(word)
    axios.get(`${URL}/search/`+word)
    .then((res)=>{
      productSearchList.value = res.data
      router.push({name: 'productSearchList' ,  params: {word: word}})
    })
  }

  const cnt = ref(1)

  const clickBuyAlone = function(count,id){
    cnt.value=count;
    if(id){
    router.push({name: "buyalone"})
    }
    else{
      alert("로그인 후 구매해주세요.")
    }
  }

  const clickBuyTogether = function(count,id){
    cnt.value=count;
    if(id){
    router.push({name: "TogetherList"})
    }
    else{
      alert("로그인 후 구매해주세요.")
    }
  }

  return { productFoodList, productWearList, productMachList,
     getProductFoodList, getProductWearList, getProductMachList,
      product, productDetail, cnt, clickBuyAlone,productSearchList,getProductSearchList, clickBuyTogether}
},{persist: true})
