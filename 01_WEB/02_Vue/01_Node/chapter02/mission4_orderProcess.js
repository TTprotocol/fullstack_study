const menu = [];

const orderProcess = (orderList) => {
    const order = new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(
                `✅ ${orderList.name} ${orderList.quantity} 주문 처리 완료!`
            );
        }, 1000);
    });

    return order.then((result) => console.log(result));
};

export default orderProcess;
