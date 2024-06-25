function solve(number) {
    let sum = 0;

    while (number > 0) {
        let remainder = number % 10;
        sum += remainder;
        number /= 10;
        number = Math.floor(number);
    }

    console.log(sum);    
}
