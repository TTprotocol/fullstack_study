let obj = { result: 0 };

obj.add = function (x, y) {
    function inner() {
        this.result = x + y; // inner의 this.
    }
    // bind()를 통해서 this의 값을 지정한다.
    // add의 this를 inner에 있는 this에 지정
    inner = inner.bind(this);
    inner();
};

obj.add(3, 4);
console.log(obj);
