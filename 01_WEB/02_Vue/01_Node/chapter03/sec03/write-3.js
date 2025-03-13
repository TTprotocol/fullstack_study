const fs = require('fs');
const path = require('path');

const filePath = path.join(__dirname, './example.txt');
const filePath2 = path.join(__dirname, './text-2.txt');

fs.readFile(filePath, 'utf-8', (err, data) => {
    if (err) {
        console.log('err: ', err);
    }
    fs.writeFile(filePath2, data, (err, data) => {
        if (err) {
            console.log('err: ', err);
        }
        console.log('success');
    });
});
