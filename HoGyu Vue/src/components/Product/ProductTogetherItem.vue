<template>
    <tr>
        <td>{{ index + 1 }}</td>
        <td>{{ clients.userId }}</td>
        <td v-if="clients.partner==1">1/2명</td>
        <td v-if="clients.partner!=1">구매완료</td>

        <td v-if="clients.partner==1" @click="clickJoin"><button type="button" class="btn btn-outline-secondary">참여하기</button></td>
        <td v-if="clients.partner!=1"><button type="button" class="btn btn-secondary" disabled>구매완료</button></td>
       
    </tr>
</template>

<script setup>
import{ useClientsStore} from '@/stores/clients'
const store = useClientsStore()

const props = defineProps({
    clients: {
        type: Object,
        default: null,
    },
    index: {
        type: Number,

    }
})
const clickJoin = function(){
    store.clickJoin(props.clients.orderId);
}

</script>



<style scoped>

td{
  font-size: 25px;
}
tr{
    line-height: 5rem;
    border-bottom: 1px solid #c0c0c0;
}

button {
    margin: 1%;
    text-decoration: none;
    color: rgba(61, 61, 61, 0.8);
    background-color: #acacac2a;
    border-radius: 10px;
    font-size: 30px;
    font-weight: 550;
    border-style: none;
    transition: background-color 0.3s ease;
    white-space: nowrap;
    width: 130px;
    height: 70px;
    
}

button:hover {
    color: #fafafae7;
    background-color: rgba(61, 61, 61, 0.8);
}

</style>
