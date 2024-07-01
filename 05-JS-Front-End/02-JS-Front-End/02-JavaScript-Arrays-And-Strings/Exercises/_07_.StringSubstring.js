function solve(word, text) {
    const words = text.toLowerCase().split(' ');
    const isIncuded = words.includes(word.toLowerCase());

    if (isIncuded) {
        return word;
    }

    return `${word} not found!`;
}