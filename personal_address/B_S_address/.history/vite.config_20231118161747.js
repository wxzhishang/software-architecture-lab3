import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import tailwindcss from 'tailwindcss'
import autoprefixer from 'autoprefixer'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
    resolve: {
    alias: [
      {
        find: '@/',
        replacement: '/src/'
      }
    ]
  },
  css: {
    postcss: {
      plugins: [tailwindcss, autoprefixer]
    }
   }
})
