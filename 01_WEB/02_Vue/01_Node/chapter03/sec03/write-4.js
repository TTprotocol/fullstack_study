const fs = require('fs');
const path = require('path');

const filePath = path.join(__dirname, './example.txt');
const filePath2 = path.join(__dirname, './text-1.txt');

let content = `
===========================
새로운 내용을 추가해 보겠습니다.
===========================
`;

// flag를 a로 변경해주면 기존 파일에 내용이 추가된다. (append)
fs.writeFileSync(filePath2, content, { flag: 'a' });
