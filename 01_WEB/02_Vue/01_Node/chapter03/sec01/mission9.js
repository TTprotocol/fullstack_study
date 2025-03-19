const fs = require("fs");
const path = require("path");

const filePath = path.join(__dirname, "./logs/memberRoutine.txt");
const filePath2 = path.join(__dirname, "./logs/routine.txt");

const recommand = {
	상체: ["벤치프레스 3세트", "어깨프레스 3세트", "팔굽혀펴기 50개"],
	하체: ["스쿼트 5세트", "런지 3세트", "레그프레스 4세트"],
};

const app = async () => {
	let memberRoutin = await fs.promises.readFile(filePath, "utf-8");
	let member = memberRoutin.split("\r\n");

	for (let i of member) {
		let [name, type] = i.split(": ");

		console.log(`운동 루틴 추천 중... (${name})`);
		let check = await fs.promises.readFile(filePath2, "utf-8");
		if (check.includes(name)) {
			console.log(`${name} 회원님은 이미 추천을 받으셨습니다!`);
		} else {
			let random = Math.floor(Math.random() * recommand[type].length);
			let dataRecommand = await new Promise((resolve, reject) => {
				setTimeout(() => {
					const recode = `${name} (${type}): ${recommand[type][random]}\n`;
					console.log(
						`${name} 회원님, 오늘의 ${type} 추천 루틴은 '${recommand[type][random]}'입니다! 화이팅!`
					);
					resolve(recode);
				}, 1000);
			});

			await fs.promises.appendFile(filePath2, dataRecommand);
			console.log("추천 루틴이 기록되었습니다!");
		}
	}
};

app();

// 정답 코드 -----------------------------------------------
// const fs = require('fs').promises;
// const path = require('path');

// // 상체 및 하체 루틴 목록
// const routines = {
//     상체: ['벤치프레스 3세트', '어깨프레스 3세트', '팔굽혀펴기 50개'],
//     하체: ['스쿼트 5세트', '런지 3세트', '레그프레스 4세트']
// };

// // 랜덤으로 루틴을 선택하는 함수
// const selectRoutine = (type) => {
//     const options = routines[type];
//     return options[Math.floor(Math.random() * options.length)];
// };

// // 비동기적으로 루틴을 추천하는 함수
// const recommendRoutine = (name, type) => {
//     return new Promise((resolve) => {
//         setTimeout(() => {
//             const routine = selectRoutine(type);
//             console.log(`${name} 회원님, 오늘의 ${type} 추천 루틴은 '${routine}'입니다! 화이팅!`);
//             resolve(`${name} (${type}): ${routine}\n`);
//         }, 1000);
//     });
// };

// // 이미 추천된 회원인지 확인하는 함수
// const isAlreadyRecommended = async (name) => {
//     const routineFilePath = path.join(__dirname, 'logs', 'routine.txt');
//     try {
//         const data = await fs.readFile(routineFilePath, 'utf-8');
//         return data.includes(name);
//     } catch {
//         return false;
//     }
// };

// // 추천된 루틴을 파일에 기록하는 함수
// const saveRoutine = async (record) => {
//     const routineFilePath = path.join(__dirname, 'logs', 'routine.txt');
//     await fs.appendFile(routineFilePath, record);
//     console.log(`추천 루틴이 기록되었습니다!`);
// };

// // 전체 프로세스를 처리하는 메인 함수
// const runRoutineRecommendations = async () => {
//     const memberFilePath = path.join(__dirname, 'logs', 'memberRoutine.txt');

//     try {
//         const membersData = await fs.readFile(memberFilePath, 'utf-8');
//         const members = membersData.trim().split('\n');

//         for (const member of members) {
//             const [name, type] = member.split(':').map((item) => item.trim());

//             console.log(`운동 루틴 추천 중... (${name})`);

//             const alreadyRecommended = await isAlreadyRecommended(name);
//             if (alreadyRecommended) {
//                 console.log(`${name} 회원님은 이미 추천을 받으셨습니다!`);
//                 continue;
//             }

//             const record = await recommendRoutine(name, type);
//             await saveRoutine(record);
//         }
//     } catch (err) {
//         console.error('회원 루틴 파일이 없습니다!');
//     }
// };

// // 함수 실행
// runRoutineRecommendations();
