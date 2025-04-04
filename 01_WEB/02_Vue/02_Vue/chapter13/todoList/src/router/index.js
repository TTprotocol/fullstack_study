import { createRouter, createWebHistory } from "vue-router";
import Home from "@/pages/HomeView.vue";
import About from "@/pages/AboutView.vue";
import TodoList from "@/pages/TodoList.vue";
import AddTodo from "@/pages/AddTodo.vue";
import EditTodo from "@/pages/EditTodo.vue";
import NotFound from "@/pages/NotFound.vue";

const router = createRouter({
  history: createWebHistory(), // 히스토리 모드 설정
  routes: [
    // 해당 path로 접근 시 해당 컴포넌트 렌더링
    {
      path: "/",
      name: "home",
      component: Home,
    },
    {
      path: "/about",
      name: "about",
      component: About,
    },
    {
      path: "/todos",
      name: "todos",
      component: TodoList,
    },
    {
      path: "/todos/add",
      name: "todos/add",
      component: AddTodo,
    },
    {
      path: "/todos/edit/:id",
      name: "todos/edit/id",
      component: EditTodo,
    },
    {
      path: "/:pathMatch(.*)*", // 위에서 매칭되지 않은 나머지 경로
      name: "NotFound",
      component: NotFound,
    },
  ],
});

export default router;
