const teacher = {
    name: 'june',
    age: 28,
    email: ['june'],
};

// const copyTeacher = teacher;     // => 주소값이 복사돼서 같은 주소값을 가짐.

// 해결방법1. Object.assign을 이용해서 target 객체에 출처 객체를 복사
// const copyTeacher = Object.assign({}, teacher);

// 해결방법2. 전개연산자 이용해서 객체 생성
// => 참조형 데이터를 가지고 있을 때 한계 발생.
// const copyTeacher = { ...teacher };
console.log(teacher === copyTeacher);

teacher.age = 19;
console.log(teacher);
console.log(copyTeacher);

// 전개연산자를 이용해도 참조형 데이터까지 값을 복사해 주지 않는다 -> 한계 발생.
teacher.email.push('young');
console.log(teacher.email === copyTeacher.email);
console.log(teacher);
console.log(copyTeacher);
