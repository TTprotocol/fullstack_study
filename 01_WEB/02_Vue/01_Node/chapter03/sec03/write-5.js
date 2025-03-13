const fs = require('fs');
const path = require('path');

const filePath = path.join(__dirname, './example.txt');
const filePath2 = path.join(__dirname, './text-2.txt');

// appendFile : 비동기로 기존 파일 내용에 새로운 내용을 추가
// flag 옵션을 a로 준 것과 동일하게 동작한다.
fs.appendFile(filePath2, '\n\n새로운 내용 추가', (err) => {
    if (err) {
        console.log('err: ', err);
    }
    console.log('success');
});
