function numberModification(number) {

    let digits = number.toString().split('');
    let isAverageAboveFive = false;

    while (!isAverageAboveFive) {
        let sum = 0;

        for (let digit of digits) {
            let num = Number(digit);
            sum += num;   
        }

        let average = sum / digits.length; 

        if (average >= 5) {
            isAverageAboveFive = true;
        } else {
            digits.push('9');
        }
    }

    let result = '';

    for (let digit of digits) {
        result += digit;    
    }

    console.log(result);
}