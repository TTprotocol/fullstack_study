// 동기처리 => 무조건 코드 순서대로 처리된다.
function displayA() {
    console.log('A');
}
function displayB() {
    console.log('B');
}
function displayC() {
    console.log('C');
}

displayA();
displayB();
displayC();
