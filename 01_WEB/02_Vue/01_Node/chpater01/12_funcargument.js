let add = function (a, b) {
    return a + b;
};

let multi = function (a, b) {
    return a * b;
};

// 함수를 매개변수로 받는다. => 함수적 프로그래밍
// 해당하는 함수가 호출된다.
function calc(a, b, f) {
    return f(a, b);
}

console.log('2 + 3 = ' + calc(2, 3, add));
console.log('2 * 3 = ' + calc(2, 3, multi));
