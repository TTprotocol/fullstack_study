let arr = [10, 20, 30, 40];
// 4개 중 3개만 구조분해할당 가능
let [a1, a2, a3] = arr;
console.log(a1, a2, a3);

let p1 = { name: '홍길동', age: '20', gender: 'M' };
// : 뒤에 원하는 이름으로 변경 가능
let { name: n, age: a, gender: g } = p1;
// 객체의 key와 동일한 이름의 값을 가져온다.
console.log(n, a, g);
