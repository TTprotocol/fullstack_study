<template>
  <div class="container">
    <header>
      <h1>스터디 목록</h1>
      <label for=""> <input type="checkbox" /> 모집 중만 보기</label>
    </header>
    <br />
    <div id="sordContainer">
      <select name="" id="sort" class="form-select">
        <option value="">마감일 임박순</option>
        <option value="">최신 등록일순</option>
        <option value="">좋아요순</option>
      </select>
    </div>
    <StudyList />
    <router-view />
  </div>
</template>

<script setup>
import { reactive, computed, provide, ref } from 'vue'
import StudyList from './pages/StudyList.vue'
import axios from 'axios'

const BASEURL = '/api/studies'

const study = reactive({
  studyList: [],
})

const getData = async () => {
  try {
    const response = await axios.get(BASEURL)
    console.log('response : ', response)

    if (response.status === 200) {
      study.studyList = response.data
    } else {
      alert('데이터 조회 실패')
    }
  } catch (e) {
    alert('데이터 조회 에러 : ', e)
  }
}

provide(
  'study',
  computed(() => study.studyList),
)

getData()
</script>

<style scoped>
#sordContainer {
  display: flex;
  justify-self: end;
}
#sort {
  width: 150px;
}
</style>
