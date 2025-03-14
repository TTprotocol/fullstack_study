// 원하는 대로 this 지정하기

let add = function (x, y) {
    this.result = x + y;
};

let obj = {};
// 1. apply() : 함수를 직시 실행하면서 this와 인자를 배열 형태로 전달
// add.apply(obj, [3, 4]);
// 2. call() : 함수를 즉시 실행하면서 this와 인자(가변 매개변수)를 전달
// add.call(obj, 3, 4);
// 3. bind() : 영구적으로 this를 바인딩한 새 함수를 반환. 나중에 실행 가능.
add = add.bind(obj);

add(3, 4);
console.log(obj);
