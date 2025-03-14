// 일반함수 버전
const test1 = function (a, b) {
    return a + b;
};

// 화살표 함수 버전
const test2 = (a, b) => {
    return a + b;
};

// 화살표함수 return 생략 버전
// 구현부가 한 줄짜리 간단한 코드일때만 가능

const test3 = (a, b) => a + b;

console.log(test1(3, 4));
console.log(test2(3, 4));
console.log(test3(3, 4));
