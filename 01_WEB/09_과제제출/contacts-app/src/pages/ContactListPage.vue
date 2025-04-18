<template>
	<div>
		<h1><i class="fa-solid fa-address-book"></i> 연락처</h1>
		<div>
			<table class="table">
				<thead>
					<tr>
						<td>id</td>
						<td>name</td>
						<td>tel</td>
					</tr>
				</thead>
				<tbody>
					<tr v-for="contact in data.contactsList" :key="contact.id">
						<td>{{ contact.id }}</td>
						<td @click="router.push(`/contacts/detail/${contact.id}`)">
							<img :src="contact.photo" alt="#" id="image" />
							{{ contact.name }}
						</td>
						<td>{{ contact.tel }}</td>
					</tr>
				</tbody>
			</table>
			<div id="addContacts">
				<button
					id="addContactsBtn"
					class="btn btn-primary"
					@click="router.push(`/contacts/write`)"
				>
					<i class="fa-solid fa-pen-to-square"></i> 새 연락처
				</button>
			</div>
		</div>
	</div>
</template>

<script setup>
import { reactive, onMounted } from "vue";
import { useRouter } from "vue-router";
import axios from "axios";

const BASEULI = "/api/contacts";
const router = useRouter();
const data = reactive({ contactsList: [] });

onMounted(() => {
	fetchData();
});

const fetchData = async () => {
	try {
		const response = await axios.get(BASEULI);

		if (response.status === 200) {
			data.contactsList = response.data;
		} else {
			console.log("contactsList 조회 실패!");
		}
	} catch (error) {
		console.log("contactsList Axios 실패! : ", error);
	}
};

const MoveDetail = () => {};
</script>

<style scoped>
#image {
	width: 1rem;
	border-radius: 50%;
}
#addContacts {
	position: relative;
}
#addContactsBtn {
	position: absolute;
	right: 0;
}
</style>
