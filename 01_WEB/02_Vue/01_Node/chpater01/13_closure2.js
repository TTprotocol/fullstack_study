function outer() {
    let value = 1234;
}

outer();

// 함수 내부에 있는 value는 함수가 끝나면 사라진다.
console.log('value : ' + value); // 에러!
