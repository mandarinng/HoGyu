<template>
    
        <tr>
            <td>{{ index + 1 }}</td>
            <td>{{ client.id }}</td>
            <td>{{client.productName}}</td>
            <td>{{client.cnt}}</td>
            <td>{{client.totalPrice}}</td>
        </tr>
  
</template>

<script setup>
const props = defineProps({
    client: {
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