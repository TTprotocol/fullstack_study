const filterMenuByPrice = (menu, max) => {
    const result = new Promise((resolve, reject) => {
        setTimeout(() => {
            let filter = menu.filter(
                (item) =>
                    parseInt(item.price.replace(/[^0-9]/g, ''), 10) <=
                    parseInt(max.replace(/[^0-9]/g, ''), 10)
            );
            resolve(filter);
        }, 3000);
    });

    return result;
};

export default filterMenuByPrice;
