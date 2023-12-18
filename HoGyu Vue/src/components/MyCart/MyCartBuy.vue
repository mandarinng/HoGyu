<template>
  <div style="  margin-top: 200px;">
      <h2 style="font-weight: bold;  margin-left: 15%; margin-top: 100px; font-size: 55px;" class="accordion">장바구니 결제하기
      </h2>
      <div class="purchase-container">
          <div class="product">
              <!-- 왼쪽 영역 -->
              <div class="left-section">
                  <h2 style="font-weight: bold; font-size: 40px;">받는 사람</h2>
                  <div class="input-group">
                      <h4 style="margin: 20px 0px; font-size: 25px;">이름</h4>
                      <input class="input-buy" type="text" v-model="user.name">
                  </div>
                  <div class="input-group">
                      <h4 style="margin: 20px 0px; font-size: 25px;">전화번호</h4>
                      <input class="input-buy" type="text" v-model="user.phoneNum">
                  </div>

                  <div class="daummap">
                      <div ref="embed"></div>
                      <span>
                          <h4 style="margin-top: 100px; font-weight: bold; font-size: 40px;">주소 <button
                                  class="addredss-button" @click="showApi">주소찾기 &nbsp;&nbsp;&nbsp;</button></h4>
                      </span>
                      <!-- <button @click="showApi">주소찾기</button> -->
                      <p style="margin: 40px 0px; font-size: 25px;">우편번호: <span
                              style="font-size: 25px; margin: 0px 10px;">{{ zip
                              }}</span></p>
                      <p style="margin: 40px 0px; font-size: 25px;">기본주소:
                          <span style="font-size: 25px;">{{ addr1 }}</span>
                      </p>
                      <p style="margin: 40px 0px; font-size: 25px;">상세주소:</p>
                      <!-- <textarea class="input-buy" v-model="client.addr2"></textarea> -->
                      <input class="input-buy" type="text" v-model="user.addr2" placeholder="동/호수를 입력해 주세요">
                  </div>
              </div>

              <!-- 오른쪽 영역 -->
              <div class="right-section">
                  <h4 style="font-weight: bold; font-size: 40px; margin-top: 10px;">결제 수단</h4>
                  <div class="payment-options">
                      <label style="margin: 20px 0px; font-size: 25px;"><input class="radio-input" type="radio"
                              v-model="payment" value="계좌 결제" name="pay">계좌 결제</label>
                      <label style="margin: 20px 0px; font-size: 25px;"><input class="radio-input" type="radio"
                              v-model="payment" value="카드 결제" name="pay">카드 결제</label>
                  </div>

                  <h3 style="margin: 10px 0px; font-weight: bold; font-size: 40px;">주문 상세</h3>
                  <div style="display: flex; justify-content: left; margin: 70px 0px; ">
                      <table class="table" style="width: 800px; text-align: center;">
                          <tr>
                              <th>No.</th>
                              <th>사진</th>
                              <th>상품명</th>
                              <th>개수</th>
                              <th>가격</th>
                          </tr>
                          <MyCartBuyList v-for="(cart, index) in cstore.cartlist" :key="cart.id" :cart="cart"
                              :index="index" :user="user" />
                      </table>
                  </div>
                  <div style="text-align: right;">
                      <div class="order-details">
                          <p style="margin: 20px 0px; font-size: 25px;">총 합{{ cstore.totalPrice }} 원</p>
                          <p style="margin: 20px 0px; font-size: 25px;">배송비 3000원</p>

                      </div>
                      <p style="margin-top: 20px; font-size: 30px; font-weight: bold; color: rgb(61, 61, 61);">배송비 포함 총
                          <span style="color:orange;">{{cstore.totalPrice + 3000 }}</span>원</p>
                  </div>
                  <br>
                  <div style="text-align: right;">
                      <button style="margin: 0;" @click="buyMyCart">결제 하기</button>
                  </div>

              </div>
          </div>

      </div>

  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useCartStore } from '@/stores/cart';
import MyCartBuyList from './MyCartBuyList.vue';
import { useUserStore } from '@/stores/user'
import { useClientsStore } from '@/stores/clients'


const ustore = useUserStore()
const csstore = useClientsStore()

const zip = ref('')
const addr1 = ref('')


const user = ref({
  name: ustore.logUser.name,
  phoneNum: ustore.logUser.phoneNum,
  zipcode: zip.value,
  addr1: addr1.value,
  addr2: '',
  userId: ustore.logUser.id,
})

const cstore = useCartStore()

const buyMyCart = function () {
  csstore.buyMyCart(user.value)
}


const showApi = () => {
  new window.daum.Postcode({
      oncomplete: (data) => {
          let fullRoadAddr = data.roadAddress;
          let extraRoadAddr = '';

          if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
              extraRoadAddr += data.bname;
          }

          if (data.buildingName !== '' && data.apartment === 'Y') {
              extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
          }

          if (extraRoadAddr !== '') {
              extraRoadAddr = ' (' + extraRoadAddr + ')';
          }

          if (fullRoadAddr !== '') {
              fullRoadAddr += extraRoadAddr;
          }

          zip.value = data.zonecode;
          addr1.value = fullRoadAddr;
          user.value.zipcode = zip.value;
          user.value.addr1 = addr1.value;
      }
  }).open()
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
  margin-top: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.product {
  background-color: #fff;
  display: flex;
  justify-content: space-between;
  width: 100%;
  max-width: 1800px;
  height: auto;
  padding:70px 100px;
  /* 너비 제한을 추가하여 가로 화면이 너무 넓지 않도록 함 */
  margin: 20px 0;
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
  width: 800px;
  margin-top: 50px;
 

}

.order-details {
  margin-top: 20px;
  /* padding-right: 30px; */
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