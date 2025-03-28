<template>
    <div class="container">
        <div class="row g-2">
            <div class="col">
                <input
                    class="form-control"
                    type="text"
                    v-model="expense.item"
                    placeholder="항목명 입력"
                />
            </div>
            <div class="col">
                <input
                    class="form-control"
                    type="text"
                    v-model.number="expense.price"
                    placeholder="0"
                />
            </div>
            <div class="col-auto">
                <button class="btn btn-custom" @click="Expense">추가</button>
            </div>
        </div>
    </div>
</template>

<script>
import { reactive } from 'vue';

export default {
    name: 'ExpenseForm',
    setup(props, context) {
        const expense = reactive({ item: '', price: 0 });

        const Expense = () => {
            context.emit('add', { ...expense });
            expense.item = '';
            expense.price = 0;
        };

        return { expense, Expense };
    },
};
</script>

<style>
.form-control {
    background: #2a2a2a;
    border: none;
    color: white;
}

.form-control::placeholder {
    color: #aaaaaa;
}

.btn-custom {
    background: #00ffaa;
    color: black;
    border: none;
    border-radius: 6px;
    padding: 8px 12px;
}

.btn-custom:hover {
    background: #00e09a;
}
</style>
