<template>
    <div id="summary" class="card">
        <h2>🧾 주문 내역서</h2>
        <p></p>
        <h4>주문 시간 : {{ currentTime }}</h4>
        <hr />
        <p>음료 : {{ drink.name }}</p>
        <p>사이즈 : {{ optionData.size }}</p>
        <p>추가 샷 : {{ optionData.extraShot }}</p>
        <p>얼음 양 : {{ optionData.ice }}</p>
        <hr />
        <p>결제 금액 : {{ drink.price.toLocaleString('ko-kr') }}</p>
        <br />
        <button id="orderBtn" class="btn" @click="placeOrder">
            주문 확정하기
        </button>
    </div>
</template>

<style>
#summary {
    background-color: #fffaf0;
    border: 1px solid #d2b48c;
    margin-top: 20px;
    padding: 20px;
    box-sizing: border-box;
}
#orderBtn {
    width: 150px;
    background-color: #d2b48c;
}
</style>

<script>
export default {
    name: 'OrderSummary',
    props: ['drink', 'optionData'],
    emits: ['place-order'],
    data() {
        return {
            order: {
                time: '',
                drinkName: '',
                size: '',
                extraShot: '',
                ice: '',
                price: '',
            },
        };
    },
    methods: {
        placeOrder() {
            // order 객체에 drink과 optionData 내용 담기
            this.order.drinkName = this.drink.name;
            this.order.size = this.optionData.size;
            this.order.extraShot = this.optionData.extraShot;
            this.order.ice = this.optionData.ice;
            this.order.price = this.drink.price.toLocaleString('ko-kr');

            // 부모 컴포넌트로 'place-order' 이벤트와 함께 order 전달
            this.$emit('place-order', this.order);
        },
    },
    computed: {
        currentTime() {
            let now = new Date();
            let time =
                now.getFullYear() +
                '. ' +
                (now.getMonth() + 1) +
                '. ' +
                now.getDate() +
                ' ' +
                (now.getHours() > 12 ? '오전 ' : '오후 ') +
                (now.getHours() > 12 ? now.getHours() - 12 : now.getHours()) +
                ':' +
                now.getMinutes() +
                ':' +
                now.getSeconds();

            this.order.time = time;

            return time;
        },
    },
};
</script>
