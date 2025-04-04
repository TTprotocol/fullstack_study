<template>
    <div>
        <h2>TodoList 테스트</h2>
        <hr />
        할일 추가 :
        <input type="text" v-model="todo" />
        <button @click="addTodoHandler">추가</button>
        <hr />
        <ul>
            <li
                v-for="todoItem in todoList"
                :key="todoItem.id"
                style="
                    width: 20%;
                    display: flex;
                    justify-content: space-between;
                "
            >
                <span style="cursor: pointer" @click="toggleDone(todoItem.id)">
                    {{ todoItem.todo }} {{ todoItem.done ? '(완료)' : '' }}
                </span>
                <button @click="deleteTodo(todoItem.id)">삭제</button>
            </li>
        </ul>
        <div>완료된 할일 수 : {{ doneCount }}</div>
    </div>
</template>

<script setup>
import { todoListStore } from '../src/stores/todoList.js';
import { ref, computed } from 'vue';

const todo = ref('');
const store = todoListStore();

// 필요한 값들만 객체 구조 분해로 스토어에서 꺼낸다
const { todoList, addTodo, deleteTodo, toggleDone } = store;
// 기본 타입은 계산된 속성이라면 다시 computed로 작성해야한다.
const doneCount = computed(() => store.doneCount);

const addTodoHandler = () => {
    addTodo(todo.value);
    todo.value = '';
};
</script>

<style scoped></style>
