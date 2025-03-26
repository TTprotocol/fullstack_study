<template>
    <div id="orderHistory" class="card">
        <div v-for="(order, index) in orders" :key="index">
            <h2><i class="fa-solid fa-file"></i> 주문 내역</h2>
            <p><i class="fa-solid fa-clock"></i> {{ order.time }}</p>
            <p>음료: {{ order.drinkName }}</p>
            <p>사이즈: {{ order.size }}</p>
            <p>추가샷: {{ order.extraShot }}</p>
            <p>얼음 양: {{ order.ice }}</p>
            <p>금액: {{ order.price }}</p>
            <hr />
        </div>
    </div>
</template>

<style>
#orderHistory {
    background-color: #fffaf0;
    border: 1px solid #d2b48c;
    margin-top: 15px;
    padding: 15px;
}
p {
    margin: 0;
    font-size: 17px;
}
</style>

<script>
export default {
    name: 'OrderHistory',
    props: ['orders'],
    emits: [],
    data() {},
};
</script>
