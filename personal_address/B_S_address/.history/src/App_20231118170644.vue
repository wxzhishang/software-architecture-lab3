<script setup>
import Detail from "./components/detail.vue";
</script>

<template>
  <div id="container">
    <div class=" "></div>
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
