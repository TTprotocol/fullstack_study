const processOrder = (order) => {
    const result = new Promise((resolve, reject) => {
        setTimeout(() => {
            if (parseInt(order.quantity, 10) >= 3) {
                resolve(`✅ ${order.menu}  ${order.quantity} 주문 완료!`);
            } else {
                resolve(
                    `❌ ${order.menu}  ${order.quantity}은 주문 최소 수량 미달입니다.`
                );
            }
        }, 3000);
    });

    return result;
};

export default processOrder;
