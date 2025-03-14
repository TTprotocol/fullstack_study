class Vehicle {
    constructor(name, wheel) {
        this.name = name;
        this.wheel = wheel;
    }
}

const my = new Vehicle('이름', '바퀴');
console.log(my);

class bicycle extends Vehicle {
    constructor(name, wheel, color) {
        // super 키워드로 부모 클래스 호출 가능
        super(name, wheel);
        // 새로운 생성자 매개변수 추가
        this.color = color;
    }
}

const you = new bicycle('너', '새거', '빨강');
console.log(you);
