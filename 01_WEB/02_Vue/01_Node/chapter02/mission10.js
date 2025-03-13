import discount from './mission10_discount.js';

const app = (price, quantity) => {
    discount(price, quantity);
    console.log(
        `✅ 최종 결제 금액: ${discount(price, quantity).toLocaleString(
            'ko-KO'
        )}원`
    );
};

app(15000, 5);
