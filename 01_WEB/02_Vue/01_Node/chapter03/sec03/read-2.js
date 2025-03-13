const fs = require('fs');

// 인코딩 옵션으로 utf-8 형식으로 변경
const data = fs.readFileSync(
    './02_Vue/01_Node/chapter03/sec03/example.txt',
    'utf-8'
);
console.log(data);
