import orderList from './mission6_orderList.js';
import {
    calculateTotal as calc,
    isTopMenu as isTop,
} from './mission6_orderProcessor.js';

const app = async () => {
    let list = calc(orderList);
    console.log(`✅ 총 주문 수량: ${JSON.stringify(list)}`);
    console.log(
        `🥩 삼겹살이 가장 인기 메뉴인가요? ${
            isTop('삼겹살') ? '네!' : '아니오!'
        }`
    );
    console.log(
        `🥩 목살이 가장 인기 메뉴인가요? ${isTop('목살') ? '네!' : '아니오!'}`
    );
};

app();
