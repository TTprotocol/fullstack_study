import orderProcess from './mission4_orderProcess.js';

const app = async (orderList) => {
    await orderProcess(orderList[0]);
    await orderProcess(orderList[1]);
    await orderProcess(orderList[2]);
    console.log('🍽️ 모든 주문 처리 완료! 식사 시작!');
};

const orderList = [
    {
        name: '삼겹살',
        quantity: '3인분',
    },
    {
        name: '목살',
        quantity: '2인분',
    },
    {
        name: '갈비',
        quantity: '4인분',
    },
];

app(orderList);
