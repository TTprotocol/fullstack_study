<template>
    <div id="statistic" class="card">
        <h2><i class="fa-solid fa-file"></i> 주문 통계</h2>
        <p>총 주문 횟수: {{ order.total }}</p>
        <p>총 매출: {{ order.benefit }}</p>
        <p>가장 인기있는 음료: {{ order.favorite }}</p>
        <p>가장 많이 선택된 사이즈: {{ order.size }}</p>
        <p>추가 샷 비율: {{ order.extra }} %</p>
        {{ Statics }}
    </div>
</template>

<style></style>

<script>
export default {
    name: 'Statistics',
    props: ['orders'],
    emits: [],
    data() {
        return {
            order: {
                total: 0,
                benefit: 0,
                favorite: '',
                size: '',
                extra: '',
            },
        };
    },
    computed: {
        Statics() {
            console.log('this.orders : ', this.orders);
            if (this.orders.length > 0) {
                const orderList = this.orders;

                this.order.total = orderList.length;

                this.order.benefit = orderList.reduce(
                    (acc, now) => (acc += Number(now.price))
                );

                this.order.extra =
                    orderList.filter((item) => item.extraShot === '추가됨')
                        .length / orderList.length;
            }
        },
    },
};
</script>
