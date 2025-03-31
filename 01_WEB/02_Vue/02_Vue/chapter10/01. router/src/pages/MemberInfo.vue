<template>
    <!-- <div class="card card-body">
        <h2>Member Info</h2>
        <div>
            경로 패턴: /members/:id<br />
            요청 경로: {{ currentRoute.path }}<br />
            params로 해당 경로의 파라미터 중에 id값만 가져온다. <br />
            id값: {{ currentRoute.params.id }}<br />
        </div>
    </div> -->

    <div class="mt-5">
        <img :src="member.photo" class="img" />
        <h4 class="mt-2">{{ member.name }} {{ member.role }}</h4>
        <p>{{ member.desc }}</p>
        <a
            v-if="member.insta && member.insta !== ''"
            :href="member.insta"
            class="fa-brands fa-insta m-1"
        ></a>
        <a
            v-if="member.facebook && member.facebook !== ''"
            :href="member.facebook"
            class="fa-brands fa-facebook m-1"
        ></a>
        <a
            v-if="member.youtube && member.youtube !== ''"
            :href="member.youtube"
            class="fa-brands fa-youtube m-1"
        ></a>
        <br /><br />
        <router-link :to="{ name: 'members' }">멤버 목록으로</router-link>
    </div>
</template>
<script>
import { useRoute } from 'vue-router';
import members from '@/members.json';

export default {
    name: 'MemberInfo',
    setup() {
        const currentRoute = useRoute();
        // 경로 내의 데이터는 문자열이기 때문에 파싱 필요
        const id = parseInt(currentRoute.params.id, 10);
        // 경로에 있는 아이디와 일치하는 데이터를 json에서 찾는다.
        const member = members.find((m) => m.id === id);

        return { currentRoute, member };
    },
};
</script>

<style>
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.0/css/all.min.css');
.fa {
    padding: 5px;
    width: 30px;
    text-align: center;
    text-decoration: none;
    margin: 5px 2px;
}
.fa-facebook {
    background-color: #3b5998;
    color: white;
}
.fa-youtube {
    background-color: #bb0000;
    color: white;
}
.fa-instagram {
    background-color: #125688;
    color: white;
}
</style>
