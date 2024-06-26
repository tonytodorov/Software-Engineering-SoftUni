function solve(number) {
    let isDigitsSame = true;
    let lastDigit = number % 10;
    let sum = 0;

    while (number > 0) {
        let remainder = number % 10;
        sum += remainder;
        number = Math.floor(number / 10);

        if (lastDigit != remainder) {
            isDigitsSame = false;
        }
    }

    console.log(isDigitsSame);
    console.log(sum);
}
