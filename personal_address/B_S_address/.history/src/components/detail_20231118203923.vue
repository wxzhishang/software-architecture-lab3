<script setup>
import { ref } from "vue";

defineProps({
  userObj: Object,
  isVisible: Boolean,
});
</script>

<template>
  <div
    style="z-index: 9999"
    class="w-2/6 px-6 py-4 shadow-xl h-2/6 bg-slate-100 rounded-xl"
  ></div>
</template>

<style scoped></style>
