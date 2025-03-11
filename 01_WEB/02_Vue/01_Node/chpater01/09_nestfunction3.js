function outer() {
    let outval = 5678;

    function inner() {
        let inval = 1234;
        console.log('outval = ' + outval);
    }

    inner();
    // console.log('inval = ' + inval);
}

outer();
