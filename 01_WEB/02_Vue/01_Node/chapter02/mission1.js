import order from './mission1_order.js';

function app() {
    let check = order.filter((item) => item.name === '삼겹살')[0];
    if (check) {
        console.log('✅ 삼겹살 주문 수량 : ' + check.many);
    } else {
        console.log('❌ 삼겹살 주문 내역이 없습니다.');
    }
}

app();
