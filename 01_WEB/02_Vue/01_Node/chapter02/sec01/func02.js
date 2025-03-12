// 기명함수를 익명함수로 변경.
// 함수를 변수에 할당한다.
let getTri = function (base, height) {
    return (base * height) / 2;
};

console.log('삼각형의 면적 : ' + getTri(5, 2));
