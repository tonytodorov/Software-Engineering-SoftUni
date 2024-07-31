function solve() {
    const text = document.getElementById('input').value
    const outputField = document.getElementById('output')
    
    const sentences = text.split('.')
    let countSentences = 0
    
    let paragraphSentence = ''
    
    for (let i = 0; i < sentences.length; i++) {
        const element = sentences[i];
        
        if (element.length > 0) {
            if (countSentences < 3) {
                countSentences++
                paragraphSentence += element + '.'
                
                if (countSentences === 3) {
                    var createParagraph = document.createElement('p')
                    createParagraph.append(paragraphSentence)
                    outputField.append(createParagraph)
                    countSentences = 0
                    paragraphSentence = ''
                }
            }
        }
    }
    
    if (countSentences !== 0) {
        var createParagraph = document.createElement('p')
        createParagraph.append(paragraphSentence)
        outputField.append(createParagraph)
        countSentences = 0
        paragraphSentence = ''
    }
}
