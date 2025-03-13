const fs = require('fs');
const path = require('path');

const filePath = path.join(__dirname, 'logs/members.txt');
const createFilePath = path.join(filePath, 'kim_jong_kook.txt');
const text = '김종국, 나이: 45, 체중: 80kg, 운동: 벤치프레스 100kg';

// 폴더가 없으면 생성
if (!fs.existsSync(filePath)) {
    fs.mkdirSync(filePath, { recursive: true }); // { recursive: true } : 중첩 폴더 생성 가능
}

fs.writeFile(createFilePath, text, 'utf-8', (err) => {
    if (err) {
        console.log('err: ', err);
    }
    console.log('파일 생성 완료');
    const nowPath = path.parse(createFilePath);
    // console.log('nowPath : ', nowPath);
    console.log('디렉터리 경로 : ', nowPath['dir']);
    console.log('파일 이름 : ', nowPath['base']);
    console.log('파일 확장자 : ', nowPath['ext']);
    console.log('파일 이름(확장자 제외) : ', nowPath['name']);
});
