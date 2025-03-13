const fs = require('fs');
const path = require('path');

const filePath = path.join(__dirname, './example.txt');

// existSync : 해당 경로에 파일이 있는지 bool 값으로 반환
if (fs.existsSync(filePath)) {
    console.log('파일 있음');
} else {
    // 파일 없음
    console.log('파일 없음');
}
