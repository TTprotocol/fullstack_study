// 구조분해할당. 객체를 쪼개서 받는다.
const { user1, user2 } = require('./user-1.js');

const hello = require('./hello');

hello(user1);
hello(user2);
