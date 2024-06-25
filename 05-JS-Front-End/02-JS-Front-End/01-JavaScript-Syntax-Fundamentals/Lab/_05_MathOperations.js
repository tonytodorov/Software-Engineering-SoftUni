function solve(num1, num2, sign) {
    if (sign === '+') {
        console.log(num1 + num2);
    } else if (sign === '-') {
        console.log(num1 - num2);
    } else if (sign === '*') {
        console.log(num1 * num2);
    } else if (sign === '/') {
        console.log(num1 / num2);
    } else if (sign === '%') {
        console.log(num1 % num2);
    } else {
        console.log(num1 ** num2);
    }
}