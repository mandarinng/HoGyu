<template>
    <div class="whole">
        <h2 style="font-weight: bold; margin-bottom: 3%;">리뷰 작성</h2>

        <form class="product">
            <img :src="imgUrl" class="shadow productImg"><br>
            <div class="product-noimg">
                <label>
                    <h3 style="">작성자 : {{ ustore.logUser.id }}</h3>
                </label><br><br>
                <!-- <label>별점</label>
                    <input type="number" v-model="review.star"><br><br>

                    <label>솔직한 상품 리뷰를 남겨주세요 </label><br>
                    <textarea v-model="review.content" placeholder="내용을 입력하세요"></textarea><br><br> -->

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


                <label><h3>사진 등록</h3></label><br>
                <input type="file" id="photo" accept="image/*" ref="fileInput" style="display: none" @change="getFile">
                <label for="photo" class="custom-file-button">
                    <span v-if="file.name" style="font-size: 30px;">파일 선택됨</span>
                    <span v-else style="font-size: 50px;" >&nbsp;&nbsp;&nbsp;+&nbsp;&nbsp;&nbsp;</span>

                </label><span v-show="file.name" style="font-size: 20px;"> &nbsp;: {{ selectedFileName }}</span><br>
            </div>
        </form>

        <button @click="create" class="createR" style="margin-left: 70%;">리뷰 등록</button>
    </div>
</template>

<script setup>

import { ref, computed } from 'vue'
import { useReviewStore } from '@/stores/review'
import { useUserStore } from '@/stores/user'
import { useProductStore } from '@/stores/product'

const rstore = useReviewStore()
const ustore = useUserStore()
const pstore = useProductStore()

const selectedFileName = ref('');

const review = ref({
    writer: ustore.logUser.id,
    productId: pstore.product.productId,
    content: '',
    star: 1
})

const file = ref({})

const create = function () {
    var frm = new FormData();
    frm.append("writer", review.value.writer)
    frm.append("productId", review.value.productId)
    frm.append("content", review.value.content)
    frm.append("star", review.value.star)
    if (file.value) {
        frm.append("file", file.value)
    }

    rstore.createReview(frm, pstore.product.productId)
}

const getFile = function () {
    var photo = document.getElementById("photo");
    file.value = photo.files[0];
    selectedFileName.value = file.value.name
    console.log(file.value)

    //     if (selectedFile) {
    //     selectedFileName.value = selectedFile.name;
    //   } else {
    //     selectedFileName.value = '';
    //   }
}

const imgUrl = computed(() => {
    return new URL(`../../assets/` + pstore.product.img, import.meta.url);
});


</script>

<style scoped>
.whole {
    margin-top: 5%;
    text-align: center;
    background-color: rgba(253, 251, 251, 0.8);
    margin-bottom: 5%;
    padding: 3%;
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


}

.productImg {
    margin-top: 20px;
    width: 600px;
    height: 600px;
    object-fit: cover;
    padding: 1%;
}

.createR {
    text-align: center;
    /* padding-right: 10%; */
    font-size: 150%;

}


.custom-input:focus {
    box-shadow: 0 0 0 0.25rem #dde0e3;
    outline: none;
}


button {
    margin-top: 3%;
    text-decoration: none;
    color: rgba(61, 61, 61, 0.8);
    background-color: #acacac2a;
    padding: 1% 2%;
    border-radius: 6%;
    font-weight: 550;
    border-style: none;
    transition: background-color 0.3s ease;

}

button:hover {
    color: #fafafae7;
    background-color: rgba(61, 61, 61, 0.8);
}





.custom-file-button {
    /* 대체 버튼 스타일 */
    display: inline-block;
    padding: 10px 15px;
    font-size: 16px;
    cursor: pointer;
    color: #5a5a5a;
    background-color: #acacac2a;
    border: none;
    border-radius: 5px;
}

.custom-file-button:hover {
    color: #fafafae7;
    background-color: rgba(61, 61, 61, 0.8);
}
</style>