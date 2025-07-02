<script setup>
import { computed } from "vue";
import MenuItem from "./MenuItem.vue";
import AccountMenuItem from "./AccountMenuItem.vue";
import LogoutMenuItem from "./LogoutMenuItem.vue";

import config from "@/config";
import { useAuthStore } from "@/stores/auth.js";

const { login, join } = config.accountMenus;
const auth = useAuthStore();

// 로그인 여부 및 사용자 이름을 반응형으로 사용
const islogin = computed(() => auth.isLogin);
const username = computed(() => auth.username);
</script>
<template>
	<ul class="navbar-nav ms-auto">
		<!-- 로그인한 경우 : 사용자 정보 + 로그아웃 버튼 -->
		<template v-if="islogin">
			<AccountMenuItem :username="username" />
			<LogoutMenuItem />
		</template>
		<template v-else>
			<MenuItem :menu="login" />
			<MenuItem :menu="join" />
		</template>
	</ul>
</template>
