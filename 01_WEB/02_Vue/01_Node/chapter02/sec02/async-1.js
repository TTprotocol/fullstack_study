function displayA() {
    console.log('A');
}
function displayB() {
    // 대표적인 비동기 함수.
    // 2초 후에 매개함수 실행.
    setTimeout(() => {
        console.log('B');
    }, 2000);
}
function displayC() {
    console.log('C');
}

displayA();
displayB();
displayC(); // 비동기에 의해 C가 먼저 출력된다.
