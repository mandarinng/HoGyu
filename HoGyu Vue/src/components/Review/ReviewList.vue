<template>
    <div class="whole">
        <h2 style="font-weight: bold; margin-bottom: 3%;">Review</h2>
        <div style="display: flex; justify-content: center; margin-bottom: 3%;">
        <table  class="cl">
            <tr><th>No.</th><th>글쓴이</th><th>별점</th><th>내용</th></tr>
            <ReviewListItem v-for="(review, index) in store.reviewList"
            :key="review.reviewId" :review="review" :index="index"/>
        </table>
    </div>
   
        <div class="putR"><router-link to="review/create" >리뷰 등록</router-link></div>
    </div>
</template>

<script setup>

import ReviewListItem from './ReviewListItem.vue';
import { useReviewStore } from '@/stores/review'

const store = useReviewStore()



</script>



<style scoped>

.whole{
    margin-top: 5%;
    text-align: center;
    background-color: rgba(253, 251, 251, 0.8);
    margin-bottom: 5%;
    padding: 2%;
    border-radius: 20px;
    margin-bottom: 5%;
    width: 1500px;
    margin: 80px 300px;
}

table {
    width: 120rem;
    border-radius: 0.4rem;
    padding: 1rem;
    text-align: center;
    
}

td, th {
  border-bottom: 1px solid #ddd; /* 가로줄 스타일 지정 */
  padding: 8px; /* 셀 안의 여백 설정 (필요에 따라 조절) */
  font-size: 23px;
}
.whole a{
    margin-top: 5px;
}

.putR{
    text-align: right;
    padding-right: 10%;
    font-size: 150%;
    
}


a{
    text-decoration: none;
    color: rgba(61, 61, 61, 0.8);
    background-color: #acacac2a;
    padding: 1% 2%;
    border-radius: 6%;
    font-weight: 550;
}

a:hover{
    color: #fafafae7;
    background-color: rgba(61, 61, 61, 0.8);
}
</style>