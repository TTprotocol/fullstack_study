class Item {
    constructor(name, type, stock, alreadyWarned = false) {
        this.name = name;
        this.type = type;
        this.stock = stock;
        this.alreadyWarned = alreadyWarned;
    }
}

class InventoryManager {
    addItem({ name, type, stock, alreadyWarned = false }) {
        this.name = name;
        this.type = type;
        this.stock = stock;
        this.alreadyWarned = alreadyWarned;

        console.log(`[추가] ${type} - ${name} (재고: ${stock}개)`);
    }

    updateStock(name, stock) {
        if (stock < 0) {
            this.alreadyWarned = true;
            console.log(`[업데이트 오류] 재고는 0 이상이어야 합니다.`);
        } else if (stock < 5) {
            this.stock = stock;
            this.alreadyWarned = true;
            console.log(`[업데이트] ${name}: ${stock}개`);
        } else {
            this.stock = stock;
            this.alreadyWarned = false;
        }
    }

    checkStock() {
        setTimeout(() => {
            if (this.stock < 5) {
                this.alreadyWarned = true;
                console.log(`[자동 경고] ${this.name}: ${this.stock}개`);
            } else {
                this.alreadyWarned = false;
            }
        }, 1000);
        setTimeout(() => {
            console.log('[재고 검사 종료]');
        }, 5000);
    }
}

// 🐾 시스템 사용 예시
const inventory = new InventoryManager();

// 아이템 등록
const item1 = new Item('고급 고양이 사료', '사료', 10);
inventory.addItem(item1);

// 재고 업데이트
inventory.updateStock('고급 고양이 사료', 4); // 5개 미만 → 경고 발생
inventory.updateStock('고급 고양이 사료', -1); // 음수 입력 → 오류 발생

// 재고 상태 검사 시작 (5초 후 종료)
inventory.checkStock();
