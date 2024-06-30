function solve(words, text) {
    let searchedWords = words.split(', ');

    for (let i = 0; i < searchedWords.length; i++) {
        let word = searchedWords[i];
        let template = '*'.repeat(word.length);

        text = text.replace(template, word);
    }

    console.log(text); 
}
