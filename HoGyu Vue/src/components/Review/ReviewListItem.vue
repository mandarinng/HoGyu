<template>
    <tr>
        <td>{{ index + 1 }}</td>
        <td>{{ review.writer }}</td>
        <td>
            <span v-for="star in review.star"><img src="@/assets/star.png" style="width:30px; height:30px;"></span>
        </td>
        <td @click="clickContent">{{ review.content }}</td>
    </tr>
</template>

<script setup>
import {useReviewStore} from '@/stores/review'
const store = useReviewStore()

const props = defineProps({
    review: {
        type: Object,
        default: null,
    },
    index: {
        type: Number,

    }
})

const clickContent = function(){
    store.getReview(props.review.reviewId)
}


</script>



<style scoped>
table {
  border-collapse: collapse; /* 테이블 셀 간의 간격을 없앰 */
  /* background-color: #=rgba(253, 251, 251, ); */
}


tr{
    line-height: 3rem;
}

td, th {
  border-bottom: 1px solid #ddd; /* 가로줄 스타일 지정 */
  padding: 8px;
  font-size: 20px;
}

</style>
