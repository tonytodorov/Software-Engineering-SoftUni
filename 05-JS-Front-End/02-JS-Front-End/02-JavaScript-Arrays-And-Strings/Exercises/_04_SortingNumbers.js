function solve(numbers) {
    numbers.sort((a, b) => {
        return a - b;
    });

    let middleIndex = Math.floor(numbers.length / 2);
    let firstArr = [];
    let index = 0;

    for (let i = 0; i < middleIndex; i++) {
        firstArr[index] = numbers[i];
        index++;
    }

    let secondArr = [];
    index = 0;

    for (let i = middleIndex; i < numbers.length; i++) {
        secondArr[index] = numbers[i];
        index++;
    }

    secondArr.reverse();

    let length = Math.min(firstArr.length, secondArr.length);

    let result = [];
    let startIndex = 0;

    for (let i = 0; i < length; i++) {
        result[i + i] = firstArr[0];
        result[i + i + 1] = secondArr[0];

        firstArr.shift();
        secondArr.shift();

        if (firstArr.length === 0 || secondArr.length === 0) {
            startIndex = result.length;
            break;
        }
    }

    for (let i = 0; i < firstArr.length; i++) {
        result[startIndex] = firstArr[i];   
        startIndex++;     
    }

    for (let i = 0; i < secondArr.length; i++) {
        result[startIndex] = secondArr[i];        
        startIndex++;     
    }

    return result;
}
