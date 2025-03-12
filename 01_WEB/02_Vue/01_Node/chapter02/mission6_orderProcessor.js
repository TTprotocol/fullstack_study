let list = {};

const calculateTotal = (orderList) => {
    orderList.map((item) => {
        if (list[item.menu]) {
            list[item.menu] =
                parseInt(list[item.menu], 10) + parseInt(item.quantity, 10);
        } else {
            list[item.menu] = item.quantity;
        }
    });
    return list;
};

const isTopMenu = (menu) => {
    let maxVal = 0;
    for (let [key, value] of Object.entries(list)) {
        maxVal = Math.max(value, maxVal);
    }

    if (list[menu] === maxVal) return true;
    else return false;
};

export { calculateTotal, isTopMenu };
