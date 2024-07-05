function charactersInRange(ch1, ch2) {


    const startIndex = Math.min(ch1.charCodeAt(0), ch2.charCodeAt(0));
    const endIndex = Math.max(ch1.charCodeAt(0), ch2.charCodeAt(0));
    let result = '';


    for (let i = startIndex + 1; i < endIndex; i++) {
        let currentChar = String.fromCharCode(i);
        result += currentChar + ' ';
    }

    console.log(result);
}
