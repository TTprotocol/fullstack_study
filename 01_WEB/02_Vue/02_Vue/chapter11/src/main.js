import { createApp } from "vue";
import App from "./App.vue";
import AppVue2 from "./AppVue2.vue";
import AppVue3 from "./AppVue3.vue";
import AppVue4 from "./AppVue4.vue";
import AppVue5 from "./AppVue5.vue";
import MissionApp from "./MissionApp.vue";
import router from "./router";

// const app = createApp(App);
// const app = createApp(AppVue2);
// const app = createApp(AppVue3);
// const app = createApp(AppVue4);
// const app = createApp(AppVue5);
const app = createApp(MissionApp);

app.use(router);

app.mount("#app");
