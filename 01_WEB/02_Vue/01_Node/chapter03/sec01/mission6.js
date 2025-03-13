const fs = require('fs');
const path = require('path');

const filePath = path.join(__dirname, './logs/checkin.txt');

const app = async (name) => {
    if (!fs.existsSync(filePath)) {
        // 파일 없음
        console.log('출석 기록 파일이 없습니다!');
    } else {
        let data = await fs.promises.readFile(filePath, 'utf-8');

        // console.log(data);
        console.log('출석 중...');
        if (data.indexOf(name) > 0) {
            setTimeout(() => {
                console.log(name + ' 회원님은 이미 출석하셨습니다!');
            }, 1000);
        } else {
            let date = new Date();
            let text =
                '\n' +
                name +
                ': 출석 완료 (' +
                date.getFullYear() +
                '-' +
                date.getMonth().toString().padStart(2, '0') +
                '-' +
                date.getDay().toString().padStart(2, '0') +
                ' ' +
                date.getHours() +
                ':' +
                date.getMinutes() +
                ':' +
                date.getSeconds() +
                ')';
            await fs.promises.appendFile(filePath, text).then(() => {
                setTimeout(() => {
                    console.log(text);
                }, 1000);
            });
        }
    }
};

app('박준영');
