let obj = { result: 0 };

obj.add = function (x, y) {
    function inner() {
        this.result = x + y; // inner의 this.
    }
    // 일반함수기 때문에 호출시 this가 결정됨.
    // this => window
    inner();
};

obj.add(3, 4);

console.log(obj);
console.log(result);
