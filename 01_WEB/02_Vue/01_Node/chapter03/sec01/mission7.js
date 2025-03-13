const fs = require('fs');
const path = require('path');

const filePath = path.join(__dirname, './logs/reservations.txt');

const app = async (name, reserve) => {
    if (!fs.existsSync(filePath)) {
        // 파일 없음
        console.log('예약 기록 파일이 없습니다!');
    } else {
        let data = await fs.promises.readFile(filePath, 'utf-8');

        // console.log(data);
        // console.log(data.includes(name));
        console.log('예약 처리 중...');
        if (data.includes(name)) {
            setTimeout(() => {
                console.log(name + ' 회원님은 이미 예약되어 있습니다!');
            }, 2000);
        } else {
            let text = name + ':' + reserve;
            await fs.promises.appendFile(filePath, text).then(() => {
                setTimeout(() => {
                    console.log(
                        name +
                            ' 회원님의 ' +
                            reserve +
                            ' 예약이 완료되었습니다!'
                    );
                    console.log('예약 기록이 파일에 저장되었습니다.');
                }, 2000);
            });
        }
    }
};

app('박준영2', '머신러닝');
