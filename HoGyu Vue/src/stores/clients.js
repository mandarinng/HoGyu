import { ref } from 'vue'
import { defineStore } from 'pinia'
import {useRouter} from 'vue-router'
import axios from 'axios'
import { useCartStore } from './cart'

export const useClientsStore = defineStore('clients', () => {
  const cstore = useCartStore()
  const router = useRouter();
  const URL = "http://localhost:8080/api"

  const ClientsList = ref([])
  
  const getTogetherList = function(productId){
    axios({
      url: URL+"/clients",
      method: "Get",
      params: {
        productId: productId
      }
    })
    .then((res)=>{
        ClientsList.value = res.data
        console.log(ClientsList.value)
    })
  }
  const order = ref(10)
  const togetherBuyStart = function(){
    order.value++;
    console.log(order.value)
    router.push({name: "TogetherStart"})
  }

  const clients = ref({})
  const clickJoin = function(orderId){
    axios.get(`${URL}/clients/${orderId}`)
    .then((res)=>{
        clients.value = res.data
        console.log(clients.value)
        router.push({name: 'TogetherJoin'})
    })
  }

  const updateClients = function(orderId){
    axios.put(`${URL}/clients/${orderId}`)
    .then(()=>{
    })
  }

  const buyResult = ref({})
  const buyTogether = function(clients){
    console.log(clients)
    axios.post(`${URL}/clients`,clients)
    .then(()=>{
      buyResult.value = clients
      console.log('들어갔나??')
      console.log(buyResult.value)
      router.push({name: 'complete'})
  })
  }
  const Client = ref({})
  const complete = function(client){
    axios.post(`${URL}/client`,client)
    .then(()=>{
      Client.value = client
      console.log('들어갔나??')
      console.log(Client.value)
      router.push({name: 'completeAlone'})
  })
  }

  

  const clientBuyList = ref([])
  const getClientList = function(userId){
    axios.get(`${URL}/order/${userId}`)
    .then((res)=>{
      clientBuyList.value = res.data
    })
  }
  const clientsBuyList = ref([])
  const getClientsList = function(userId){
    axios.get(`${URL}/orders/${userId}`)
    .then((res)=>{
      clientsBuyList.value = res.data
      router.push({name: 'mypage'})
    })
  }

  const user = ref({})
  const buyMyCart = function(user){
    user.value = user
    console.log(user.value)
    for(let cart of cstore.cartlist){
      const client = ref({
        userId: user.value.userId,
        name: user.value.name,
        phoneNum: user.value.phoneNum,
        zipcode: user.value.zipcode,
        addr1: user.value.addr1,
        addr2: user.value.addr2,
        productId: cart.productId,
        productName: cart.productName,
        cnt: cart.cnt,
        totalPrice: cart.price
      })
      console.log(client)
      result(client.value)
    }
    router.push({name: 'completecart'})
  }

  const resultclient = ref({})
  const result = function(client){
    console.log(client)
    axios.post(`${URL}/client`,client)
    .then(()=>{
      resultclient.value = client
      console.log('들어갔나??')
      console.log(Client.value)
   
    })
  }

 

  return {getTogetherList, ClientsList,togetherBuyStart,clickJoin,clients,buyTogether,
    buyResult,updateClients,order, Client,complete,clientBuyList,getClientList,
    clientsBuyList,getClientsList,buyMyCart,user,result,resultclient}
},{persist: true})

