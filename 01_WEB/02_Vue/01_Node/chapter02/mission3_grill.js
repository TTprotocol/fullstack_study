let grillMeat = (menu) => {
    const grill = new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(`🔥 ${menu} 이(가) 다 구워졌습니다`);
        }, 2000);
    });

    return grill;
};

export default grillMeat;
