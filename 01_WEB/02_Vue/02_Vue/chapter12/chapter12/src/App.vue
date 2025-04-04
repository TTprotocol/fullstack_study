<template>
  <div class="container">
    <MainHeader />
    <router-view />
    <LoadingModal v-if="states.isLoading" />
  </div>
</template>
<script setup>
import { reactive, computed, provide } from "vue";
import MainHeader from "@/components/MainHeader.vue";
import LoadingModal from "./components/LoadingModal.vue";
import axios from "axios";

// 1단계 - provide/inject
// const states = reactive({
//   todoList: [
//     { id: 1, todo: "ES6학습", desc: "설명1", done: false },
//     { id: 2, todo: "React학습", desc: "설명2", done: false },
//     { id: 3, todo: "ContextAPI 학습", desc: "설명3", done: true },
//     { id: 4, todo: "야구경기 관람", desc: "설명4", done: false },
//   ],
// });

// const addTodo = ({ todo, desc }) => {
//   states.todoList.push({ id: new Date().getTime(), todo, desc, done: false });
// };
// const updateTodo = ({ id, todo, desc, done }) => {
//   // 사용자에게 받아온 id와 일치하는 객체의 인덱스 찾기
//   let index = states.todoList.findIndex((todo) => todo.id === id);
//   // 전개 연산자로 기존 값 복사 후 받아온 값 추가
//   states.todoList[index] = { ...states.todoList[index], todo, desc, done };
// };
// const deleteTodo = (id) => {
//   // 삭제할 todo가 todoList에서 몇 번째 인덱스인지 id를 통해 검색
//   let index = states.todoList.findIndex((todo) => todo.id === id);
//   // index 위치부터 1개의 요소를 삭제
//   states.todoList.splice(index, 1);
// };
// const toggleDone = (id) => {
//   // 완료시킬 todo가 todolist에 몇 번째 인덱스인지 id를 통해 검색
//   let index = states.todoList.findIndex((todo) => todo.id === id);
//   // 클릭한 todo의 완료 여부를 반대로 변경
//   states.todoList[index].done = !states.todoList[index].done;
// };

// states.todoList를 computed 속성으로 전달함으로써 읽기 전용으로 변경하여 전달한다.
// 이는 다른 컴포넌트에서 todoList를 직접적으로 변경하는 것을 방지하고 뒤이어 전달한 메서드로만  값을 바꿀 수 있게 하기 위함이다.
// provide(
//   "todoList",
//   computed(() => states.todoList)
// );
// provide("actions", { addTodo, deleteTodo, toggleDone, updateTodo });

const BASEURL = "/api/todos";

// 2단계 - axios
const states = reactive({
  todoList: [
    { id: 1, todo: "ES6학습", desc: "설명1", done: false },
    { id: 2, todo: "React학습", desc: "설명2", done: false },
    { id: 3, todo: "ContextAPI 학습", desc: "설명3", done: true },
    { id: 4, todo: "야구경기 관람", desc: "설명4", done: false },
  ],
  isLoading: false,
});

// todoList 목록 조회.
const fetchTodoList = async () => {
  try {
    const response = await axios.get(BASEURL);
    if (response.status === 200) {
      states.todoList = response.data;
    } else {
      alert("데이터 조회 실패");
    }
  } catch (e) {
    alert("에러발생 : ", e);
  }
};

// 새로운 todoList 추가.
const addTodo = async ({ todo, desc }, successCallback) => {
  try {
    const payload = { todo, desc };
    const response = await axios.post(BASEURL, payload);
    console.log("response : ", response);
    if (response.status === 201) {
      states.todoList.push({
        ...response.data,
        done: false,
      });
      successCallback();
    } else {
      alert("Todo 추가 실패");
    }
  } catch (e) {
    alert("에러발생 : ", e);
  }
};

// 기존 todoList를 변경
const updateTodo = async ({ id, todo, desc, done }, successCallback) => {
  try {
    const payload = { id, todo, desc, done };
    const response = await axios(BASEURL + `/${id}`, payload);
    if (response.status === 200) {
      let index = states.todoList.findIndex((todo) => todo.id === id);
      states.todoList[index] = payload;
      successCallback();
    } else {
      alert("Todo 변경 실패");
    }
  } catch (e) {
    alert("에러 발생 : ", e);
  }
};

// 기존 todoItem을 삭제
const deleteTodo = async (id) => {
  try {
    console.log("id : ", id);
    const response = await axios.delete(BASEURL + `/${id}`);
    console.log(response.status, response.data);

    if (response.status === 200) {
      let index = states.todoList.findIndex((todo) => todo.id === id);
      states.todoList.splice(index, 1);
    } else {
      alert("Todo 삭제 실패");
    }
  } catch (error) {
    alert("에러발생 :" + error);
  }
};

const toggleDone = async (id) => {
  try {
    console.log("toggleDone id :", id);
    let todo = states.todoList.find((todo) => todo.id === id);
    let payload = { ...todo, done: !todo.done };

    const response = await axios.put(BASEURL + `/${id}`, payload);
    console.log(response.status, response.data);

    if (response.status === 200) {
      todo.done = payload.done;
    } else {
      alert("todo 완료 변경 실패");
    }
  } catch (e) {
    alert("에러발생 : ", e);
  }
};

provide(
  "todoList",
  computed(() => states.todoList)
);
provide("actions", {
  addTodo,
  deleteTodo,
  toggleDone,
  updateTodo,
  fetchTodoList,
});

fetchTodoList();
</script>
