<template>
    <div class="whole" style="background-color: #ededed; width: auto; height: 100vh;">
       
        <div class="loginbox">
            <h2 style="font-size: 40px; margin-bottom: 2%;">로그인</h2>
            <form action="#" style="height: 70%;">
                <!--작성하지 않아도 문제는 없음-->
                <fieldset>
                    <legend >로그인 구역</legend>
                    <label for="loginid">아이디</label>
                    <input type="text" id="loginid" v-model="user.id" placeholder="아이디를 입력해 주세요">
                    <label for="loginpw">비밀번호</label>
                    <input type="password" id="loginpw" placeholder="비밀번호를 입력해 주세요" v-model="user.password" @keyup.enter="loginUser">
                    <ul>
                       <li ><a href="/join"> <h2>| 첫 방문이신가요? 회원가입</h2></a></li>
                    </ul>
                    <!--데이터를 서버로 전송-->
                    <router-link to="/" @click="loginUser">
                    <a title="Button border lightblue" class="button btnFloat btnLightBlue" style="margin: 3% 35%; background-color: #ededed;">로그인</a>
                </router-link>
                </fieldset>
            </form>
        </div>
    </div>
</template>

<script setup>

import { ref } from 'vue'
import { useUserStore } from '@/stores/user'

const store = useUserStore()

const user = ref({
    id: '',
    password: ''
})


const loginUser = function () {
    store.loginUser(user.value);
    user.value.id = '',
        user.value.password = ''
}

</script>

<style scoped>

/* base - 브라우저 별로 다를 수도 있는 것을 초기화 */
*{ padding: 0; margin: 0; } /* 태그 여백 없앰 */
li{ list-style: none; } /* 기호나 번호를 제거 */
a{ text-decoration: none; } /* 링크텍스트에 밑줄없앰 */
button{ cursor: pointer; } /* 모든 버튼에 마우스손모양 처리 */

/* body설정 */
body{ background-color: #ededed; }

.loginbox{
    width: 1300px; height: 1000px;
    margin: 0 auto; /* 블록요소를 부모영역에서 가운데 처리 */
    
}
.loginbox h2{
    width: 100%; /* 부모영역을 상속 */

    /* 한줄텍스트인 경우만 height와 line-height가 같으면 세로 가운데 처리 */
    height: 100px; line-height: 100px;
    text-align: center; font-size: 20px;
    font-weight: normal;
}
.loginbox form{
    width: 100%; height: 600px;
    background-color: #fff;
    /* 패딩수치를 인사이드 처리 */
    padding: 60px; box-sizing: border-box;
}
.loginbox fieldset{
    border: none; /* 테두리 제거 */ 
}
.loginbox legend{
    /* 요소를 화면 밖으로 처리 */
    position: absolute; left: -999em;

    /* 웹접근성으로 스크린리더기가 읽어줘야 하므로 display: none;을 사용하지 말것 */
}
.loginbox label{
    display: block;
    font-size: 30px; color: #333;
    margin-bottom: 30px; /* 동위선택자와의 간격 조정 */
    padding-left: 52px;
}
.loginbox input{
    display: block;
    width: 100%; height: 80px;
    margin-bottom: 25px; /* 동위선택자와의 간격 조정 */
    border: none; background-color: #ededed;
    padding: 0 50px; /* 앞상하 뒷좌우 */
    box-sizing: border-box; /* 패딩수치를 인사이드 처리 */
    font-size: 25px;
}

.loginbox ul{
    width: 100%;
    text-align: right; /* 글자를 오른쪽으로 처리 */
    margin-bottom: 60px;
}
.loginbox li{
    display: inline-block;
    height: 12px; line-height: 12px;
}
.loginbox li:last-child{
    border-left: 1px solid #333;
    padding-left: 10px; /* 테두리 안쪽 여백 */
    margin-left: 4px; /* 테두리 바깥쪽 여백 */
}
.loginbox a{
    /* 글자관련은 보통 최종태그에 줘야 적용 */
    color: #333; font-size: 12px;

    /* 현재 위치에서 상대적 이동 */
    position: relative; top: -2px;
}
.log{
    display: block;
    width: 220px; height: 50px;
    margin: 0 auto; /* 블록요소가 부모 영역에서 가운데 오기 */
    border: none;
    background-color: #868e96;
    color: #fff; font-size: 14px; font-weight: bold;
}

.whole{
    margin-top: 100px;
    /* padding: 10%; */
    padding-top: 3%;

}
form{
    height: 100%;
}

/* 여기서부터 버튼 부분 */
a.button {
  display: block;
  position: relative;
  float: left;
  width: 120px;
  padding: 0;
  margin: 10px 20px 10px 0;
  font-weight: 600;
  text-align: center;
  line-height: 50px;
  color: #FFF;
  border-radius: 5px;
  transition: all 0.2s ;
}

.btnLightBlue {
  background: #363636;
}

.btnFade.btnLightBlue:hover {
  background: #5c5c5c;
}


.btnLightBlue.btnPush {
  box-shadow: 0px 5px 0px 0px #494949;
}

.btnPush:hover {
  margin-top: 15px;
  margin-bottom: 5px;
}


.btnLightBlue.btnPush:hover {
  box-shadow: 0px 0px 0px 0px #575757;
}

.btnLightBlue.btnBorder {
  box-shadow: 0px 0px 0px 0px #6d6d6d;
}



/* FLOAT */
.btnFloat {
  background: none;
  box-shadow: 0px 0px 0px 0px rgba(0, 0, 0, 0.5);
}

.btnFloat:before {
  content: '로그인';
  display: block;
  position: absolute;
  top: 0;
  left: 0;
  width: 300px;
  height: 70px;
  border-radius: 5px;
  transition: all 0.2s ;
  padding-top: 7%;
  font-size: 20px;
}


.btnLightBlue.btnFloat:before {
  background: #4d4d4d;
}


.btnFloat:before {
  box-shadow: 0px 0px 0px 0px rgba(0, 0, 0, 0.4);
}


.btnFloat:hover:before {
  margin-top: -2px;
  margin-left: 0px;
  transform: scale(1.1,1.1);
  -ms-transform: scale(1.1,1.1);
  -webkit-transform: scale(1.1,1.1);
  box-shadow: 0px 5px 5px -2px rgba(0, 0, 0, 0.25);
}

</style>

