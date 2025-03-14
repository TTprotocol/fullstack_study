let p1 = {
    name: 'ipad',
    price: 20000,
    quantity: 2,
    order: function () {
        // amount가 없을 때만 실행
        if (!this.amount) {
            this.amount = this.quantity * this.price;
        }
        console.log(this.amount);
    },
    // 현재 사용하는 메소드 선언 방식
    discount(rate) {
        if (rate > 0 && rate < 0.8) {
            this.amount = (1 - rate) * this.price * this.quantity;
        }
        console.log(100 * rate);
    },
};

p1.discount(0.2);
p1.order();
