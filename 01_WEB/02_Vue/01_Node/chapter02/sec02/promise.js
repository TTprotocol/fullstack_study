let likePizza = true;

const pizza = new Promise((resolve, reject) => {
    if (likePizza) {
        // resolve : 성공시 호출하는 메소드
        resolve(`${menu}가 다 구워졌습니다`);
    } else {
        // reject : 실패시 호출하는 메도스
        reject('피자를 주문하지 않습니다.');
    }
});

// then으로 resolve 매개변수 받아오기
// catch로 reject 매개변수 받아오기
pizza.then((result) => console.log(result)).catch((err) => console.log(err));
