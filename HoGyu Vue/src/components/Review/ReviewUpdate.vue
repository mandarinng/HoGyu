<template>
    <div class="whole">
        <h2 style="font-weight: bold; margin-bottom: 3%;">리뷰 수정</h2>
        <div class="product">
            <img :src="reviewImg" v-show="reviewImg" class="shadow productImg">
            <img src="@/assets/no-image.png" v-show="!reviewImg" class="shadow productImg" style="margin: 1%; padding: 0 10px; width: 4000px;">
            <br>
            <div class="product-noimg">
                <h2>작성자 : {{ store.review.writer }}</h2><br>
                
<!--                 
                <textarea v-model="review.content"></textarea>
                <input type="number" v-model="review.star"> -->
            

                <div class="mb-3 fs-3" style="display: flex;flex-direction: row;">
                    <label for="exampleFormControlInput1" class="form-label">별점&nbsp;&nbsp;&nbsp;</label>
                    <input type="number" v-model="review.star" class="form-control" id="exampleFormControlInput1"
                        placeholder="5"
                        style=" color: #5a5a5a; font-size: 25px; width: 100px; height: 50px; border-radius: 7%;">
                </div>
                <div class="mb-3 fs-3">
                    <label for="exampleFormControlTextarea1" class="form-label">내용</label>
                    <textarea v-model="review.content" class="form-control" id="exampleFormControlTextarea1" rows="3"
                        placeholder="솔직한 상품 리뷰를 남겨주세요"
                        style=" color: #5a5a5a; font-size: 25px; width: 500px; height: 200px; border-radius: 7%;"></textarea>
                </div>
            
            
            </div>
        </div>
        <br><br>
        <button  class="btnclass" @click="reviewUpdate" style="margin-left: 70%;">수정</button>
    </div>
</template>

<script setup>
import {ref, computed} from 'vue'
import { useReviewStore } from '@/stores/review';
import { useProductStore } from '@/stores/product';

const pstore = useProductStore()
const store = useReviewStore()

const review = ref({
    reviewId: store.review.reviewId,
    writer: store.review.writer,
    productId:pstore.product.productId,
    content:store.review.content,
    star:store.review.star
})

const reviewUpdate = function(){
    store.reviewUpdate(review.value, pstore.product.productId)
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


.custom-input:focus {
    box-shadow: 0 0 0 0.25rem #dde0e3;
    outline: none;
}



</style>