import { ref } from 'vue'
import { defineStore } from 'pinia'
import { useRouter } from 'vue-router'
import axios from 'axios'

export const useUserStore = defineStore('user', () => {
  const count = ref(0)
  const router = useRouter();
  const URL = "http://localhost:8080/api"


  const createUser = function (user) {
    console.log(user.id)
    axios({
      url: URL + "/user",
      method: "Post",
      data: user,
    })
      .then((res) => {
        router.push({ name: 'login' })
      })
      .catch((err) => {
        alert('아이디가 중복되어 회원가입이 불가합니다.')
      })

  }
  const logUser = ref({})

  const loginUser = function (user) {
    axios({
      url: URL + "/user/login",
      method: "post",
      data: user
    })
      .then((res) => {
        console.log('나와라')
        console.log(res)
        logUser.value = res.data
        router.push({ name: 'home' })
      })
      .catch((err) => {

        alert('로그인 실패. 다시 시도해 주세요.')
        console.log(err)
      })
  }

  const logoutUser = function(){
    logUser.value={}
  }

  return { createUser, loginUser, logoutUser, logUser, }
}, { persist: true })
