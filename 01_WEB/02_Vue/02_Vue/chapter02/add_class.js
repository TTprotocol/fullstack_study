// ES6부터 클래스 개념 도입 => 내부는 프로토타입 기반.
class User {
    constructor(first, last) {
        this.firstName = first;
        this.lastName = last;
    }
    getFullName() {
        return `${this.firstName} ${this.lastName}`;
    }
}

const june = new User('park', 'june young');
const june2 = new User('park2', 'june young2');

console.log(june.getFullName());
console.log(june2.getFullName());
