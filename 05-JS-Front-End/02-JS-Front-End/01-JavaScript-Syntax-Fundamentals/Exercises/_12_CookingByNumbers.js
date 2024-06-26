function solve(number, op1, op2, op3, op4, op5) {
    let num = Number(number);

    const operation = [op1, op2, op3, op4, op5];

    for (let i = 0; i < operation.length; i++) {                
        if (operation[i] === 'chop') {
            num /= 2;
        } else if (operation[i] === 'dice') {
            num = Math.sqrt(num);
        } else if (operation[i] === 'spice') {
            num += 1;
        } else if (operation[i] === 'bake') {
            num *= 3;
        } else {
            num *= 0.8;
        }

        console.log(num.toFixed(1));
    }
}
