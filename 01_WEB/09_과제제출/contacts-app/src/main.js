// import "./assets/main.css";
// import "bootstrap5/dist/css/bootstrap.css";
import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";

// import "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css";

const app = createApp(App);

app.use(router);

app.mount("#app");
