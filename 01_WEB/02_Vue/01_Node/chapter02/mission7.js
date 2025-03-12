import processOrder from './mission7_orderProcessor.js';

const orders = [
    {
        menu: '삼겹살',
        quantity: '2인분',
    },
    {
        menu: '목살',
        quantity: '3인분',
    },
    {
        menu: '삼겹살',
        quantity: '3인분',
    },
    {
        menu: '갈비',
        quantity: '1인분',
    },
    {
        menu: '갈비',
        quantity: '2인분',
    },
    {
        menu: '목살',
        quantity: '2인분',
    },
    {
        menu: '삼겹살',
        quantity: '3인분',
    },
    {
        menu: '목살',
        quantity: '1인분',
    },
];

const app = async () => {
    for (let order of orders) {
        let result = await processOrder(order);
        console.log(result);
    }
};

app();
