class ConsultationManager {
    constructor() {
        this.customer = [];
    }

    registerConsultation({ name, tel, type }) {
        let regex = /^010-\d{4}-\d{4}$/;
        if (!regex.test(tel)) {
            console.log(
                `[상담 등록 오류] ${name}: 잘못된 전화번호 형식입니다.`
            );
        } else {
            if (this.customer.includes(name)) {
                console.log(
                    `[상담 중복 오류] ${name}: 이미 등록된 상담 기록입니다.`
                );
            } else {
                this.customer.push(name);
                console.log(`[상담 등록] ${name} - 선호 펫: ${type}`);
            }
        }
    }

    autoEndConsultation() {
        this.customer.forEach((item) => {
            console.log(`[저장 완료] ${item} 상담 기록 저장 완료!`);
        });
        setTimeout(() => {
            console.log('[상담 기록 저장 종료]');
        }, 5000);
    }
}

export default ConsultationManager;
