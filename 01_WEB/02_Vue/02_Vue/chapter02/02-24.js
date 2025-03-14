let obj = { name: '홍길동', age: 20 };
const proxy = new Proxy(obj, {
    // 값을 가지고 올 때 처리
    get: function (target, key) {
        console.log('## get ' + key);
        // 해당 키에 존재하는 데이터가 없으면 에러 발생.
        if (!target[key]) throw new Error(`존재하지 않는 속성(${key})입니다.`);
        return target[key];
    },

    // 값을 설정할 때 처리
    set: function name(target, key, value) {
        console.log('## set ' + key);
        if (!target[key]) throw new Error(`존재하지 않는 속성(${key})입니다.`);
        target[key] = value;
        return true;
    },
});

console.log(proxy.name);
proxy.name = '박준영';
proxy.age = 30;

console.log(proxy);
