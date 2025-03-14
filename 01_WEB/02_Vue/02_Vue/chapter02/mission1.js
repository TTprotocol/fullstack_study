class Pet {
    constructor(name, species, vaccinations, healthCheckDate, alreadyWarned) {
        this.name = name;
        this.species = species;
        this.vaccinations = vaccinations;
        this.healthCheckDate = healthCheckDate.toISOString().split('T')[0];
        this.alreadyWarned = alreadyWarned;
    }

    addVaccination(vaccin) {
        if (this.vaccinations.includes(vaccin)) {
            console.log(
                `[예방접종 중복] ${this.name}: ${vaccin}은 이미 등록되어 있습니다.`
            );
        } else {
            this.vaccinations.push(vaccin);
            console.log(`[예방접종 추가] ${this.name}: ${vaccin}`);
        }
    }

    updateHealthCheckDate(date) {
        this.alreadyWarned = date;
        console.log(
            `[건강검진 업데이트] ${this.name}: ${
                date.toISOString().split('T')[0]
            }`
        );
        console.log('[검사 종료]');
    }
}

class PetHealthManager {
    registerPet({
        name,
        species,
        vaccinations,
        healthCheckDate,
        alreadyWarned = false,
    }) {
        console.log(
            `[등록] ${species} - ${name} (예방접종: ${vaccinations}, 건강검진: ${healthCheckDate})`
        );
        this.name = name;
        this.species = species;
        this.vaccinations = vaccinations;
        this.healthCheckDate = healthCheckDate;
        this.alreadyWarned = alreadyWarned;
    }
    checkHealthStatus() {
        let now = new Date();
        let diff = (this.healthCheckDate - now) / (1000 * 60 * 60 * 24);
        if (diff > 365) {
            console.log(
                `[건강검진 경고] ${this.name}: 1년 이상 건강검진을 받지 않았습니다!`
            );
        }
    }
}

// 🐾 시스템 사용 예시
const manager = new PetHealthManager();

// 펫 등록
const pet1 = new Pet('나비', '고양이', ['종합백신'], new Date('2023-03-10'));
manager.registerPet(pet1);

// 예방접종 추가
pet1.addVaccination('광견병');
pet1.addVaccination('광견병'); // 중복 테스트

// 건강 상태 검사 시작
manager.checkHealthStatus();

// 5초 후 건강검진 업데이트 (경고 초기화 테스트)
setTimeout(() => {
    pet1.updateHealthCheckDate(new Date());
}, 5000);
