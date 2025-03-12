// await를 사용하는 함수에는 async를 붙인다.
async function init() {
    try {
        // promise 객체를 반환하는 함수에는 await를 붙인다.
        const response = await fetch(
            'https://jsonplaceholder.typicode.com/users'
        );
        let user = await response.json();
        console.log(user);
    } catch (err) {
        console.log(err);
    }
}
init();
