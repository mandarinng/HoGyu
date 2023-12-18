<template>
    <div class="h">

        

        <!-- start -->
        <div class="back color-2">
            <div class="row columns">
                
                <div class="menu align-center expanded text-center SMN_effect-2">
                    <router-link to="/" data-hover="Home"><img src="@/assets/로고.png" style="width: 170px; "></router-link>
                   
                </div>
            </div>
        </div>
        <!-- // end -->

        <!-- <input type="text" v-model="word" @keyup.enter="getProductSearchList">
        <button @click="getProductSearchList" >search</button> -->


        <div class="input-group mb-3">
            <input type="text" class="form-control input-text" v-model="word" @keyup.enter="getProductSearchList"
                placeholder="검색할 상품을 입력하세요" aria-label="Recipient's username" aria-describedby="basic-addon2">
            <div class="input-group-append">
                <button class="btn btn-outline-warning btn-lg" type="button" @click="getProductSearchList">
                    <img style="width: 40px;" src="@/assets/magnifying-glass.png"></button>
            </div>
        </div>




        <form v-if="!store.logUser.id">
            <!-- <router-link to="/login"><button class="log">로그인</button></router-link>
                <router-link to="/join"><button class="log">회원가입</button></router-link> -->

            <button type="button" @click="login" class="log">&nbsp;&nbsp;&nbsp;<img style="width: 50px;" src="@/assets/log-in.png">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
            <button type="button" @click="join" class="log">&nbsp;&nbsp;&nbsp;<img style="width: 50px;" src="@/assets/add-user.png">&nbsp;&nbsp;&nbsp;</button>
        </form>
        <form v-if="store.logUser.id" class="myuser">
            <div class="pp" @click="Mypage" style="color: #f8f9fa;">
                
                <img style="width: 50px; margin: 20px;" src="@/assets/user.png">
                     <h5>{{ store.logUser.id }}님 반갑습니다</h5>
                &nbsp;&nbsp;</div>
            <button type="button" @click="logout" class="log" style="white-space: nowrap;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img style="width: 50px; margin: 20px;" class="log" src="@/assets/sign-out.png"></button>
            <button type="button" @click="clickCart" class="log"  style="white-space: nowrap;"><img style="width: 50px; margin: 20px;" src="@/assets/shopping-cart.png">&nbsp;&nbsp;&nbsp;</button>
        </form>



    </div>
</template>

<script setup>
import { ref } from 'vue'
import { useUserStore } from '@/stores/user';
import { useProductStore } from '@/stores/product';
import { useClientsStore } from '@/stores/clients';
import { useCartStore } from '@/stores/cart';
import router from '@/router'
const store = useUserStore();
const pStore = useProductStore();
const csstore = useClientsStore();
const cstore = useCartStore();

const login = function () {
    router.push("/login")
}

const join = function () {
    router.push("/join")
}
const logout = function () {
    store.logoutUser()
}
const word = ref('');
const getProductSearchList = function () {
    pStore.getProductSearchList(word.value)
}
const Mypage = function () {
    csstore.getClientList(store.logUser.id)
    csstore.getClientsList(store.logUser.id)

}

const clickCart = function () {
    cstore.getCartList(store.logUser.id)
}

</script>



<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap');

