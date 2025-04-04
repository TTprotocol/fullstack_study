<template>
  <div class="row">
    <div>
      <StudyItem v-for="item in temp" :key="item.id" class="col-md-6" />
    </div>
  </div>
</template>

<script setup>
import StudyItem from '@/components/StudyItem.vue'

const temp = [
  {
    id: 1,
    name: '1',
    age: '10',
  },
  {
    id: 2,
    name: '2',
    age: '20',
  },
  {
    id: 3,
    name: '3',
    age: '30',
  },
]
</script>

<style lang="scss" scoped></style>
