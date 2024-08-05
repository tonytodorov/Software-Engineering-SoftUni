function encodeAndDecodeMessages() {
    const resultElement = document.querySelector('main div:last-child textarea')
    const encodeAndSendButton = document.querySelector('main div:first-child button')
    const decodeAndReadButton = document.querySelector('main div:last-child button')
    
    let resultText = ''

    encodeAndSendButton.addEventListener('click', () => {
        const inputElement = document.querySelector('main div:first-child textarea')
        const text = inputElement.value

        resultElement.disabled = false;
        resultElement.value = ''
        resultElement.disabled = true;
        
        for (let i = 0; i < text.length; i++) {
            const char = text.charCodeAt(i) + 1;
            resultText += String.fromCharCode(char)
            
        }   
        
        resultElement.value = resultText
        inputElement.value = ''
        resultText = ''
    })


    decodeAndReadButton.addEventListener('click', () => {
        resultElement.disabled = false;
        const text = resultElement.value
        resultElement.disabled = true;

        let decodeText = ''

        for (let i = 0; i < text.length; i++) {
            const char = text.charCodeAt(i) - 1;
            decodeText += String.fromCharCode(char)
        }   

        resultElement.value = decodeText
    })
}
