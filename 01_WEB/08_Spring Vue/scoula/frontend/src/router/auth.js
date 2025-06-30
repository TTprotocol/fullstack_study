export default [
	{
		path: "/auth/login",
		name: "login",
		component: () => import("../pages/auth/LoginPage.vue"),
	},
	{
		path: "/auth/join",
		name: "join",
		component: () => import("../pages/auth/JoinPage.vue"),
	},
	{
		path: "/auth/porfile",
		name: "porfile",
		component: () => import("../pages/auth/ProfilePage.vue"),
	},
	{
		path: "/auth/changepassword",
		name: "changepassword",
		component: () => import("../pages/auth/ChangePasswordPage.vue"),
	},
];
