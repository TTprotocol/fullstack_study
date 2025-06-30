import { fileURLToPath, URL } from "node:url";

import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";
import vueDevTools from "vite-plugin-vue-devtools";

// https://vite.dev/config/
export default defineConfig({
	plugins: [vue(), vueDevTools()],
	resolve: {
		alias: {
			"@": fileURLToPath(new URL("./src", import.meta.url)),
		},
	},
	server: {
		proxy: {
			"/api": {
				target: "http://localhost:8080",
			},
		},
	},
	build: {
		outDir:
			"D:/IT's Your Life/fullstack/01_WEB/08_Spring Vue/scoula/backend/src/main/webapp/resources",
	},
});
