<template>
  <div>
      <THeHeaderNav />
      
      <RouterView />
  </div>
</template>

<script setup>
import THeHeaderNav from "@/components/common/THeHeaderNav.vue";

</script>

<style  scoped>
@import url('https://hangeul.pstatic.net/hangeul_static/css/nanum-gothic.css');

div {
  font-family: Poppins, 'Noto Sans KR', sans-serif;
  /* 다른 전역 스타일도 추가 가능 */
}


</style>