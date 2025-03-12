const orderStatus = {
    samgyeopsal: '주문 대기',
    galbi: '주문 대기',
};

const updateStatus = (menu, status) => {
    const order = new Promise((resolve, reject) => {
        setTimeout(() => {
            orderStatus[menu] = status;
            resolve(`✅ ${menu} 상태가 ${status}로 변경되었습니다.`);
        }, 1000);
    });

    return order.then((result) => console.log(result));
};

export default { orderStatus, updateStatus };
