const fs = require('fs');
const path = require('path');

const filePath = path.join(__dirname, './logs/memberRoutine.txt');
const filePath2 = path.join(__dirname, './logs/routine.txt');

let upState = ['벤치프레스 3세트', '어깨프레스 3세트', '팔굽혀펴기 50개'];
let downState = ['스쿼트 5세트', '런지 3세트', '레그프레스 4세트'];

const recommand = async (data, name, record) => {
    console.log(`운동 루틴 추천 중... (${name})`);

    if (data.includes(name)) {
        setTimeout(() => {
            console.log(name + ' 회원님은 이미 추천을 받으셨습니다!');
        }, 1000);
    } else {
        await fs.promises.appendFile(filePath2, record).then(() => {
            setTimeout(() => {
                console.log(record);
                console.log('추천 루틴이 기록되었습니다!');
            }, 1000);
        });
    }
};

const app = async () => {
    if (!fs.existsSync(filePath)) {
        // 파일 없음
        console.log('회원 루틴 파일이 없습니다!');
    } else if (!fs.existsSync(filePath2)) {
        // 파일 없음
        console.log('운동 루틴 기록 파일이 없습니다!');
    } else {
        let readData = await fs.promises.readFile(filePath, 'utf-8');
        let data = await fs.promises.readFile(filePath2, 'utf-8');
        // console.log('random : ', random);

        let read = readData.split('\r\n');

        await recommand(data, name, record);

        // read.forEach(async (item) => {
        //     let name = item.split(': ')[0];
        //     let state = item.split(': ')[1];
        //     let random = Math.floor(Math.random() * 10) % 3;
        //     let record =
        //         name +
        //         ' 회원님, 오늘의 ' +
        //         state +
        //         " 추천 운동은 '" +
        //         (state === '상체' ? upState[random] : downState[random]) +
        //         "'입니다! 화이팅!\n";

        //     await recommand(data, name, record);
        // });
    }
};

app();
