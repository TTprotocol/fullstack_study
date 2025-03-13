const fs = require('fs');
const path = require('path');

const filePath = path.join(__dirname, './logs/workout_log.txt');

// const data = fs.readFile(filePath, 'utf-8', (err, data) => {
//     if (err) {
//         console.log('백업 중 오류가 발생했습니다. Error: ', err);
//     } else {
//         // console.log(data);
//         fs.writeFile(
//             './02_Vue/01_Node/chapter03/sec03/text-1.txt',
//             data,
//             (err) => {
//                 if (err) {
//                     console.log('백업 중 오류가 발생했습니다. Error: ', err);
//                 } else {
//                     console.log('백업이 완료되었습니다.');
//                 }
//             }
//         );
//     }
// });

const rs = fs.createReadStream(
    path.join(__dirname, './logs/workout_log.txt'),
    'utf-8'
);

const ws = fs.createWriteStream(path.join(__dirname, './logs/backup_log.txt'));

rs.pipe(ws)
    .on('finish', () => {
        console.log('백업이 완료되었습니다.');
    })
    .on('error', (err) => {
        console.log('백업 중 오류가 발생했습니다. Error: ', err);
    });
