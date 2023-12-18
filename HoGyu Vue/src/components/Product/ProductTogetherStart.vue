<template>
  <div style="  margin-top: 200px;">
    <h2 style="font-weight: bold;  margin-left: 19%; margin-top: 100px; font-size: 55px;" class="accordion">공동 구매 시작하기
    </h2>
    <div class="purchase-container">
      <div class="product">
        <!-- 왼쪽 영역 -->
        <div class="left-section">
          <h2 style="font-weight: bold; font-size: 40px;">받는 사람</h2>
          <div class="input-group">
            <h4 style="margin: 20px 0px; font-size: 25px;">이름</h4>
            <input class="input-buy" type="text" v-model="clients.name">
          </div>
          <div class="input-group">
            <h4 style="margin: 20px 0px; font-size: 25px;">전화번호</h4>
            <input class="input-buy" type="text" v-model="clients.phoneNum">
          </div>
          <div>
            <h4 style="font-weight: bold; font-size: 40px; margin-top: 80px;">결제 수단</h4>
            <div class="payment-options">
              <label style=" font-size: 25px;"><input class="radio-input" type="radio" v-model="payment" value="계좌 결제"
                  name="pay">계좌 결제</label>
              <label style="margin: 20px 0px; font-size: 25px;"><input class="radio-input" type="radio" v-model="payment"
                  value="카드 결제" name="pay">카드 결제</label>
            </div>
            <h3 style="margin: 30px 0px;  margin-top: 200px; font-weight: bold; font-size: 40px;">주문 상세</h3>
            <div style="display: flex; justify-content: space-around; ">
              <img :src="imgUrl" /><br>
              <div class="order-details">
                <h4 style="margin-top: 20px; font-size: 25px; font-weight: bold;">{{ pstore.product.productName
                }}</h4>
                <p style="margin: 20px 0px; font-size: 25px;">총 {{ pstore.cnt }} 개</p>
                <p style="margin: 20px 0px; font-size: 25px;">개당 {{ pstore.product.price }}원</p>

              </div>
            </div>
            <div style="text-align: right;">
              <p style="margin: 20px 0px; font-size: 25px;">혼자 구매시 가격 : {{ beforePrice }}원</p>
              <p style="margin-top: 20px; font-size: 30px; font-weight: bold; color: rgb(61, 61, 61);">공동 구매 가격 :
                <span style="color: orange;">{{ totalPrice }}</span>원</p>
            </div>
            <br>


          </div>
        </div>

        <!-- 오른쪽 영역 -->
        <div class="right-section">
          <div>
            <h2 style="font-weight: bold; font-size: 40px; margin-bottom: 30px;">배송 위치</h2>
            <p style="margin: 20px 0px; font-size: 25px;">원하는 위치로 지도위치를 옮긴후 배송받을 편의점을 검색해 주세요</p>
            <div>
              <div>
                <div id="map"></div>
                <div style="display: flex; margin: 20px 0px;">
                  <input class="input-search" v-model="searchKeyword" placeholder="장소 검색어를 입력하세요">
                  <button class="button" style="margin-top: 20px; margin-right: 120px; border-radius: 10px;" @click="searchPlaces">검색</button>
                </div>
              </div>
              <div style="display: flex;">
                <p style="margin-top: 20px; font-size: 25px; font-weight: bold;">지정된 편의점</p>
                <p style="margin-top: 20px; font-size: 25px; margin-left: 30px;">{{
                  clients.address }}</p>
              </div>
              <hr style="width: 700px;">
            </div>
            <button class="button-buy" style=" margin-right: 100px; border-radius: 10px;" @click="buyTogether">공동구매하기</button>
           
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script setup>
import { useProductStore } from '@/stores/product';
import { useClientsStore } from '@/stores/clients';
import { useUserStore } from '@/stores/user';
import { ref, computed, onMounted } from 'vue'
// import KakaoMap from '@/components/Product/KakaoMap.vue';

const pstore = useProductStore()
const csstore = useClientsStore()
const ustore = useUserStore()

