// 기본 매개변수는 무조건 뒤에서부터 사용
function addContack(
    name,
    mobile,
    home = '없음',
    address = '없음',
    email = '없음'
) {
    let str =
        'name = ' +
        name +
        ', mobile = ' +
        mobile +
        ', home = ' +
        home +
        ', address = ' +
        address +
        ', email = ' +
        email;

    console.log(str);
}

// 값을 설정하지 않은 변수는 기본값으로 출력
addContack('홍길동', '010-2335-4641');
addContack('홍길동2', '010-2335-4641 2', '01-123-456', '부산시');
