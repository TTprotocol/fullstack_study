import axios from "axios";
import { useAuthStore } from "@/stores/auth";
import router from "@/router";

const instance = axios.create({
	timeout: 1000,
});

// 요청 인터셉터
instance.interceptors.request.use(
	(config) => {
		// JWT 추출
		const { getToken } = useAuthStore();
		const token = getToken();

		if (token) {
			// 토큰이 있는 경우 Authorization 헤더 설정
			config.headers["Authorization"] = `Bearer ${token}`;
			// console.log(config.headers.Authorization);
		}
		return config;
	},
	(error) => {
		console.log("요청 중 에러 발생");
		// 요청 중 에러 발생시
		return Promise.reject(error);
	}
);

// 응답 인터셉터
instance.interceptors.response.use(
	(response) => {
		if (response.status === 200) {
			// 정상 응답 처리
			return response;
		}
		if (response.status === 404) {
			return Promise.reject("404: 페이지 없음 " + response.request);
		}
		return response;
	},
	async (error) => {
		console.log("응답 중 에러 발생 : ", error);
		if (error.response?.status === 401) {
			const { logout } = useAuthStore();
			logout();
			router.push("/auth/login?error=login_required");
			return Promise.reject({ error: "로그인이 필요한 서비스입니다." });
		}
		return Promise.reject(error);
	}
);
export default instance;
