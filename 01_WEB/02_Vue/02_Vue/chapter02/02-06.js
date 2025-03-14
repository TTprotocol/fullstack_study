// 가변 파라미터는 맨 뒤에만 1개 지정 가능.
function addContack(name, mobile, ...favorite) {
    let str = 'name = ' + name + ', mobile = ' + mobile;

    console.log(str);
    console.log(favorite);
}

// 지정된 매개변수 이외의 값들을 배열로 넘겨준다.
addContack('홍길동', '010-2335-4641');
addContack('홍길동2', '010-2335-4641 2', '01-123-456', '부산시');
