import grillMeat from './mission3_grill.js';

const startGrilling = async (menu) => {
    let grill = await grillMeat(menu);
    console.log(grill);
    console.log('🍽️ 식사 시작!');
};

startGrilling('삼겹살');
