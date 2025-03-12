import updateStatus from './mission5_status.js';

const app = async (orderList) => {
    // await orderList.map((item) => {
    //     updateStatus.updateStatus(item.name, item.status);
    // });
    await updateStatus.updateStatus(orderList[0].name, orderList[0].status);
    await updateStatus.updateStatus(orderList[1].name, orderList[1].status);
    await updateStatus.updateStatus(orderList[2].name, orderList[2].status);
    await updateStatus.updateStatus(orderList[3].name, orderList[3].status);
    console.log(
        `최종 주문 상태: {samgyeopsal: ${updateStatus.orderStatus.samgyeopsal},  galbi: ${updateStatus.orderStatus.galbi}}S`
    );
};

const orderList = [
    {
        name: 'samgyeopsal',
        status: '굽는 중',
    },
    {
        name: 'samgyeopsal',
        status: '완료',
    },
    {
        name: 'galbi',
        status: '굽는 중',
    },
    {
        name: 'galbi',
        status: '완료',
    },
];

app(orderList);
