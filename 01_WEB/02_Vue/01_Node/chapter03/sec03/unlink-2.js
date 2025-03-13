const fs = require('fs');
const path = require('path');

const filePath = path.join(__dirname, './example.txt');
const filePath2 = path.join(__dirname, './text-2.txt');

// 해당 경로에 파일이 있는지 체크
if (fs.existsSync(filePath)) {
    // unlinkSync : 해당 경로의 파일을 동기적으로 삭제
    fs.unlinkSync(filePath2);
    console.lof('end');
} else {
    // 파일 없음
    console.log('파일 없음');
}
