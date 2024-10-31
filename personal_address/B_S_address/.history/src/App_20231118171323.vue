<script setup>
import Detail from "./components/detail.vue";
</script>

<template>
  <div id="container" class="w-full h-full">
    <div class="w-3/12 bg-teal-400 rounded-lg shadow-2xl h-5/6"></div>
  </div>
  <Detail msg="Vite + Vue" />
</template>

<style scoped>
#container {
  position: absolute;
  left: 50%;
  top: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  transform: translate(-50%, -50%);
}
</style>
