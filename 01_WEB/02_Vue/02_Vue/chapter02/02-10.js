let obj = { result: 0 };
obj.add = function (x, y) {
    this.result = x + y;
};

// 일반함수의 this는 호출될 때 결정된다.
// 객체에서 호출햇으므로 this는 객체 본인을 가리킨다.
obj.add(3, 4);
console.log(obj);
