import { ref} from 'vue'
import { defineStore } from 'pinia'
import {useRouter} from 'vue-router'
import axios from 'axios'

export const useReviewStore = defineStore('review', ()=>{

    const URL = "http://localhost:8080/api"
    
    const reviewList = ref([])
    const router = useRouter()

    const getReviewList = function(productId){
        axios({
            url:URL+"/review",
            method:"Get",
            params:{
                productId:productId
            }
        })
        .then((res)=>{
            reviewList.value = res.data
        })
    }

    const review = ref({})
    const getReview = function(reviewId){
        axios.get(`${URL}/review/${reviewId}`)
        .then((res)=>{
            review.value = res.data
            router.push({name: 'reviewDetail'})
        })
    }

    const createReview = function(frm, productId){
        console.log(frm)
        axios.post(`${URL}/review`,frm, {
            headers: {
                "Content-Type" : "multipart/form-data",
            }
        })
        .then(()=>{
            getReviewList(productId)
            router.push({name: "reviewList"})
        })
    }

    const update = function(){
        router.push({name:'reviewUpdate'})
    }
    
    const reviewUpdate = function(review,productId){
        axios.put(`${URL}/review`,review)
        .then(()=>{
            getReviewList(productId)
            router.push({name:"reviewList"})
            alert('리뷰 수정이 완료되었습니다.')
        })
    }
    const deleteReview = function(reviewId,productId){
        axios.delete(`${URL}/review/${reviewId}`)
        .then(()=>{
            getReviewList(productId)
            router.push({name:"reviewList"})
        })
    }


    return {createReview, getReviewList, reviewList,review,getReview,reviewUpdate, update, deleteReview}
},{persist: true})
