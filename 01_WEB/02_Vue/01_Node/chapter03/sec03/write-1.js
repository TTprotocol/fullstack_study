const fs = require('fs');

const data = fs.readFileSync(
    './02_Vue/01_Node/chapter03/sec03/example.txt',
    'utf-8'
);
fs.writeFileSync('./02_Vue/01_Node/chapter03/sec03/text-1.txt', data);
