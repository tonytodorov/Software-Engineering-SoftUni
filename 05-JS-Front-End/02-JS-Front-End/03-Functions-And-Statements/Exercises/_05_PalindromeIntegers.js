function palindromeNumbers(numbers) {
    
    for (let i = 0; i < numbers.length; i++) {
        let element = numbers[i];
        
        let reversedNumber = '';

        while (element > 1) {
            let num = Math.floor(element % 10);
            reversedNumber += num;
            element /= 10;
        }

        if (reversedNumber == numbers[i]) {
            console.log('true');
        } else {
            console.log('false');
        }
    }
}
