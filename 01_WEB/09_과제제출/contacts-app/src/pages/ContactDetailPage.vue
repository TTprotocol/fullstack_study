<template>
	<div id="app">
		<h1><i class="fa-solid fa-address-card"></i> 연락처</h1>
		<div id="card_component" class="card">
			<div id="image_container">
				<img id="image" :src="data.detailData.photo" alt="#" />
			</div>
			<div id="card_contents">
				<div>
					<ul id="contents">
						<li>
							<div>ID</div>
							<div>{{ data.detailData.id }}</div>
						</li>
						<li>
							<div>name</div>
							<div>{{ data.detailData.name }}</div>
						</li>
						<li>
							<div>tel</div>
							<div>{{ data.detailData.tel }}</div>
						</li>
						<li>
							<div>address</div>
							<div>{{ data.detailData.address }}</div>
						</li>
					</ul>
				</div>
				<div id="button_group">
					<button class="btn btn-primary" @click="router.push(`/contacts`)">
						<i class="fa-solid fa-list"></i> 목록
					</button>
					<button
						class="btn btn-primary"
						@click="router.push(`/contacts/edit/${data.detailData.id}`)"
					>
						<i class="fa-solid fa-pen-to-square"></i> 수정
					</button>
					<button class="btn btn-danger" @click="modalControll">
						<i class="fa-solid fa-trash-can"></i> 삭제
					</button>
				</div>
			</div>
		</div>
		<div id="modal" v-show="showModal">
			<h3 id="title">삭제하시겠습니까?</h3>
			<div id="modal_burron_group">
				<button class="btn btn-danger" @click="deleteHandle">삭제</button>
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
const data = reactive({ detailData: {} });

onMounted(() => {
	fetchData();
});

const fetchData = async () => {
	try {
		const response = await axios.get(BASEURI + route.params.id);

		if (response.status === 200) {
			data.detailData = response.data;
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

const deleteHandle = async () => {
	try {
		const response = await axios.delete(BASEURI + route.params.id);

		if (response.status === 200) {
			router.push("/contacts");
		} else {
			console.log("삭제 실패!");
		}
	} catch (error) {
		console.log("삭제 실패! : ", error);
	}
};
</script>

<style scoped>
#app {
	position: relative;
}
#card_component {
	display: flex;
	flex-direction: row;
	padding: 20px;
}
#image_container {
	width: 30%;
}
#image {
	width: 100%;
	border-radius: 20%;
}
#card_contents {
	width: 70%;
	padding: 20px;
}
#contents > li {
	display: flex;
}
#contents > li > div:first-child {
	width: 50%;
}

#button_group {
	margin-left: 30px;
}
#button_group > button {
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
