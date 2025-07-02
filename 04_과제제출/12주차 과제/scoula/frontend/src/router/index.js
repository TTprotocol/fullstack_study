import { createRouter, createWebHistory } from "vue-router";
import HomePage from "../pages/HomePage.vue";
import authRotes from "./auth";
import boardRotes from "./board";
import travelRotes from "./travel";
import galleryRotes from "./gallery";

const router = createRouter({
	history: createWebHistory(import.meta.env.BASE_URL),
	routes: [
		{ path: "/", name: "home", component: HomePage },
		...authRotes,
		...boardRotes,
		...travelRotes,
		...galleryRotes,
	],
});

export default router;
