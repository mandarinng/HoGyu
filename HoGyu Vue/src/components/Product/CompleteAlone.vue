<template>
    <div style="  margin-top: 200px;">
        <h2 style="font-weight: bold;  margin-left: 21%; margin-top: 100px; margin-bottom: 50px; font-size: 55px;"
            class="accordion">결제가 완료되었습니다!</h2>
        <div class="purchase-container">
            <div class="product">
                <!-- 왼쪽 영역 -->
                <div class="left-section">
                    <h2 style="font-weight: bold; font-size: 40px;">받는 사람</h2>
                    <div class="input-group">
                        <p style="margin-top: 20px; margin-right: 30px; font-size: 25px;">이름</p>
                        <span style="margin: 20px 0px; font-size: 25px;">{{ csstore.Client.name }}</span>
                        <!-- <input class="input-buy" type="text" v-model="client.name"> -->
                    </div>
                    <div class="input-group">
                        <p style=" margin-right: 30px; font-size: 25px;">전화번호</p>
                        <span style="margin-bottom: 20px; font-size: 25px;">{{ csstore.Client.phoneNum }}</span>
                        <!-- <input class="input-buy" type="text" v-model="client.phoneNum"> -->
                    </div>
                    <div>
                        <h3 style="font-weight: bold; font-size: 40px;">배송지</h3>
                        <p style="margin: 30px 0px; font-size: 25px;">{{ csstore.Client.zipcode }}</p>
                        <span style="margin: 20px 0px; font-size: 25px;">{{ csstore.Client.addr1 }}</span>
                        <span style="margin: 20px 0px; font-size: 25px;">{{ csstore.Client.addr2 }}</span>
                    </div>


                </div>

                <!-- 오른쪽 영역 -->
                <div class="right-section">
                    <h3 style="margin: 20px 0px; font-weight: bold; font-size: 40px;">주문 상세</h3>
                    <div style="display: flex; justify-content: space-around; padding-right: 100px;">
                        <img :src="imgUrl" /><br>
                        <div class="order-details">
                            <h4 style="margin-top: 20px; font-size: 25px; font-weight: bold;">{{ store.product.productName
                            }}</h4>
                            <p style="margin: 20px 0px; font-size: 25px;">총 {{ store.cnt }} 개</p>
                            <p style="margin: 20px 0px; font-size: 25px;">개당 {{ store.product.price }}원</p>

                        </div>
                    </div>
                    <div style="text-align: right; margin-right: 80px;">
                        <p style="margin-top: 40px; font-size: 30px; font-weight: bold; color: rgb(61, 61, 61);">배송비 포함 총<span style="color: orange;">{{
                            csstore.Client.totalPrice }}</span>원</p>
                    </div>
                    <button style="float: right; margin-right: 100px; margin-top: 80px;" @click="goHome">확인</button>

                </div>
            </div>

        </div>

    </div>
</template>

<script setup>
import { computed } from 'vue'
import { useProductStore } from '@/stores/product';
import { useClientsStore } from '@/stores/clients';
import { useRouter } from 'vue-router'
const store = useProductStore()
const csstore = useClientsStore()
const router = useRouter()

const imgUrl = computed(() => {
    return new URL(`../../assets/` + store.product.img, import.meta.url);
});

const goHome = function () {
    router.push({ name: 'productList' })
}


</script>

<style scoped>
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
    width: 100%;
    max-width: 1500px;
    /* 너비 제한을 추가하여 가로 화면이 너무 넓지 않도록 함 */
    margin: 20px 0;
    padding-top: 50px;
    padding-bottom: 70px;
    border-radius: 10px;
}

.left-section {
    margin-left: 200px;
    background-color: #fff;
    padding: 70px 50px;

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