const beforePrice = computed(() => pstore.cnt * pstore.product.price + 3000)
const totalPrice = computed(() => (pstore.cnt * pstore.product.price + 3000) * 0.9)

const clients = ref({
  orderId: pstore.product.productId + csstore.order,
  userId: ustore.logUser.id,
  name: ustore.logUser.name,
  phoneNum: ustore.logUser.phoneNum,
  address: '',
  productId: pstore.product.productId,
  productName: pstore.product.productName,
  cnt: pstore.cnt,
  totalPrice: totalPrice.value,
  partner: 1
})

const imgUrl = computed(() => {
  return new URL(`../../assets/` + pstore.product.img, import.meta.url);
});

const buyTogether = function () {
  console.log(clients.value)
  csstore.buyTogether(clients.value)
}
let map = null;
let infowindow = null;
let ps = null;
const searchKeyword = ref('');
let markers = [];

const initMap = () => {
  const container = document.getElementById('map');
  const options = {
    center: new kakao.maps.LatLng(37.566826, 126.9786567),
    level: 7,
  };
  map = new kakao.maps.Map(container, options);

  infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });
  ps = new kakao.maps.services.Places(map);

  // 사용자의 현재 위치를 얻어오는 함수 호출
  getCurrentLocation();
};

// 사용자의 현재 위치를 얻어오는 함수
const getCurrentLocation = () => {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(
      (position) => {
        const lat = position.coords.latitude;
        const lng = position.coords.longitude;
        const currentLocation = new kakao.maps.LatLng(lat, lng);

        // 지도의 중심을 현재 위치로 이동
        map.setCenter(currentLocation);

        // 장소 검색 서비스 호출 (주변 검색)
        ps.categorySearch('PM9', placesSearchCB, { useMapBounds: true });
      },
      (error) => {
        console.error('Error getting user location:', error);
      }
    );
  } else {
    console.error('Geolocation is not supported by this browser.');
  }
};

function placesSearchCB(data, status, pagination) {
  if (status === kakao.maps.services.Status.OK) {
    for (let i = 0; i < data.length; i++) {
      displayMarker(data[i]);
    }
  }
}

function displayMarker(place) {
  const marker = new kakao.maps.Marker({
    map: map,
    position: new kakao.maps.LatLng(place.y, place.x),
  });

  markers.push(marker);

  kakao.maps.event.addListener(marker, 'click', function () {

    clients.value.address = place.place_name;

    infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
    infowindow.open(map, marker);



  });
}

function removeMarkers() {
  for (let i = 0; i < markers.length; i++) {
    markers[i].setMap(null);
  }
  markers = [];
}

const searchPlaces = () => {
  removeMarkers();
  ps.keywordSearch(searchKeyword.value, placesSearchCB, { useMapBounds: true });
};

onMounted(async () => {
  if (window.kakao && window.kakao.maps) {
    initMap();
  } else {
    const script = document.createElement('script');
    script.src = '//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=6d42c335bcf738793560e4d60138fb5f&libraries=services';
    document.head.appendChild(script);
    script.onload = () => {
      kakao.maps.load(initMap);
    };
  }
});
</script>

<style scoped>
#map {
  width: 600px;
  height: 500px;
}

input {
  margin-top: 10px;
  padding: 5px;
}

button {
  margin-top: 10px;
  padding: 5px;
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

.input-search {
  display: block;
  width: 300px;
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
  font-size: 18px;
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
  max-width: 1600px;
  height: auto;
  /* 너비 제한을 추가하여 가로 화면이 너무 넓지 않도록 함 */
  margin: 20px 0;
  padding-top: 50px;
  padding-bottom: 50px;
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
  padding-left: 30px;
}

.button {
  width: 200px;
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

.button-buy {
  width: 500px;
  height: 100px;
  font-size: 20px;
  padding: 10px 0px;
  background-color: #696969;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 30px;
  margin-top: 200px;
  margin-left: 100px;

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