<template>
    <div class="whole">
        <div class="product">
            <img :src="reviewImg" v-show="reviewImg" class="shadow productImg">
            <img src="@/assets/no-image.png" v-show="!reviewImg" class="shadow productImg" style="margin: 1%; padding: 0 10px; width: 4000px;">
            <br>
            <div class="product-noimg">
                <h2>작성자 : {{ store.review.writer }}</h2><br>
                <p style="font-size: 25px;">{{ store.review.regDate }}</p><br>
                <div class="contents"><h3>{{ store.review.content }}</h3></div>
            </div>
        </div>
        <br><br>
        <div class="btnclass" >
        <button @click="update" v-if="store.review.writer == ustore.logUser.id" class="btnn">수정</button>
    
        <button @click="deleteReview"  v-if="store.review.writer == ustore.logUser.id" class="btnn" >삭제</button>
        </div>
    </div>
</template>

<script setup>
import { useReviewStore } from '@/stores/review';
import { useProductStore } from '@/stores/product';
import {useUserStore} from  '@/stores/user';
import { computed } from 'vue'

const store = useReviewStore()
const pstore = useProductStore()
const ustore = useUserStore()

const update = function(){
    store.update()
}

const deleteReview = function(){
    store.deleteReview(store.review.reviewId, pstore.product.productId)
}


const reviewImg = computed(() => {
    console.log(!store.review.img)
    if(!store.review.img){
        
        return false;
    }
    return new URL(`http://localhost:8080/upload/`+store.review.img,import.meta.url);
});
</script>

<style scoped>


.whole{
    margin: 5% 30%;
    text-align: center;
    background-color: rgba(253, 251, 251, 0.8);
    margin-bottom: 5%;
    padding-right: 3%;
    padding-top: 3%;
    padding-bottom: 3%;
    border-radius: 20px;
    margin-bottom: 5%;
    width: 1500px;
    margin: 80px 300px;
}

.product {
    display: flex;
    text-align: center;
    padding-left: 100px;
    padding-right: 200px;
}

.product-noimg {
    padding-top: 40px;
    padding-left: 10%;
    /* padding-left: 500px; */
    flex-direction: column;
    text-align: left;
    color: #5a5a5a;
    margin-top: 5%;

}

.productImg {
    margin-top: 20px;
    width: 600px;
    height: 600px;
    object-fit: cover;
    /* padding: 1%; */
}


.contents{
    /* background-color: rgb(122, 122, 122); */
    height: 70%;
    width: 600px;
    border-radius: 15px;
    padding: 3%;
    /* border: 1px solid #5a5a5a; */
    /* box-shadow: 1px 1px 15px 5px rgba(0, 0, 0, 0.2); */
    border: 1px solid #d1d1d1;
}


button {
    margin: 1%;
    text-decoration: none;
    color: rgba(61, 61, 61, 0.8);
    background-color: #acacac2a;
    border-radius: 10px;
    font-size: 30px;
    font-weight: 550;
    border-style: none;
    transition: background-color 0.3s ease;
    white-space: nowrap;
    width: 130px;
    height: 70px;
    
}

button:hover {
    color: #fafafae7;
    background-color: rgba(61, 61, 61, 0.8);
}

.btnclass{
    display: flex; 
    flex-direction: row; 
    justify-content: right ;
}


</style>