// 화살표 함수로 변경
let getTri = (base, height) => {
    (base * height) / 2;
};
let getCircle = (radius) => radius * radius * Math.PI;

// 만약 객체 리턴시에는 ()로 한 번 더 감싸준다.
// 왜냐하면 {}는 함수 본체로 인식되기 때문이다.
let getObject = (x) => ({
    a: 5,
    b: 4,
    c: x,
});

console.log('삼각형의 면적 : ' + getTri(5, 2));
console.log('원의 면적 : ' + getCircle(5));
console.log('객체 : ' + getObject(5));
