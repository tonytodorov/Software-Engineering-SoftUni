function solve(num1, num2, num3) {

    const arr = [num1, num2, num3];
    const regex = /-/;

    const match = arr.filter(num => regex.test(num.toString())); 

    if (match.length % 2 === 0) {
        console.log('Positive');
    } else {
        console.log('Negative');
    }

}
