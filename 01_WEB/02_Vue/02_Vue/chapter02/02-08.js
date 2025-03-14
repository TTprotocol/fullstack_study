function addContact1({ name, phone, email = '이메일없음', age = 0 }) {
    console.log(name, phone, email, age);
}

addContact1({ name: 'june', phone: '010-2335-4641' });

// 객체를 통째로 받아서 함수 내에서 구조분해
function addContact2(contact) {
    // 속성이 없다면 초기화 해주는 모드
    if (!contact.email) contact.email = '이메일없음';
    if (!contact.age) contact.age = 0;
    let { name, phone, email, age } = contact;
    console.log(name, phone, email, age);
}

addContact2({ name: '이몽룡 ', phone: '010-3434-8989' });

// 구조분해할당 없이 기본 매개변수 사용해서 넘겨줌
function addContact3(name, phone, email = '이메일없음', age = 0) {
    console.log(name, phone, email, age);
}

addContact3('이몽룡 ', '010-3434-8989');
