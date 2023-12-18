<template>
    
    <tr v-if="clients.partner>=2">
        <td>{{ index + 1 }}</td>
        <td>{{ clients.orderId }}</td>
        <td>{{clients.productName}}</td>
        <td>{{clients.cnt}}</td>
        <td>{{clients.totalPrice}}</td>
    </tr>

</template>

<script setup>
const props = defineProps({
clients: {
    type: Object,
    default: null,
},
index: {
    type: Number,

}
})


</script>

<style scoped>
tr{
    line-height: 3rem;
}
</style>