<script setup>
import { ref } from "vue";

defineProps({
  userObj: Object,
  isVisible: Boolean,
});
</script>

<template>
  <div
    v-if="isVisible"
    style="z-index: 9999"
    class="flex flex-col justify-around w-2/6 px-6 py-4 border-l-8 shadow-xl border-l-indigo-300 h-2/6 bg-slate-100 rounded-xl"
  >
    <div>
      <span class="label">UserId: </span><br />
      <div class="info">{{ userObj.userId }}</div>
    </div>
    <div>
      <span class="label">姓名: </span><br />
      <div class="info">{{ userObj.name }}</div>
    </div>
    <div>
      <span class="label">电话: </span><br />
      <div class="info">{{ userObj.tel }}</div>
    </div>
    <div
      class="absolute font-bold text-indigo-200 text-7xl left-2/4"
      style="top: 30rem"
    >
      Card
    </div>
  </div>
</template>

<style scoped>
.label {
  @apply text-lg text-gray-500;
}
.info {
  @apply indent-8 text-2xl;
}
</style>
