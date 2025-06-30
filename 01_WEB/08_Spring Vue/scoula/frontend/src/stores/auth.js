import { ref, computed, reactive } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

const initState = {
	token: "", // 접근 토큰(JWT)
	user: {
		username: "", // 사용자 ID
		email: "", // Email
		roles: [], // 권한 목록
	},
};

// 스토어 정의
export const useAuthStore = defineStore("auth", () => {
	const state = ref({ ...initState });
	const isLogin = computed(() => !!state.value.user.username); // 로그인 여부. 강제로 boolean으로 형변환
	const username = computed(() => state.value.user.username); // 로그인 된 사용자 ID
	const email = computed(() => state.value.user.email); // 로그인 된 사용자 email

	const login = async (member) => {
		// 로그인 요청

		// state.value.token = "test token";
		// state.value.user = {
		// 	username: member.username,
		// 	email: member.username + "@test.com",
		// };

		// api 호출
		const { data } = await axios.post("/api/auth/login", member);
		console.log("data : ", data);
		state.value = { ...data };

		// auth 라는 키에 JSON 직렬화해서 로컬 스토리지에 저장
		localStorage.setItem("auth", JSON.stringify(state.value));
	};

	// 로그아웃 함수
	const logout = () => {
		localStorage.clear();
		state.value = { ...initState };
	};

	// 토큰 조회
	const getToken = () => state.value.token;

	// 초기 상태 로딩 (새로고침 시 유지)
	const load = () => {
		const auth = localStorage.getItem("auth");
		if (auth != null) {
			// 로컬 스토리지에 있는 데이터 역직렬화
			state.value = JSON.parse(auth);
			console.log(state.value); // 디버깅용 출력
		}
	};

	load(); // 컴포넌트 마운트 시 호출

	// 외부에서 사용할 값 반환
	return { state, username, email, isLogin, login, logout, getToken };
});
