<template>
    <div style="  margin-top: 200px;">
        <h2 style="font-weight: bold;  margin-left: 21%; margin-top: 100px; font-size: 55px;" class="accordion">공동 구매 참여하기
        </h2>
        <div class="purchase-container">
            <div class="product">
                <!-- 왼쪽 영역 -->
                <div class="left-section">
                    <h2 style="font-weight: bold; font-size: 40px;">받는 사람</h2>
                    <div class="input-group">
                        <h4 style="margin: 20px 0px; font-size: 25px;">이름</h4>
                        <input class="input-buy" type="text" v-model="clients.name">
                    </div>
                    <div class="input-group">
                        <h4 style="margin: 20px 0px; font-size: 25px;">전화번호</h4>
                        <input class="input-buy" type="text" v-model="clients.phoneNum">
                    </div>
                    <div>
                        <h2 style="font-weight: bold; font-size: 40px;">배송 위치</h2>
                        <p style="font-size: 30px; margin-top: 30px;">{{ clients.address }}</p>
                    </div>
                    <h4 style="font-weight: bold; font-size: 40px; margin-top: 80px;">결제 수단</h4>
                    <div class="payment-options">
                        <label style="margin: 20px 0px; font-size: 25px;"><input class="radio-input" type="radio"
                                v-model="payment" value="계좌 결제" name="pay">계좌 결제</label>
                        <label style="margin: 20px 0px; font-size: 25px;"><input class="radio-input" type="radio"
                                v-model="payment" value="카드 결제" name="pay">카드 결제</label>
                    </div>
                </div>

                <!-- 오른쪽 영역 -->
                <div class="right-section">
                    <h3 style="margin: 40px 0px; font-weight: bold; font-size: 40px;">주문 상세</h3>
                    <div style="display: flex; justify-content: space-around; padding-right: 100px;">
                        <img :src="imgUrl" /><br>
                        <div class="order-details">
                            <h4 style="margin-top: 20px; font-size: 25px; font-weight: bold;">{{ pstore.product.productName
                            }}</h4>
                            <p style="margin: 20px 0px; font-size: 25px;">총 {{ pstore.cnt }} 개</p>
                            <p style="margin: 20px 0px; font-size: 25px;">개당 {{ pstore.product.price }}원</p>

                        </div>
                    </div>
                    <div style="text-align: right; margin-right: 100px; margin-top: 100px;">
                        <p style="margin: 30px 0px; font-size: 25px;">혼자 구매시 가격 : {{ beforePrice }}원</p>
                        <p style="margin: 30px 0px; font-size: 30px; font-weight: bold; color: rgb(61, 61, 61);">공동 구매 가격 : <span style="color: orange;">{{ totalPrice }}</span>원</p>
                    </div>
                    <br>
                    
                    <button class="button-buy" style=" margin-right: 100px;  border-radius: 10px;" @click="buyTogether">공동구매하기</button>
                </div>
            </div>

        </div>

    </div>
</template>

<script setup>
import { useProductStore } from '@/stores/product';
import { useClientsStore } from '@/stores/clients';
import { useUserStore } from '@/stores/user';
import { ref, computed } from 'vue'

const pstore = useProductStore()
const csstore = useClientsStore()
const ustore = useUserStore()

const imgUrl = computed(() => {
    return new URL(`../../assets/` + pstore.product.img, import.meta.url);
});

const beforePrice = computed(() => pstore.cnt * pstore.product.price + 3000)
const totalPrice = computed(() => (pstore.cnt * pstore.product.price + 3000) * 0.9)

const clients = ref({
    orderId: csstore.clients.orderId,
    userId: ustore.logUser.id,
    name: ustore.logUser.name,
    phoneNum: ustore.logUser.phoneNum,
    address: csstore.clients.address,
    productId: csstore.clients.productId,
    productName: csstore.clients.productName,
    cnt: pstore.cnt,
    totalPrice: totalPrice.value,
    partner: csstore.clients.partner+1
})

const buyTogether = function () {
    console.log(clients.value)
    csstore.updateClients(csstore.clients.orderId);
    csstore.buyTogether(clients.value)
}

</script>

<style scoped>
.button-buy {
  width: 500px;
  height: 100px;
  font-size: 20px;
  padding: 10px 0px;
  background-color: #696969;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 30px;
  margin-top: 70px;
  margin-left: 30px;

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
    padding-bottom: 50px;
}

.product {
    background-color: #fff;
    display: flex;
    justify-content: space-between;
    width: 100%;
    max-width: 1500px;
    height: auto;
    /* 너비 제한을 추가하여 가로 화면이 너무 넓지 않도록 함 */
    margin: 20px 0;
    padding-top: 50px;
    padding-bottom: 50px;
    border-radius: 10px;
}

.left-section {

    background-color: #fff;
    padding: 70px;
    border-radius: 8px;
    width: 700px;
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
    width: 700px;
    margin-top: 40px;

}

.order-details {
    margin-top: 20px;
    padding-right: 30px;

}

button {
    width: 200px;
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