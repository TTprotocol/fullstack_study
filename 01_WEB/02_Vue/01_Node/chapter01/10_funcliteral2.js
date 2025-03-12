console.log('2 + 3 = ' + add(2, 3));
console.log('2 + 3 = ' + add2(4, 5)); // 에러

// 함수선언식만 호이스팅됨
function add(a, b) {
    return a + b;
}

// 함수 표현식(익명함수)는 호이스팅 되지 않음
let add2 = function (a, b) {
    return a + b;
};
