import { createRouter, createWebHashHistory } from "vue-router";

export const routes = [
    {
        path: "/6",
        name: "list",
        meta: {
            title: '通讯录'
        },
        components: () => import('@/views/list.vue')
    }
]

const rouetr = createRouter({
    history: createWebHashHistory(),
    routes
})

export default rouetr;