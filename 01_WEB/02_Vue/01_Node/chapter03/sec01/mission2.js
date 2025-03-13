const fs = require('fs');
const path = require('path');

const filePath = path.join(__dirname, 'logs/workout_log.txt');

fs.readFile(filePath, 'utf-8', (err, data) => {
    if (err) {
        console.log('운동 기록 파일이 없습니다.');
    } else {
        console.log('운동 기록 출력 완료!');
        console.log(data);
    }
});
