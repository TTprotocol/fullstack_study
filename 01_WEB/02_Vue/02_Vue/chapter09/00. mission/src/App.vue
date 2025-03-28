<template>
    <div class="container">
        <div class="budget-container card p-4">
            <h2 class="title">Simple Budget Diary</h2>
            <ExpenseForm @add="GetExpense" />
            <ExpenseList :list="expenseList.expenses"></ExpenseList>
            <TotalDisplay
                :total="total"
                :formatNumber="formatNumber"
            ></TotalDisplay>
        </div>
    </div>
</template>

<script>
import { ref, reactive } from 'vue';
import ExpenseForm from './components/ExpenseForm.vue';
import TotalDisplay from './components/TotalDisplay.vue';
import ExpenseList from './components/ExpenseList.vue';

export default {
    name: 'App',
    components: {
        ExpenseForm,
        TotalDisplay,
        ExpenseList,
    },
    setup() {
        const expenseList = reactive({ expenses: [] });
        const total = ref(0);

        const GetExpense = (expense) => {
            console.log('expense : ', expense);
            expenseList.expenses.push({
                item: expense.item,
                price: expense.price.toLocaleString() + '원',
            });
            total.value += expense.price;
        };

        const formatNumber = (number) => {
            return '￦' + number.toLocaleString() + ' 원';
        };

        return { expenseList, total, GetExpense, formatNumber };
    },
};
</script>

<style>
.app {
    background-color: #1e1e1e;
    color: #f0f0f0;
    padding: 30px;
    font-family: 'Segoe UI', sans-serif;
    max-width: 600px;
    margin: 50px auto;
}

.budget-container {
    background: #1e1e1e;
    border-radius: 16px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
    padding: 20px;
}

.title {
    color: #3dffbc;
    font-weight: bold;
}
.text-start {
    color: #3dffbc;
}
.text-start-item {
    color: white;
    background-color: gray;
}
.total-expense {
    color: #3dffbc;
}
</style>
