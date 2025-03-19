const fs = require("fs");
const path = require("path");

const filePath = path.join(__dirname, "./logs/bench.txt");
const filePath2 = path.join(__dirname, "./logs/squat.txt");
const filePath3 = path.join(__dirname, "./logs/deadlift.txt");

const check = async (name, ...data) => {
	let exist = true;
	for (let i of data) {
		if (i.includes(name)) exist = false;
	}
	return exist;
};

const count = async (name, ...data) => {
	let sum = 0;
	for (let i of data) {
		let temp = i.split("\r\n");
		temp.forEach((item) => {
			let [itemName, itemValue] = item.split(":");
			if (itemName === name) sum += Number(itemValue);
		});
	}

	if (sum >= 500) {
		console.log(`${name} 회원님! 3대 500 돌파! 강력한 힘의 소유자!`);
	} else if (sum >= 200) {
		console.log(`${name} 회원님, 3대 200은 넘으셨네요. 꾸준히 파이팅!`);
	} else {
		console.log(`${name} 회원님, 아직 3대 200은 부족해요. 힘내세요!`);
	}
};

const app = async (name) => {
	if (
		!fs.existsSync(filePath) ||
		!fs.existsSync(filePath2) ||
		!fs.existsSync(filePath3)
	) {
		console.log("운동 기록 파일이 없습니다!");
	} else {
		let benchData = await fs.promises.readFile(filePath, "utf-8");
		let squatData = await fs.promises.readFile(filePath2, "utf-8");
		let deadliftData = await fs.promises.readFile(filePath3, "utf-8");

		if (await check(name, benchData, squatData, deadliftData)) {
			console.log(`${name} 회원님의 기록이 없습니다!`);
		} else {
			await count(name, benchData, squatData, deadliftData);
		}
	}
};

app("이승기");
app("김종국");
app("박보검");
app("유재석");
app("이병헌");
app("정우성");
