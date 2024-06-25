function solve(num1, num2) {
    let totalSum = 0;
    let numbers = '';

    for (let i = num1; i <= num2; i++) {
        numbers += i + ' ';
        totalSum += i;
    }

    console.log(numbers);
    console.log(`Sum: ${totalSum}`);
}