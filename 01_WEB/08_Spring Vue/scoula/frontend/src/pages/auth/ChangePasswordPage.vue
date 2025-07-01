<script setup>
import { computed, reactive, ref } from "vue";
import { useAuthStore } from "@/stores/auth";
import { useRouter } from "vue-router";
import authApi from "@/api/authApi";

const router = useRouter();
const auth = useAuthStore();

// 사용자 입력 비밀번호를 reactive로 관리
const changePassword = reactive({
	username: auth.username,
	oldPassword: "",
	newPassword: "",
	newPassword2: "",
});

const disableSubmit = computed(
	() =>
		!changePassword.oldPassword ||
		!changePassword.newPassword ||
		!changePassword.newPassword2
);

// 에러 메시지 상태
const error = ref("");
// 입력 시 에러 초기화
const inputPassword = () => (error.value = "");
const resetError = () => (error.value = "");

// 제출시 실행되는 함수
const onSubmit = async () => {
	if (changePassword.newPassword != changePassword.newPassword2) {
		error.value = "새 비밀번호가 일치하지 않습니다.";
		return;
	}

	try {
		await authApi.changePassword(changePassword); // 비밀번호 변경 API 요청
		alert("비밀번호를 수정했습니다.");
		router.push({ name: "profile" });
	} catch (e) {
		error.value = e.response.data;
	}
};
</script>
<template>
	<div class="mt-5 mx-auto" style="width: 500px">
		<h1 class="my-5"><i class="fa-solid fa-lock"></i> 비밀번호 변경</h1>
		<form @submit.prevent="onSubmit">
			<div class="mb-3">
				<label for="password" class="form-label">
					<i class="fa-solid fa-lock"></i>
					이전 비밀번호:
				</label>
				<input
					type="password"
					class="form-control"
					placeholder="이전 비밀번호"
					v-model="changePassword.oldPassword"
					@input="inputPassword"
				/>
			</div>

			<div class="mb-3">
				<label for="password" class="form-label">
					<i class="fa-solid fa-lock"></i>
					새 비밀번호:
				</label>
				<input
					type="password"
					class="form-control"
					placeholder="새 비밀번호"
					v-model="changePassword.newPassword"
					@input="resetError"
				/>
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">
					<i class="fa-solid fa-lock"></i>
					새 비밀번호 확인:
				</label>
				<input
					type="password"
					class="form-control"
					placeholder="새 비밀번호 확인"
					v-model="changePassword.newPassword2"
					@input="resetError"
				/>
			</div>
			<div v-if="error" class="text-danger">{{ error }}</div>
			<button
				type="submit"
				class="btn btn-primary mt-4"
				:disabled="disableSubmit"
			>
				<i class="fa-solid fa-check"></i>
				확인
			</button>
		</form>
	</div>
</template>
