import { createRouter, createWebHistory } from "vue-router";
import ContactListPage from "@/pages/ContactListPage.vue";
import ContactDetailPage from "@/pages/ContactDetailPage.vue";
import ContactWritePage from "@/pages/ContactWritePage.vue";
import ContactEditPage from "@/pages/ContactEditPage.vue";

const router = createRouter({
	history: createWebHistory(import.meta.env.BASE_URL),
	routes: [
		{
			path: "/",
			name: "home",
			redirect: "/contacts",
		},
		{
			path: "/contacts",
			name: "contacts",
			component: ContactListPage,
		},
		{
			path: "/contacts/detail/:id",
			name: "contacts/detail",
			component: ContactDetailPage,
		},
		{
			path: "/contacts/write",
			name: "contact/write",
			component: ContactWritePage,
		},
		{
			path: "/contacts/edit/:id",
			name: "contacts/edit",
			component: ContactEditPage,
		},
	],
});

export default router;
