let msg = 'GLOBAL';

function outer() {
    let msg = 'OUTER';
    // 호출시 같은 블럭 안에 있는 변수를 가져온다.
    console.log(msg);
    if (true) {
        let msg = 'BLOCK';
        console.log(msg);
    }
}
outer();
