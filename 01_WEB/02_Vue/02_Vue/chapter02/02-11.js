let obj = { result: 0 };
obj.add = function (x, y) {
    this.result = x + y;
};

let add2 = obj.add;

// 두 함수가 같다고 출력됨
console.log(add2 === obj.add);

// 호출하는 곳이 전역이기 때문에 reulst가 전역범위에 생성
// window.result가 7이 된다.
add2(3, 4);
console.log(obj);
console.log(result);
