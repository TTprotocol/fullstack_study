import "./assets/main.css";
import "bootstrap/dist/css/bootstrap.css";
import "vue-awesome-paginate/dist/style.css";

import { createApp } from "vue";
import { createPinia } from "pinia";
import VueAwesomePaginate from "vue-awesome-paginate";
import { useKakao } from "vue3-kakao-maps/@utils";

const rest_api_key = "ab557a64208499e31577d27a99799472"; // Javascript 키 값
useKakao(rest_api_key, ["services"]);

import App from "./App.vue";
import router from "./router";

const app = createApp(App);

app.use(VueAwesomePaginate);
app.use(createPinia());
app.use(router);

app.mount("#app");
