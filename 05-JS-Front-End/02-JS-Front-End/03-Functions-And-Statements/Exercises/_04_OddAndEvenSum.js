function oddEvenSum(number) {

    let oddSum = 0;
    let evenSum = 0;

    while (number > 0) {
        let remainder = Math.floor(number % 10);

        if (remainder % 2 == 0) {
            evenSum += remainder;
        } else {
            oddSum += remainder
        }

        number /= 10;
    }

    console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);
}
