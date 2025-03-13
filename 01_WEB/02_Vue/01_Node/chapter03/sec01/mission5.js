const fs = require('fs');
const path = require('path');

const filePath = path.join(__dirname, './logs/workout_log.txt');

const runStretching = async () => {
    const str = new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(console.log('스트레칭 완료'));
        }, 1000);
    });
    return str;
};

const runTreadmill = async () => {
    const tre = new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(console.log('러닝머신 완료'));
        }, 500);
    });
    return tre;
};

const runProtein = async (callabck) => {
    const pro = new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(console.log('단백질 보충 완료'));
            callabck();
        }, 0);
    });
    return pro;
};

const app = async () => {
    console.log('운동 기록 처리 시작');
    await runStretching();
    await runTreadmill();
    await runProtein(() => console.log('운동 기록 처리 종료'));
};

app();
