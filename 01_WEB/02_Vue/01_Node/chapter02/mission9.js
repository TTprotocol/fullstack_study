import orders from './mission9_menu.js';
import filterMenuByPrice from './mission9_menuFilter.js';

const showAffordableMenu = async () => {
    let result = await filterMenuByPrice(orders, '18,000원');
    console.log('✅ 선택 가능한 메뉴: ');
    result.map((item) => console.log(item.menu + ': ' + item.price));
};
showAffordableMenu();
