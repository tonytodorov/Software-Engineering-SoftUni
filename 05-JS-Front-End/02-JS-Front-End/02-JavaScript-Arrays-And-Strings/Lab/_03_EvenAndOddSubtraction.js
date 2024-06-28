function solve(arr) {
    let oddSum = 0;
    let evenSum = 0;

    for (let i = 0; i < arr.length; i++) {
        if (arr[i] % 2 !== 0) {
            oddSum += arr[i];
        } else {
            evenSum += arr[i];
        }
    }

    console.log(evenSum - oddSum);   
}
