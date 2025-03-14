// const june = {
//     firstName: 'park',
//     lastName: 'juneyoung',
//     getFullName: function () {
//         return `${this.firstName} ${this.lastName}`;
//     },
// };

// // 일반함수에서 this는 호출한 객체
// console.log(june.getFullName());

// ------------------------------------------------

// 생성자 함수
function User(first, last) {
    this.firstName = first;
    this.lastName = last;
}

// 프로토타입에 추가된 함수는 객체 전체가 공유한다.
User.prototype.getFullName = function () {
    return `${this.firstName} ${this.lastName}`;
};

const june = new User('park', 'june young');
const june2 = new User('park2', 'june young2');

console.log(june.getFullName());
console.log(june2.getFullName());