@import url(https://fonts.googleapis.com/css?family=Lato:400,300,700,900);

/* 상단 헤더 바 고정시키려고 한 부분 */
.h {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 1000; 
  
}


a {
    text-decoration: none;
    color: white;
    display: inline-block;
    width: 200px;
    text-align: center;
    font-size: 50px;
    margin-left: 10%;
    /* font-family: 'Do Hyeon', sans-serif; */
    

}

form {
    display: flex;
    justify-content: space-evenly;
    margin: 15px;
    height: 50px;
    width: 10x;
}

.myuser{
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 10px;
}

.pp {
    display: flex;
    height: 100px;
    width: 300px;

    justify-content: center;
    align-items: center;
    white-space:nowrap;

}
.pp h5{
    font-size: 25px;
}

.log {
    /* display: inline-block;
    padding: 10px 20px;
    font-size: 20px;
    font-weight: bold;
    transition: background-color 0.5s, color 0.5s;
    border-radius: 8%;
    margin-top: 20px;
    margin-bottom: 20px; */
    background-color: transparent;
    border: none;
    color: #f8f9fa;
    font-size: 23px;

}

/* .log:hover {
    background-color: #343a40;
    color: #f8f9fa;

} */

.log:hover,
.log:active,
.log:focus {
    color: #fdfdff;
    /* 클릭 시 글자 색을 변경하는 스타일 (선택 사항) */

    text-shadow: 2px 2px 20px rgba(255, 255, 255, 255);
    filter:drop-shadow(2px 2px 20px rgba(255, 255, 255, 255));
}

.h {
    background-color: #414141;
    display: flex;
    justify-content: space-around;
    align-items: center;
    padding-left: 100px;
    padding-right: 100px;
    

}

.btn {
    background-color: #2f2f30;
    /* border-color: #f8f9fa; */
    color: #f8f9fa;
    border-radius: 7%;

}

.btn-outline-warning {
    --bs-btn-border-color: #2f2f30;
    --bs-btn-hover-color: #000;
    --bs-btn-focus-shadow-rgb: 255, 193, 7;
    --bs-btn-active-color: #000;
    --bs-btn-active-bg: #696868;
    --bs-btn-active-border-color: #f7fafc;
    --bs-btn-hover-bg: #f7fafc;
    --bs-btn-hover-border-color: #2f2f30;
}





.btn:hover {
    color: #fff;
}

.input-text{
    background-color: #a6a8a8;
    border-color: #a6a8a8;

}

.input-text:focus {
    box-shadow: 0px 0px 0px;
    border-color: #f7fafc;
    outline: 0px;
}

.form-control {
    border: 1px solid #2f2f30;
}

.input-group {
    margin-top: 20px;
    /* padding-left: 200px;
    padding-right: 200px; */
    width: 40%;
    border-radius: 10%;
    transition: box-shadow 0.3s;
    outline: none;
    /* 클릭 시 브라우저 기본 포커스 효과를 제거합니다. */
   

}

.input-group:active,
.input-group:focus {
    box-shadow: 0 0 20px rgba(255, 255, 255, 255);
    /* 클릭 또는 포커스 시 그림자 효과를 주는 스타일입니다. */
    outline: none;
}

.input-group:hover {
    box-shadow: 0 0 20px rgba(255, 255, 255, 0.7);
    /* 커서가 위치할 때 그림자 효과를 주는 스타일입니다. */
}



.a{
    padding-top: 2%;
    
}



/*
-----------------
Normalizing
-----------------
*/

*, *:after, *:before {
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
}

a:hover, a:focus {
  outline: none;
}



.back {
  padding: 15px 45px 15px 10px;
    margin-right: 50px;
}


.color-2 {
  background: #353535;
}




/*
-----------------
common style
-----------------
*/

.menu a {
  color: rgba(255, 255, 255, 0.8);
  font-family: Lato;
  font-size: 30pt;
  font-weight: 400;
  padding: 25px 80px 25px 20px;
  /**/
  position: relative;
  display: block;
  text-decoration: none;
  text-transform: uppercase;
}

.SMN_effect-2 a:before, .SMN_effect-2 a:after {
  position: absolute;
  top: 100%;
  left: 0;
  width: 100%;
  height: 2px;
  background: rgba(255, 255, 255, 0.5);
  content: '';
  -webkit-transition: -webkit-transform 0.3s;
  -moz-transition: -moz-transform 0.3s;
  transition: transform 0.3s;
  -webkit-transform: scale(10);
  -moz-transform: scale(10);
  transform: scale(1);
}

.SMN_effect-2 a:after {
  opacity: 0;
  -webkit-transition: top 0.3s, opacity 0.3s, -webkit-transform 0.3s;
  -moz-transition: top 0.3s, opacity 0.3s, -moz-transform 0.3s;
  transition: top 0.3s, opacity 0.3s, transform 0.3s;
}

.SMN_effect-2 a:hover:before, .SMN_effect-2 a:hover:after, .SMN_effect-2 a:focus:before, .SMN_effect-2 a:focus:after {
  -webkit-transform: scale(15);
  -moz-transform: scale(15);
  transform: scale(1);
  background: #f8f9fa;
}

.SMN_effect-2 a:hover:after, .SMN_effect-2 a:focus:after {
  top: 0%;
  opacity: 1;
}
</style>
