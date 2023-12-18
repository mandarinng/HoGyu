<template>
    <div style="  margin-top: 200px;">
        <h2 style="font-weight: bold;  margin-left: 15%; margin-top: 100px; margin-bottom: 50px; font-size: 55px;"
            class="accordion">결제가 완료되었습니다!</h2>
        <div class="purchase-container">
            <div class="product">
                <!-- 왼쪽 영역 -->
                <div class="left-section">
                    <h2 style="font-weight: bold; font-size: 40px; margin-bottom: 50px;">받는 사람</h2>
                    <div class="input-group">
                        <p style="margin: 20px 0px; margin-right: 30px; font-size: 25px;">이름</p>
                        <span style="margin: 20px 0px; font-size: 25px;">{{ csstore.resultclient.name }}</span>

                    </div>
                    <div class="input-group">
                        <p style=" margin: 20px 0px; margin-right: 30px; font-size: 25px;">전화번호</p>
                        <span style="margin: 20px 0px; font-size: 25px;">{{ csstore.resultclient.phoneNum }}</span>

                    </div>
                    <div style="margin-top: 100px;">
                        <h3 style="font-weight: bold; font-size: 40px; margin-bottom: 50px; ">배송지</h3>
                        <p style="margin: 50px 0px; font-size: 25px;">우편번호 {{ csstore.resultclient.zipcode }}</p>
                        <span style="margin: 30px 0px; font-size: 25px;">{{ csstore.resultclient.addr1 }}</span>
                        <span style="margin: 30px 0px; font-size: 25px;">{{ csstore.resultclient.addr2 }}</span>
                    </div>


                </div>

                <!-- 오른쪽 영역 -->
                <div class="right-section">
                    <h3 style="margin: 20px 0px; font-weight: bold; font-size: 40px;">주문 상세</h3>
                    <div style="display: flex; justify-content: space-around; padding-right: 100px;">
                        <div style="display: flex; justify-content: left; margin-top: 50px; ">
                            <table class="table" style="width: 800px; text-align: center;">
                                <tr>
                                    <th>No.</th>
                                    <th>사진</th>
                                    <th>상품명</th>
                                    <th>개수</th>
                                    <th>가격</th>
                                </tr>
                                <MyCartBuyList v-for="(cart, index) in cstore.cartlist" :key="cart.id" :cart="cart" :index="index" />
                            </table>
                        </div>
                        
                    </div>
                    <div style="text-align: right; margin-right: 80px;">
                        <p style="margin-top: 30px; font-size: 30px; font-weight: bold; color: rgb(61, 61, 61);">배송비 포함 총<span style="color: orange;">{{
                            cstore.totalPrice +3000 }}</span>원</p>
                    </div>
                    <button style="float: right; margin-right: 100px; margin-top: 80px;" @click="goHome">확인</button>

                </div>
            </div>

        </div>

    </div>
</template>

<script setup>

import { useClientsStore } from '@/stores/clients';
import { useCartStore } from '@/stores/cart';
import MyCartBuyList from './MyCartBuyList.vue';
import {useRouter} from 'vue-router'; 

const csstore = useClientsStore()
const cstore = useCartStore()
const router = useRouter()

const goHome = function(){
  router.push({name:'productList'})
}


</script>

<style scoped>
th {
    border-bottom: 1px solid #444444;
    padding: 10px;
    /* margin: auto; */
    font-size: 25px;
}
.radio-input {
    width: 30px;
    height: 30px;
    border: 1px;
    margin: 10px;
}

img {
    width: 200px;
}

.input-buy {
    display: block;
    width: 100%;
    height: 80px;
    margin-bottom: 25px;
    /* 동위선택자와의 간격 조정 */
    border: 1px solid #c2c2c2;
    border-radius: 10px;
    background-color: #ededed;
    padding: 0 30px;
    /* 앞상하 뒷좌우 */
    box-sizing: border-box;
    /* 패딩수치를 인사이드 처리 */
    font-size: 25px;
}

/* p,
  label,
  div,
  h3,
  h4,
  span {
    background-color: #ededed;
  } */
.accordion {
    display: flex;
    flex-direction: column;
    gap: 1.5rem;
}

.purchase-container {

    display: flex;
    justify-content: center;
    align-items: center;
}

.product {
    background-color: #fff;
    display: flex;
    justify-content: space-between;
    width: 1800px;
    max-width: 1800px;
    /* 너비 제한을 추가하여 가로 화면이 너무 넓지 않도록 함 */
    margin: 20px 0;
    padding-top: 50px;
    padding-bottom: 70px;
    border-radius: 10px;
}

.product[data-v-a5fefb02] {
    background-color: #fff;
    display: flex;
    justify-content: space-between;
    width: 100%;
    max-width: 1700px;
    height: auto;
    margin: 20px 0;
    padding-top: 50px;
    padding-bottom: 50px;
}

.left-section {
    margin-left: 200px;
    background-color: #fff;
    padding: 70px 50px;

    border-radius: 8px;
    width: 800px;
}

.input-group,
.payment-options {
    margin-bottom: 20px;


}

.input-group>:not(:first-child):not(.dropdown-menu):not(.valid-tooltip):not(.valid-feedback):not(.invalid-tooltip):not(.invalid-feedback) {
    margin-left: calc(var(--bs-border-width) * -1);
    border-top-left-radius: 10px;
    border-bottom-left-radius: 10px;
}

.right-section {
    /* text-align: center; */
    background-color: #fff;
    width: 900px;
    margin-top: 50px;
    margin-right: 100px;

}

.order-details {
    margin-top: 20px;
    padding-right: 30px;
    margin-left: 20px;
}

button {
    width: 150px;
    height: 50px;
    font-size: 20px;
    padding: 10px 20px;
    background-color: #696969;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    margin: 0px 30px;
}

.addredss-button {
    width: 120px;
    height: 45px;
    font-size: 20px;
    padding: 10px 20px;
    background-color: #696969;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    margin: 0px 30px;
}

button:hover {
    background-color: #383838;
}
</style>
