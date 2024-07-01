function solve(text) {
    const words = text.toUpperCase().match(/\b(?:[A-Za-z]+|[IE])\b/g);
    console.log(words.join(', '));
}
