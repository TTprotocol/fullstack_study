import fs from "fs";
import path from "path";
import { fileURLToPath } from "url";

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const filePath = path.join(__dirname, "./education_records.json");

export class EducationManager {
	constructor() {
		this.programs = [];
	}
	registerProgram({ title, description }) {
		this.programs.push({
			title,
			description,
			isCompleted: false,
		});
	}

	completeProgramWithFunction(title) {
		console.log("this 1 : ", this);
		this.programs.filter((item) => {
			if (item.title === title) item.isCompleted = true;
		});
	}

	completeProgramWithArrowFunction = (title) => {
		console.log("this 2 : ", this);
		this.programs.filter((item) => {
			if (item.title === title) item.isCompleted = true;
		});
	};

	saveToFile = async () => {
		await fs.promises.appendFile(
			filePath,
			JSON.stringify(this.programs, null, 2)
		);
	};
}
