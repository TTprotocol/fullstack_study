<script setup>
import BaseButton from "./UI/BaseButton.vue";
import BaseAlert from "./UI/BaseAlert.vue";
import BaseBadge from "./UI/BaseBadge.vue";
</script>
<template>
  <!-- 그리드 컨테이너 -->
  <main class="component-grid">
    <!-- 컴포넌트 그룹 (그리드 아이템) -->
    <section class="component-card">
      <h2>버튼</h2>
      <!-- <button class="btn-primary">Primary</button>
      <button class="btn-outline">Outline</button>
      <button class="btn-pill">Pill</button> -->
      <!-- <BaseButton class="btn-primary">Primary</BaseButton>
      <BaseButton class="btn-outline">Outline</BaseButton>
      <BaseButton class="btn-pill">Pill</BaseButton> -->
      <BaseButton variant="primary">Primary</BaseButton>
      <BaseButton variant="outline">Outline</BaseButton>
      <BaseButton variant="pill">Pill</BaseButton>
    </section>
    <!-- 컴포넌트 그룹 (그리드 아이템) -->
    <section class="component-card">
      <h2>알림창</h2>
      <!-- <div class="alert-success">성공 메시지</div>
      <div class="alert-warning">경고 메시지</div>
      <div class="alert-error">에러 메시지</div> -->
      <BaseAlert variant="success">성공 메시지</BaseAlert>
      <BaseAlert variant="warning">경고 메시지</BaseAlert>
      <BaseAlert variant="error">에러 메시지</BaseAlert>
    </section>
    <!-- 컴포넌트 그룹 (그리드 아이템) -->
    <section class="component-card">
      <h2>배지</h2>
      <BaseBadge variant="success">Success</BaseBadge>
      <BaseBadge variant="number">5</BaseBadge>
    </section>
  </main>
</template>
<style scoped></style>
