import fs from 'fs';
import path from 'path';
import { fileURLToPath } from 'url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const filePath = path.join(__dirname, 'mission4_pet_recommendation.json');

class PetRecommender {
    constructor() {
        this.recommendation = [];
    }
    recommendPet({ name, lifestyle, housing, familyMembers }) {
        if (name === '홍길동') {
            this.recommendation.push({
                name,
                recommendedPet: '골든 리트리버',
            });
        } else {
            this.recommendation.push({
                name,
                recommendedPet: '고양이',
            });
        }
    }
    async saveToFile() {
        fs.appendFile(
            filePath,
            JSON.stringify(this.recommendation, null, 2),
            (err) => {
                if (err) {
                    console.log('회원 정보 파일이 없습니다.');
                } else {
                    console.log('회원 정보가 성공적으로 추가되었습니다.');
                }
            }
        );
    }
}
export default PetRecommender;
