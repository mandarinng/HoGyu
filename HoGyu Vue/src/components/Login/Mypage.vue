<template>
    <div style="background-color: #ededed; width: auto; display: flex; justify-content: center; margin-top: 100px;">
        
        <ul class="accordion" style="margin-left: 20%; margin-right: 20%; margin-bottom: 200px; ">
            <h2 style="font-weight: bold; margin-top: 100px;">MY PAGE</h2>
            <div>
                <img style="width: 100px; margin: 20px;" src="https://laghettohoteis.com.br/wp-content/uploads/2021/06/User-Icon-Grey-300x300-1.png">
                <span class="hi">{{ ustore.logUser.id }}님, 안녕하세요</span>
            </div>
            <p style="font-size: 20px; font-weight: 550;">{{ ustore.logUser.id }}님의 OO마켓 이용정보를 확인해보세요!</p>
            <h4>개인정보</h4>
            <span class="target" id="accordion"></span>
            <li class="accordion__li">
                <span class="target" id="accordion1"></span>
                <a href="#accordion1" class="open-accordion" title="open">
                    <div>
                        <div>
                            <span class="accordion__num"><img style="width: 50px;"
                                    src="https://cdn-icons-png.flaticon.com/512/3364/3364044.png"></span>
                            <h5 class="accordion__title">
                                {{ ustore.logUser.id }} 님의 정보
                            </h5>
                        </div>
                        <i class="fas fa-chevron-down"></i>
                    </div>
                </a>
                <a href="#accordion" class="close-accordion" title="close">
                    <div>
                        <div>
                            <span class="accordion__num"><img style="width: 50px;"
                                    src="https://cdn-icons-png.flaticon.com/512/3364/3364044.png"></span>
                            <h5 class="accordion__title">
                                {{ ustore.logUser.id }} 님의 정보
                            </h5>
                        </div>
                        <i class="fas fa-chevron-up"></i>
                    </div>
                </a>
                <div class="accordion__content-container">
                    <p class="accordion__content">
                    <p>이름: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{ ustore.logUser.name }}</p>
                    <p>전화번호: &nbsp; {{ ustore.logUser.phoneNum }}</p>
                    </p>
                </div>
            </li>
            <hr>
            <h4>주문내역</h4>
            <li class="accordion__li">
                <span class="target" id="accordion2"></span>
                <a href="#accordion2" class="open-accordion" title="open">
                    <div>
                        <div>
                            <span class="accordion__num"><img style="width: 50px;"
                                    src="https://cdn-icons-png.flaticon.com/512/263/263142.png"></span>
                            <h5 class="accordion__title">
                                혼자구매
                            </h5>
                        </div>
                        <i class="fas fa-chevron-down"></i>
                    </div>
                </a>
                <a href="#accordion" class="close-accordion" title="close">
                    <div>
                        <div>
                            <span class="accordion__num"><img style="width: 50px;"
                                    src="https://cdn-icons-png.flaticon.com/512/263/263142.png"></span>
                            <h5 class="accordion__title">
                                혼자구매
                            </h5>
                        </div>
                        <i class="fas fa-chevron-up"></i>
                    </div>
                </a>
                <div class="accordion__content-container">
                    <p class="accordion__content">
                    <p v-if="csstore.clientBuyList.length == 0">혼자 구매한 상품이 없습니다.</p>
                    <table v-if="csstore.clientBuyList.length > 0" class="table" style="text-align: center;">
                        <tr>
                            <th>No.</th>
                            <th>주문번호</th>
                            <th>구매품목</th>
                            <th>개수</th>
                            <th>가격</th>
                        </tr>
                        <MypageAlone v-for="(client, index) in csstore.clientBuyList" :key="client.id" :client="client"
                            :index="index" />
                    </table>
                    </p>
                </div>
            </li>
            <li class="accordion__li">
                <span class="target" id="accordion3"></span>
                <a href="#accordion3" class="open-accordion" title="open">
                    <div>
                        <div class="title">
                            <span class="accordion__num"><img style="width: 50px;"
                                    src="https://cdn-icons-png.flaticon.com/512/2521/2521894.png"></span>
                            <h5 class="accordion__title">
                                공동구매
                            </h5>
                        </div>
                        <i class="fas fa-chevron-down"></i>
                    </div>
                </a>
                <a href="#accordion" class="close-accordion" title="close">
                    <div>
                        <div class="title">
                            <span class="accordion__num"><img style="width: 50px;"
                                    src="https://cdn-icons-png.flaticon.com/512/2521/2521894.png"></span>
                            <h5 class="accordion__title">
                                공동구매
                            </h5>
                        </div>
                        <i class="fas fa-chevron-up"></i>
                    </div>
                </a>
                <div class="accordion__content-container">
                    <p class="accordion__content">
                    <p v-if="csstore.clientsBuyList.length == 0">공동 구매한 상품이 없습니다.</p>
                    <table v-if="csstore.clientsBuyList.length > 0" class="table" style="text-align: center;">
                        <tr>
                            <th>No.</th>
                            <th>주문번호</th>
                            <th>구매품목</th>
                            <th>개수</th>
                            <th>가격</th>
                        </tr>
                        <MypageTogether v-for="(clients, index) in csstore.clientsBuyList" :key="clients.id"
                            :clients="clients" :index="index" />
                    </table>
                    </p>
                </div>
            </li>
        </ul>
    </div>
