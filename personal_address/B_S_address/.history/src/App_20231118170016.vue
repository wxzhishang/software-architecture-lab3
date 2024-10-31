<script setup>
import Page from "@/views/list.vue";
</script>

<template>
  <div id="container"><Page /></div>
</template>

<style scoped>
#container {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
</style>
