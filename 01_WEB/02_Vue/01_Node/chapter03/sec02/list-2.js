const fs = require('fs');

// readdir : 현재 폴더에 있는 파일들 목록 보여주기 (비동기)
let files = fs.readdir('./', (err, data) => {
    // 예외가 발생하면 출력하고 리턴
    if (err) {
        console.log('Err : ', err);
        return;
    }
    console.log('data : ', data);
});
