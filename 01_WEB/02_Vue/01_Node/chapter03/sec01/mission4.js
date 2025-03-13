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
        // rs에서 오류가 났기 때문에 ws까지 이벤트가 흐르지 않았다!
        // 따라서 백업 할 때의 경로(ws)에서 에러가 나면 아래 로그가 찍힌다.
        console.log('백업 중 오류가 발생했습니다. Error: ', err);
    });

// end : Readable Stream에서 데이터가 더 이상 없을 때 발생 = 읽기 스트림이 종료됨을 의미
// finish : Writable Stream에서 모든 데이터가 정상적으로 기록되었을 때 발생

// rs.on('end', () => {
//     console.log('📌 읽기 스트림 종료 (end 이벤트 발생)');
// });

// ws.on('finish', () => {
//     console.log('📌 쓰기 스트림 종료 (finish 이벤트 발생)');
// });
