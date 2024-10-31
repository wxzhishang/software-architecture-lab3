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
    class="flex flex-col justify-around w-2/6 px-6 py-4 shadow-xl border-l-5 border-l-indigo-300 h-2/6 bg-slate-100 rounded-xl"
  >
    <div>联系人</div>
    <div>
      <span>UserId: </span><span>{{ userObj.userId }}</span>
    </div>
    <div>
      <span>姓名: </span><span>{{ userObj.name }}</span>
    </div>
    <div>
      <span>电话: </span><span>{{ userObj.tel }}</span>
    </div>
  </div>
</template>

<style scoped></style>
