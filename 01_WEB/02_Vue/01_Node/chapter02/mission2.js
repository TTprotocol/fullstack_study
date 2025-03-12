import orderManager from './mission2_orderManager.js';

function app() {
    if (orderManager.menu.length === 0) console.log('❌ 주문 내역이 없습니다.');
    else {
        console.log('✅ 현재 주문 내역 : ');
        orderManager.menu.map((item) => {
            console.log(item.name + ': ' + item.many);
        });
    }
}

// orderManager.addOrder('삼겹살', '3인분');
// orderManager.addOrder('목살', '2인분');
// orderManager.addOrder('갈비', '4인분');
// orderManager.addOrder('갈매기살', '1인분');

app();
