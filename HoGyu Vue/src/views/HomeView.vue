<template>
    <div>
        <!-- <p>홈</p> -->
        <!-- <RouterLink to="/product"> -->
        <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active" data-bs-interval="10000">
                    <div class="image1" ><button class="btn btn-outline-light btn-rounded  shoppingStart" @click="goShopping">쇼핑 시작하기</button></div>
                    <!-- <img src="https://www.nelsonsports.co.kr/data/popup/popup_16998585077931.jpg"
                        class="d-block w-100" alt="..."> -->
                </div>
                <div class="carousel-item" data-bs-interval="2000">
                    <div class="image2"><button class="btn btn-outline-light btn-rounded  shoppingStart" @click="goShopping">쇼핑 시작하기</button></div>
                    <!-- <img style="width: 1500px; height: 500px;" src="https://www.nelsonsports.co.kr/data/popup/popup_16650362099448.jpg"
                        class="d-block w-100" alt="..."> -->
                </div>
                <div class="carousel-item">
                    <div class="image3"><button class="btn btn-outline-light btn-rounded  shoppingStart" @click="goShopping">쇼핑 시작하기</button></div>
                    
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval"
                data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval"
                data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    <!-- </RouterLink> -->
    </div>
</template>

<script setup>
    import router from '@/router'

    const goShopping = function(){
        router.push("/product")
    }
</script>

<style scoped>
.image1 {
    width: auto;
    /* 원하는 너비 */
    height: 100vh;
    /* 원하는 높이 */
    background-size: cover;
    /* 이미지를 화면에 맞게 늘리거나 축소합니다. */
    background-position: center;
    /* 이미지를 가운데 정렬합니다. */
    background-image: url('https://e0.pxfuel.com/wallpapers/360/909/desktop-wallpaper-climbing-mountaineering.jpg');
    background-repeat: no-repeat;
    opacity: 1.3;
    /* 이미지를 반복하지 않도록 설정합니다. */

}

.image2 {
    width:auto;
    /* 원하는 너비 */
    height: 100vh;
    /* 원하는 높이 */
    background-size: cover;
    /* 이미지를 화면에 맞게 늘리거나 축소합니다. */
    background-position: center;
    /* 이미지를 가운데 정렬합니다. */
    background-image: url("https://e1.pxfuel.com/desktop-wallpaper/233/110/desktop-wallpaper-most-viewed-fitness-fitness-couple.jpg");
    background-repeat: no-repeat;
    opacity: 1.3;

}

.image3 {
    width: auto;
    /* 원하는 너비 */
    height: 100vh;
    /* 원하는 높이 */
    background-size: cover;
    /* 이미지를 화면에 맞게 늘리거나 축소합니다. */
    background-position: center;
    /* 이미지를 가운데 정렬합니다. */
    background-image: url("https://png.pngtree.com/background/20211217/original/pngtree-vegetable-salad-photography-picture-image_1560827.jpg");
    background-repeat: no-repeat;
    opacity: 1.1;

}
.shoppingStart{
    position: absolute;
    top: 50vh;
    left: 45vw;
    /* background-color: rgba(0,0,0,0); */
    color: white;
    padding: 25px;
    border-radius: 10px;
    font-size: 30px;
}

button:hover{
    color: black;
}

</style>