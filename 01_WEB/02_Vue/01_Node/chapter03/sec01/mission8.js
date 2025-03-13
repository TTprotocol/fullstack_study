const fs = require('fs');
const path = require('path');

const filePath = path.join(__dirname, './logs/diet.txt');

const app = async (name, kcal) => {
    if (!fs.existsSync(filePath)) {
        // 파일 없음
        console.log('식단 기록 파일이 어디로 갔죠?!');
    } else {
        console.log('식단 기록 중... (오늘도 건강한 한 끼!)');

        let record =
            kcal >= 500
                ? name +
                  ': ' +
                  kcal +
                  'kcal, 조금 과했어요! 내일은 가볍게 가볼까요?\n'
                : name + ': ' + kcal + 'kcal, 괜찮아요 아직 여유 있어요!\n';
        let text = name + ' 회원님, 오늘도 건강한 한 끼 감사합니다.';
        await fs.promises.appendFile(filePath, record).then(() => {
            setTimeout(() => {
                console.log(text);
                kcal >= 500
                    ? console.log(
                          name + ' 회원님, 오늘 뭐 드셨어요? 칼로리 폭탄인가요?'
                      )
                    : '';
                console.log('식단 기록이 맛있게 저장되었습니다!');
            }, 2000);
        });
    }
};

app('박준영2', 600);
