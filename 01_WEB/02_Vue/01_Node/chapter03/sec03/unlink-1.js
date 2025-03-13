const fs = require('fs');
const path = require('path');

const filePath = path.join(__dirname, './example.txt');
const filePath2 = path.join(__dirname, './text-2.txt');

// unlinkSync : 해당 경로의 파일을 동기적으로 삭제
fs.unlinkSync(filePath2);
console.lof('end');
