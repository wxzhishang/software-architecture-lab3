<script setup>
import { ref } from "vue";
import Detail from "./components/detail.vue";
import { addAPI, updateAPI, deleteAPI, getAPI } from "./api/index";

const info = ref({
  name: "",
  tel: "",
});

const list = ref([]);

const pagination = ref({
  page: 1,
  pageSize: 10,
});

function create() {
  addAPI(info.value).then(({ code }) => {
    if (code == 200) {
      loadList();
      alert("添加成功");
    }
  });
}

function deleteItem(id) {}

function loadList() {
  getAPI().then(({ data }) => {
    list.value = data;
  });
}

function update(id) {}

loadList();
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
      <div class="flex flex-col flex-1 w-full py-4">
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
          <button
            @click="create"
            class="px-2 py-2 text-white bg-indigo-400 rounded-md"
          >
            添加
          </button>
        </div>
        <div class="py-3 font-mono text-3xl w-fit" style="margin: 0 auto">
          Show Here
        </div>
        <div
          class="flex flex-col flex-1 w-full px-2 mx-auto mb-4 overflow-auto rounded-xl"
        >
          <transition-group tag="ul">
            <li
              class="flex justify-between w-full py-4 h-fit"
              v-for="(item, index) in list.slice(
                (pagination.page - 1) * pagination.pageSize,
                pagination.page * pagination.pageSize
              )"
              :key="index"
            >
              <div class="text-center w-36">{{ item.name }}</div>
              <div class="flex items-center justify-center w-2/6 text-center">
                {{ item.tel }}
              </div>
              <div class="flex justify-around w-36">
                <button
                  class="px-2 py-2 transition-all text-cyan-500 hover:text-white hover:bg-cyan-500"
                >
                  查看
                </button>
                <button
                  class="px-2 py-2 transition-all text-cyan-500 hover:text-white hover:bg-cyan-500"
                >
                  修改
                </button>
                <button
                  class="px-2 py-2 text-red-500 transition-all hover:text-white hover:bg-red-500"
                >
                  删除
                </button>
              </div>
            </li>
          </transition-group>
        </div>
        <div style="margin: 0 auto" class="flex text-xl w-fit">
          <button
            :disabled="pagination.page == 1"
            class="hover:text-indigo-400"
          >
            Pre
          </button>
          <div class="mx-10">
            {{ pagination.page }}/{{
              Math.ceil(list.length / pagination.pageSize)
            }}
          </div>
          <button
            :disabled="
              pagination.page == Math.ceil(list.length / pagination.pageSize)
            "
            class="hover:text-indigo-400"
          >
            next
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

::-webkit-scrollbar {
  width: 8px;
}
::-webkit-scrollbar-thumb {
  background-color: rgb(81, 84, 247);
  border-radius: 15px;
}
::-moz-scrollbar {
  width: 8px;
}
::-moz-scrollbar-thumb {
  background-color: rgb(81, 84, 247);
}
</style>
