import fs from "fs";
import path from "path";
import { fileURLToPath } from "url";

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const filePath = path.join(__dirname, "./pet_album.json");

export class PetAlbumManager {
	constructor() {
		this.album = [];
	}

	addRecord = async (photo) => {
		// console.log("photo : ", photo);
		let readData = await fs.promises.readFile(filePath, "utf-8");

		if (readData.includes(photo["name"]) && readData.includes(photo["type"])) {
			console.log(
				`[등록 오류] ${photo["name"]}: 중복된 ${
					photo["type"] === "Photo" ? "사진" : "성장 기록"
				}입니다.`
			);
		} else {
			console.log(
				`[등록 완료] ${photo["name"]}: ${photo["type"]}가 등록되었습니다.`
			);
			this.album.push(photo);
			let write = await fs.promises.writeFile(
				filePath,
				JSON.stringify(this.album),
				(err) => {
					console.log("[파일 저장 완료] 앨범 기록이 파일로 저장되었습니다.");
				}
			);
			console.log("[파일 저장 완료] 앨범 기록이 파일로 저장되었습니다.");
		}
		// let read = JSON.parse(readData);
		// console.log("read : ", read[0]);
	};
}
