const path = require('path');

// 경로 연결하기
const fullPAth = path.join('some', 'work', 'ex.txt');
console.log(fullPAth);

// __filename : 파일명을 포함한 절대경로를 가져온다.
console.log('절대경로 : ' + __filename);

// dirname : 해당 파일이 있는 폴더의 절대경로를 가져온다.
const dir = path.dirname(__filename);
console.log('경로 추출 : ' + dir);

// basename : 경로 제외한 파일명만 가져온다.
const fn = path.basename(__filename);
console.log('파일 이름 : ' + fn);

// 확장자까지 제외 가능
const fn2 = path.basename(__filename, '.js');
console.log('파일 이름 : ' + fn2);

// extname : 파일 확장자만 추출
const ext = path.extname(__filename);
console.log('파일 확장자 : ' + ext);
console.log(path.basename(__filename, ext));

// parse : 경로에 대한 정보를 객체로 변환
const parsePath = path.parse(__filename);
console.log(parsePath);
