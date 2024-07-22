function wordTracker(words) {
    
    const searchedWords = words.shift().split(' ')

    let result = {}


    for (const word of searchedWords) {
        result[word] = 0
    }

    for (const word of searchedWords) {
        for (const currentWord of words) {
            if (currentWord === word) {
                result[word] += 1
            }
        }
    }

    let resultArr = Object.entries(result)

    resultArr.sort((a, b) => b[1] - a[1])
        .forEach(word => console.log(`${word[0]} - ${word[1]}`))
}
