<script setup>
import { ref } from "vue";

defineProps({
  userObj: Object,
  isVisible: Boolean,
});
</script>

<template>
  <div style="z-index: 9999" class="w-60 h-3/6 bg-slate-400 rounded-xl"></div>
</template>

<style scoped></style>
