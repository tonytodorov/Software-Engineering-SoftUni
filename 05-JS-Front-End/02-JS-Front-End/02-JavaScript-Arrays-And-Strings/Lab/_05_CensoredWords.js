function solve(text, word) {
    let result = text.replaceAll(word, '*'.repeat(word.length));
    console.log(result);
}
