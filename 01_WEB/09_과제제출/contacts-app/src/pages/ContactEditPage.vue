<template>
	<div id="app">
		<h1><i class="fa-solid fa-pen-to-square"></i> 연락처 수정</h1>
		<div class="form">
			<label for="name">name:</label>
			<input
				id="name"
				type="text"
				class="form-control"
				placeholder="이름을 입력하세요"
				v-model="data.name"
				required
			/>
		</div>
		<div class="form">
			<label for="tel">tel:</label>
			<input
				id="tel"
				type="text"
				class="form-control"
				placeholder="전화번호를 입력하세요"
				v-model="data.tel"
				required
			/>
		</div>
		<div class="form">
			<label for="address">address:</label>
			<input
				id="address"
				type="text"
				class="form-control"
				placeholder="주소를 입력하세요"
				v-model="data.address"
			/>
		</div>
		<div class="form">
			<label for="photo">photo url:</label>
			<input
				id="photo"
				type="text"
				class="form-control"
				placeholder="사진의 url을 입력하세요"
				v-model="data.photo"
			/>
		</div>
		<div id="button_group">
			<button class="btn btn-primary check_button" @click="modalControll">
				<i class="fa-solid fa-check"></i>확인
			</button>
			<button class="btn btn-primary" @click="router.push(`/contacts`)">
				<i class="fa-solid fa-rotate-left"></i>취소
			</button>
		</div>
		<div id="modal" v-show="showModal">
			<h3 id="title">저장하시겠습니까?</h3>
			<div id="modal_burron_group">
				<button class="btn btn-danger" @click="updateHandle">저장</button>
				<button class="btn btn-primary" @click="modalControll">취소</button>
			</div>
		</div>
	</div>
</template>

<script setup>
import { ref, reactive, onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";
import axios from "axios";

const BASEURI = "/api/contacts/";
const router = useRouter();
const route = useRoute();

let showModal = ref(false);
const id = ref("");
const data = reactive({
	name: "",
	tel: "",
	address: "",
	photo: "",
});

onMounted(() => {
	fetchData();
});

const fetchData = async () => {
	try {
		const response = await axios.get(BASEURI + route.params.id);

		if (response.status === 200) {
			data.name = response.data.name;
			data.tel = response.data.tel;
			data.address = response.data.address;
			data.photo = response.data.photo;
		} else {
			console.log("detailData 조회 실패!");
		}
	} catch (error) {
		console.log("detailData 조회 실패! : ", error);
	}
};

const modalControll = () => {
	showModal.value = !showModal.value;
};

const updateHandle = async () => {
	try {
		console.log("data /; ", data);
		if (data.name === "" || data.tel === "") {
			alert("이름과 전화번호를 입력하세요!");
			modalControll();
		} else {
			const response = await axios.put(BASEURI + route.params.id, data);

			if (response.status === 200) {
				router.push("/contacts");
			} else {
				console.log("저장 실패!");
			}
		}
	} catch (error) {
		console.log("저장 실패! : ", error);
	}
};
</script>

<style scoped>
#app {
	position: relative;
}
.form {
	margin-bottom: 20px;
}

#button_group {
	display: flex;
	justify-content: center;
}

.check_button {
	margin-right: 10px;
}
#modal {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	position: absolute;
	width: 500px;
	height: 150px;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	background-color: white;
	box-shadow: 5px 5px gray;
}

#modal_burron_group {
	width: 50%;
	display: flex;
	justify-content: space-between;
	margin-top: 30px;
	/* border: 1px solid red; */
}
</style>
