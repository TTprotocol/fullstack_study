const fs = require('fs');
const path = require('path');

const filePath = path.join(__dirname, 'logs/members.txt');
const fileContent = '\n이승기: 체중 68kg, 벤치프레스 80kg';

if (fs.existsSync(filePath)) {
    fs.appendFile(filePath, fileContent, (err) => {
        if (err) {
            console.log('회원 정보 파일이 없습니다.');
        } else {
            console.log('회원 정보가 성공적으로 추가되었습니다.');
        }
    });
} else {
    // 파일 없음
    console.log('회원 정보 파일이 없습니다.');
}
