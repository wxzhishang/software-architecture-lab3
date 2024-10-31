<script setup>
import Detail from "./components/detail.vue";
</script>

<template>
  <div id="container" class="w-full h-full font-mono font-bold text-zinc-400">
    <div
      class="flex flex-col w-4/12 px-4 pb-3 divide-y-4 divide-indigo-300 rounded-lg shadow-2xl bg-zinc-100 h-5/6"
    >
      <div class="w-full py-4 bg-teal-300 h-1/6"></div>
      <div class="flex-1 w-full py-4"></div>
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
