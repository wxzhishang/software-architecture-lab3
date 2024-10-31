<script setup>
import Detail from "./components/detail.vue";
</script>

<template>
  <div id="container">
    <div class="w-5/12 h-4/6 bg-teal-400"></div>
  </div>
  <Detail msg="Vite + Vue" />
</template>

<style scoped>
#container {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
</style>
