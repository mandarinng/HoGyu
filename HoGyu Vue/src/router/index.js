import { createRouter, createWebHistory } from 'vue-router'
import ProductView from '@/views/productView.vue'
import ReviewView from '@/views/ReviewView.vue'
import HomeView from '@/views/HomeView.vue'

import JoinView from '@/components/Login/Join.vue'
import LoginView from '@/components/Login/Login.vue'
import Mypage from '@/components/Login/Mypage.vue'

import ProductList from '@/components/Product/ProductList.vue'
import ProductDetail from '@/components/Product/ProductDetail.vue'
import ProductSearchLsit from '@/components/Product/ProductSearchList.vue'
import ProductExplain from '@/components/Product/ProductExplain.vue'
import ReviewList from '@/components/Review/ReviewList.vue'
import ReviewCreate from '@/components/Review/ReviewCreate.vue'
import ReviewDetail from '@/components/Review/ReviewDetail.vue'
import ReviewUpdate from '@/components/Review/ReviewUpdate.vue'
import ProductBuyAlone from '@/components/Product/ProductBuyAlone.vue'
import CompleteView from '@/components/Product/Complete.vue'
import CompleteAlone from '@/components/Product/CompleteAlone.vue'
import ProductTogetherList from '@/components/Product/ProductTogetherList.vue'
import ProductTogetherStart from '@/components/Product/ProductTogetherStart.vue'
import ProductTogetherJoin from '@/components/Product/ProductTogetherJoin.vue'
import MyCart from '@/components/MyCart/MyCart.vue'
import MyCartBuy from '@/components/MyCart/MyCartBuy.vue'
import CompleteCart from '@/components/MyCart/CompleteCart.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/product',
      name: 'product',
      component: ProductView,
      children: [
        {
          path: "",
          name: "productList",
          component: ProductList
        },
    
        {
          path: ":productId",
          name: "productDetail",
          component: ProductDetail,
          children:[
            {
              path: "explain",
              name: "productExplain",
              component: ProductExplain
            },
           
            {
              path: 'review',
              name: 'review',
              component: ReviewView,
              children:[
                {
                  path: "",
                  name: 'reviewList',
                  component: ReviewList
                },
                {
                  path: "create",
                  name: 'reviewCreate',
                  component: ReviewCreate
                },
                {
                  path: "detail",
                  name: 'reviewDetail',
                  component: ReviewDetail
                },
                {
                  path:"update",
                  name: 'reviewUpdate',
                  component: ReviewUpdate
                }
              ]
             },
          ]
        },
        {
          path: "buyalone",
          name: "buyalone",
          component: ProductBuyAlone
        },
        {
          path: "complete",
          name: "complete",
          component: CompleteView
        },
        {
          path: "completealone",
          name: "completeAlone",
          component: CompleteAlone
        },
        {
          path: "togetherlist",
          name: "TogetherList",
          component: ProductTogetherList
        },
        {
          path: "togetherstart",
          name: "TogetherStart",
          component: ProductTogetherStart
        },
        {
          path: "togetherjoin",
          name: "TogetherJoin",
          component: ProductTogetherJoin
        },
      ]
    },
    {
      path: "/search/:word",
      name: "productSearchList",
      component: ProductSearchLsit
    },
    {
      path: '/join',
      name: 'join',
      component: JoinView
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView
    },
    {
      path: '/mypage',
      name: 'mypage',
      component: Mypage
    },
    {
      path: '/mycart',
      name: 'myCart',
      component: MyCart
    },
    {
      path: '/mycartbuy',
      name: 'myCartBuy',
      component: MyCartBuy
    },
    {
      path: '/completecart',
      name: 'completecart',
      component: CompleteCart
    },
   
   
  ]
})

export default router
