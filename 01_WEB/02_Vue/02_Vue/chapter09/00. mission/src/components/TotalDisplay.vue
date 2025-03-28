<template>
    <h3 class="total-expense mt-3 text-center">
        <!-- 총 지출 : {{ total.toLocaleString() }} 원 -->
        총 지출 : {{ getFunction(total) }}
    </h3>
</template>

<script>
export default {
    name: 'TotalDisplay',
    props: {
        total: Number,
        formatNumber: {
            type: Function,
            required: true,
        },
    },
    setup(props, context) {
        const getFunction = (number) => {
            return props.formatNumber(number);
        };

        return { getFunction };
    },
};
</script>

<style></style>
