import {defineConfig} from 'vite'
import preact from '@preact/preset-vite'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    preact({
      prerender: {
        enabled: true,
        renderTarget: '#app',
        prerenderScript: '/src/index.tsx'
      }
    })
  ],
  build: {
    emptyOutDir: true,
    outDir: "../resources/static",
    rollupOptions: {
      input: [
        "index.html",
        "404.html"
      ]
    }
  }
})
