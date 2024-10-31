<script setup>
import { ref } from "vue";
import Detail from "./components/detail.vue";
import { addAPI, updateAPI, deleteAPI, getAPI } from "./api/index";

const info = ref({
  name: "",
  tel: "",
});

const list = ref([]);
</script>

<template>
  <div id="container" class="w-full h-full font-mono font-bold text-zinc-400">
    <div
      class="flex flex-col w-4/12 px-4 pb-3 divide-y-4 divide-indigo-300 rounded-lg shadow-2xl bg-zinc-50 h-5/6"
    >
      <div class="flex w-full py-4 h-1/6">
        <img
          class="relative border-8 border-indigo-400 rounded-full w-28 h-28 border-r-transparent bottom-12"
          src="https://p26-passport.byteacctimg.com/img/user-avatar/e5e9ab059d24e127c8d7a42cdfc95619~40x40.awebp"
          alt="avatar"
        />
        <div class="mt-8 ml-10 text-4xl">Liushi_21 通讯录</div>
      </div>
      <div class="flex-1 w-full py-4">
        <div class="flex items-center justify-around w-full h-fit">
          <label for="">姓名</label
          ><input
            placeholder="输入联系人姓名"
            class="inputBar"
            type="text"
            v-model="info.name"
          />
          <label for="">电话</label
          ><input
            placeholder="输入联系人电话号码"
            class="inputBar"
            type="text"
            v-model="info.tel"
          />
          <button class="px-2 py-2 text-white bg-indigo-400 rounded-md">
            添加
          </button>
        </div>
      </div>
    </div>
  </div>
  <Detail msg="Vite + Vue" />
</template>

<style scoped>
.inputBar {
  @apply w-2/6 px-3 py-2 transition-all font-bold bg-slate-200 focus:bg-gray-400 focus:text-slate-200 rounded-lg;
}
#container {
  position: absolute;
  left: 50%;
  top: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  transform: translate(-50%, -50%);
}
input[type="text"]:focus {
  outline: none;
}
</style>