</template>

<script setup>
import { useUserStore } from '@/stores/user'
import { useClientsStore } from '@/stores/clients'
import { useCartStore } from '@/stores/cart'



import MypageAlone from './MypageAlone.vue';
import MypageTogether from './MypageTogether.vue';
// import MypageTogether from './MypageTogether.vue';
const ustore = useUserStore()
const csstore = useClientsStore()
const cstore = useCartStore()





</script>

<style scoped>
.hi {
    font-size: 30px;
    font-weight: bold;
}

html {
    font-size: 62.5%;
}

h5,
p {
    margin: 10px;
}

a {
    text-decoration: none;
    color: inherit;
}

ul {
    list-style: none;
}

body {
    margin: 0;
    padding: 0;
    background: black;
}

.target {
    display: block;
    top: 0;
    left: 0;
    position: fixed;
}

.open-accordion {
    display: block;
}

.close-accordion {
    display: none;
}

:target~.open-accordion {
    display: none;
}

:target~.close-accordion {
    display: block;
}

.accordion {
    display: flex;
    flex-direction: column;
    gap: 1.5rem;
}

.accordion__li {
    width:1300px;
    background: white;
    border-radius: 0.4rem;
    padding: 1rem;
}
.table {
    width: 1300px;
    border-radius: 0.4rem;
    padding: 1rem;

}
th{
    border-bottom: 1px solid #444444;
    padding: 10px;
    margin: auto;
  }

.accordion__li a>div {
    display: flex;
    justify-content: space-between;
    align-items: center;
    cursor: pointer;
}

.accordion__li a>div div {
    display: flex;
    align-items: center;
}

.accordion__num {
    font-size: 1.8rem;
    margin-right: 1.3rem;
}

.accordion__title {
    font-size: 1.6rem;
}

.accordion__li i {
    font-size: 1.3rem;
    position: relative;
    top: 0.1rem;
    right: 0.5rem;
}

/* When accordion is open */

.accordion__content-container {
    max-height: 0;
    overflow: hidden;
    transition: all 0.3s ease-in-out;
}

:target~.accordion__content-container {
    max-height: 20rem;
    /* set it longer than expected height of content */
}

.accordion__content {
    font-size: 1.2rem;
    line-height: 1.5;
    transform: translateY(-100%);
    transition: all 0.3s ease-in-out;
}

:target~.accordion__content-container .accordion__content {
    padding-top: 1rem;
    transform: translateY(0);
}
.title:focus {

box-shadow: 0 0 0 3px purple;
background: #444444;

}
</style>