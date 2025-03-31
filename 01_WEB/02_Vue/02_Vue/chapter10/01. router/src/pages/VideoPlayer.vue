<template>
    <div class="modal">
        <div class="box">
            <div class="heading">
                <span class="title"> ::{{ videoInfo.video.title }} </span>
                <span class="category">
                    ( {{ videoInfo.video.category }} )
                </span>
                <span
                    class="float-end badge bg-secondary pointer"
                    @click="stopVideo"
                >
                    X
                </span>
            </div>
            <div class="palyer">
                <!-- autoplay: 자동재생, controls: 컨트롤 사용 여부, ended: 비디오 끝났을 떄 이벤트 -->
                <YoutubeVue3
                    ref="playerRef"
                    :videoid="videoInfo.video.id"
                    :autoplay="1"
                    :controls="1"
                    @ended="playNext"
                />
            </div>
            <div>
                <div>
                    <i
                        class="fa fa-backward ml-3 pointer"
                        @click="playPrev"
                    ></i>
                    <i class="fa fa-stop ml-3 pointer" @click="stopVideo"></i>
                    <i class="fa fa-forward ml-3 pointer" @click="playNext"></i>
                </div>
            </div>
        </div>
    </div>
</template>
<script setup>
import { ref, reactive, inject } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { YoutubeVue3 } from 'youtube-vue3';

// App에서 provide한 json 파일 주입받기
const videos = inject('videos');

const currentRount = useRoute();
const router = useRouter();
// 현재 선택된 비디오 객체 경로의 아이디를 이용해서 찾아오기
const videoInfo = reactive({
    video: videos.find((v) => v.id === currentRount.params.id),
});

console.log('videoInfo : ', videoInfo);

const playerRef = ref(null);

const stopVideo = () => {
    playerRef.value.player.stopVideo();
    // 스크립트에서 다른 페이지로 이동하는 방법
    router.push({ name: 'videos' });
};

const playNext = () => {
    const index = videos.findIndex((v) => v.id === videoInfo.video.id);
    const nextVideo = videos[index + 1];
    if (nextVideo) {
        videoInfo.video = nextVideo;
        router.push({ name: 'videos/id', params: { id: nextVideo.id } });
    } else {
        // 마지막 비디오인 경우 가장 첫 비디오 재생
        videoInfo.video = videos[0];
        router.push({ name: 'videos/id', params: { id: videos[0].id } });
    }
};

const playPrev = () => {
    const index = videos.findIndex((v) => v.id === videoInfo.video.id);
    const prevVideo = videos[index - 1];
    if (prevVideo) {
        // 이전 비디오가 있는 경우
        videoInfo.video = prevVideo;
        router.push({ name: 'videos/id', params: { id: prevVideo.id } });
    }
};
</script>

<style scoped>
.modal {
    display: block;
    position: fixed;
    z-index: 1;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
}
.box {
    background-color: white;
    margin: 80px auto;
    max-width: 500px;
    min-width: 100px;
    min-height: 350px;
    font: 13px 'verdana';
    padding: 10px;
}
.box div {
    padding: 0;
    display: block;
    margin: 10px 0 0 0;
}
.box .heading {
    background-color: #33a17f;
    font-weight: 300;
    text-align: left;
    color: #fff;
    margin: 5px 0 5px 0;
    padding: 10px;
    min-width: 200px;
    max-width: 500px;
}
.box .player {
    background-color: white;
}
.pointer {
    cursor: pointer;
}
</style>
