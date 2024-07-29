function extract(content) {
    const contentElement = document.getElementById(content)
    const text = contentElement.innerText

    let result = []

    let startIndex = 0
    let endIndex = 0

    for (let i = 0; i < text.length; i++) {
        const currentChar = text[i]

        if (currentChar === '(') {
            startIndex = i
        }

        if (currentChar === ')') {
            endIndex = i
        }

        if (startIndex !== 0 && endIndex !== 0) {
            const word = text.substring(startIndex + 1, endIndex)
            result.push(word)
            startIndex = 0
            endIndex = 0
        }
    }

    return result.join('; ')
}
    
