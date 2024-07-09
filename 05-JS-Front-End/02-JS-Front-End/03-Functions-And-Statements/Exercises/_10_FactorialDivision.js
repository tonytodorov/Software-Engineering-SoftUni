function factorialDivision(num1, num2) {
    
    let firstFactorial = factorial(num1);
    let secondFactorial = factorial(num2);

    let result = (firstFactorial / secondFactorial).toFixed(2);

    console.log(result);

    function factorial(n) {
        if (n < 2) {
            return 1;
        }

        return n * factorial(n - 1);
    }

}
