<script setup>
import Detail from "./components/detail.vue";
</script>

<template>
  <div id="container" class="w-full h-full">
    <div
      class="flex flex-col w-4/12 px-4 pb-3 rounded-lg shadow-2xl bg-zinc-100 h-5/6"
    >
      <div class="w-full bg-teal-300 h-2/6"></div>
      <div class="flex-1 w-full"></div>
    </div>
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
