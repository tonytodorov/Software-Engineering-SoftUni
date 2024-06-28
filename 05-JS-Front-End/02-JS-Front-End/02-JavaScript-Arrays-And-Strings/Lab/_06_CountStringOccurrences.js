function solve(text, word) {
    let splitText = text.split(' ');
    let count = 0;

    for (let currentWord of splitText) {
        if (currentWord === word) {
            count++;
        }
    }

    console.log(count);
}
