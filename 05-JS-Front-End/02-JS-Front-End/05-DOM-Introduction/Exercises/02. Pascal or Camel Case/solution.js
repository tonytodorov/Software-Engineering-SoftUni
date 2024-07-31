function solve() {
    debugger
    const text = document.getElementById('text').value.toLowerCase()
    const namingConvention = document.getElementById('naming-convention').value
    const resultField = document.getElementById('result')
    
    let resultText = ''
    concatText(text)
    
    if (namingConvention === 'Camel Case') {
        resultText = resultText.charAt(0).toLowerCase() + resultText.slice(1)
        resultField.innerText = resultText
    } else if (namingConvention === 'Pascal Case') {
        resultField.innerText = resultText
    } else {
        resultField.innerText = 'Error!'
    }
    
    
    function concatText(text) {
        let words = text.split(' ')
        
        for (let i = 0; i < words.length; i++) {
            let element = words[i].charAt(0).toUpperCase() + words[i].slice(1);
            resultText += element
        }
    }
}
