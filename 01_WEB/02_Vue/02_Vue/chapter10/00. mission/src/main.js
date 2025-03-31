import { createApp } from 'vue';
import 'bootstrap/dist/css/bootstrap.css';
import App from './App.vue';
import router from './router';

const app = createApp(App);

// 라우터를 앱에 연결
app.use(router);

app.mount('#app');
