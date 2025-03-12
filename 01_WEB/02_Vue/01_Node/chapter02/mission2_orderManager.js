const menu = [];

function addOrder(name, quantity) {
    menu.push({
        name: name,
        many: quantity,
    });
}

export default { menu, addOrder };
