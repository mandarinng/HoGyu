<template>
    <div class="whole">
        <div class="product">
            <img :src="imgUrl" class="productImg"><br>
            <div class="product-noimg">
                <div class="one">
                    <h2 style="color: #2c2c2c; ">{{ store.product.productName }}</h2>
                </div>
                <hr>
                <div class="one">
                    <h3>판매가 {{ store.product.price }} 원</h3>
                </div>
                <div class="cnt" style="display: flex;flex-direction: row; margin-left: 13%; margin-left: 0px;">
                    <div class="one">
                        <h4>수량 선택 </h4>
                    </div>
                    <div class="one"><input type="number" v-model="cart.cnt" min="1" placeholder="수량"><br></div>
                    <!-- <div class="one">
                        <div class="number-input">
                            <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
                                class="minus"></button>
                            <input type="number" v-model="cart.cnt" class="quantity" min="1" name="quantity" value="1"
                                placeholder="수량">
                            <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
                                class="plus"></button>
                        </div>
                    </div> -->
                </div>
                <div class="one">
                    <h4>배송비 3000원</h4>
                </div>
                <div class="aaa">
                    <div class="one">

                        <h3>혼자 구매시 가격 : {{ price *cart.cnt + 3000 }}</h3>
                    </div>

                    <div class="one">

                        <h3>공동 구매시 가격 : {{ (price*cart.cnt +3000) *0.9  }}</h3>
                    </div>
                </div>
                <br>
                <div class="one"><button type="button" @click="putCart" class="btn btn-outline-secondary"
                        style="width: 100%; height: 50px; font-weight: bolder; font-size: 25px;">장바구니 담기</button><br></div>
                <div class="one"><button type="button" @click="clickBuyAlone" class="btn btn-outline-secondary"
                        style="width: 100%; height: 50px; font-weight: bolder; font-size: 25px;">혼자 구매하기</button><br></div>
                <div class="one"><button type="button" @click="clickBuyTogether" class="btn btn-outline-secondary"
                        style="width: 100%; height: 50px; font-weight: bolder; font-size: 25px;">공동 구매하기</button><br></div>
            </div>
        </div>
        <div class="link">
            <button class="llink"><router-link :to="`/product/${store.product.productId}/explain`">상품
                    상세</router-link></button>
            <button class="llink"><router-link :to="`/product/${store.product.productId}/review`" @click="getReviewList">리뷰
                    보기</router-link></button>
        </div>
        <RouterView />
    </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import { useProductStore } from '@/stores/product';
import { useReviewStore } from '@/stores/review';
import { useUserStore } from '@/stores/user';
import { useClientsStore } from '@/stores/clients';
import { useCartStore } from '@/stores/cart';


const store = useProductStore()
const rstore = useReviewStore()
const ustore = useUserStore()
const csstore = useClientsStore()
const cstore = useCartStore()
const count = ref(1);

const beforePrice = computed(() => count.value * store.product.price + 3000)
const totalPrice = computed(() => (count.value * store.product.price + 3000) * 0.9)

const price = ref(store.product.price)

const props = defineProps({
    product: {
        type: Object,
        default: null,
    }
})



const cart = ref({
    productId: store.product.productId,
    productName: store.product.productName,
    cnt: 1,
    price: store.product.price * count.value,
    img: store.product.img,
    userId: ustore.logUser.id
})


const clickBuyAlone = function () {
    store.clickBuyAlone(cart.value.cnt, ustore.logUser.id)
}

const getReviewList = function () {
    rstore.getReviewList(store.product.productId)
}

const clickBuyTogether = function () {
    csstore.getTogetherList(store.product.productId)
    store.clickBuyTogether(cart.value.cnt, ustore.logUser.id)
}

const putCart = function () {
    cart.value.price = cart.value.cnt * cart.value.price
    cstore.putCart(cart.value, ustore.logUser.id)
}


const imgUrl = computed(() => {
    return new URL(`../../assets/` + store.product.img, import.meta.url);
});

</script>

<style scoped>
.whole {
    margin-top: 100px;
    /* background-color: #ededed; */
    padding-top: 3%;
    padding-left: 15%;
    padding-right: 7%;
    /* overflow-x: hidden; */
    /* width:; */

}

.product {
    display: flex;
    text-align: center;
    padding-left: 200px;
    padding-right: 200px;
}

.product-noimg {
    padding-top: 20px;
    padding-left: 10%;
    /* padding-left: 500px; */
    flex-direction: column;
    text-align: left;
    color: #5a5a5a;


}

.productImg {
    margin-top: 20px;
    width: 800px;
    height: 900px;
    object-fit: cover;
    padding: 1%;
}

h2 {
    font-weight: bolder;
}

.one {
    white-space: nowrap;
    margin: 30px;
}

.cnt {
    flex-direction: row;
    display: flex;
    align-items: center;

}


.one input {
    border: none;
    border-radius: 15px;
    background-color: #e4e3e389;
    height: 50px;
    border-bottom: 1px solid rgb(61, 61, 61);
    padding-left: 25px;
    font-size: 1.5rem;
    /* outline: none; */
}



.aaa {
    /* border: 1px solid #5a5a5a; */
    border-radius: 15px;
    margin-right: 2%;
}


#bbtn {
    width: 100px;
}

a {
    text-decoration: none;
    color: #5a5a5a;
    /* display: flex; */
    justify-content: center;
    white-space: nowrap;
    width: 100px;
    text-align: center;
    font-size: 30px;

    /* font-family: 'Do Hyeon', sans-serif; */
    /* margin-left: 10%; */
    /* margin-right: 500px; */

}


.link {
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    margin-left: 1%;
    margin-right: 13%;

}

.llink {
    margin-top: 3%;
    /* background-color: #707070; 버튼 배경색 */
    /* color: #fff; 버튼 텍스트 색상 */
    padding: 10px 20px;
    /* 내용과 테두리 간의 간격 */
    border: none;
    /* 테두리 제거 */
    /* border-radius: 15px; 둥근 테두리 반지름 */
    cursor: pointer;
    /* 커서를 손가락 형태로 변경 */
    transition: background-color 0.3s ease;
    /* 배경색 변화에 부드러운 효과 추가 */
    border-bottom: 1px solid #5a5a5a;
    background-color: #ededed;



}</style>