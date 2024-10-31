<script setup>
import page from "@/views/list.vue";
</script>

<template>
  <div id="container">
    <router-view></router-view>
  </div>
</template>

<style scoped>
#container {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
</style>
