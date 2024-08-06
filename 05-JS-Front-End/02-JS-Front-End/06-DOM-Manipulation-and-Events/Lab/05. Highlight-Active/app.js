function focused() {
    const inputElement = document.querySelectorAll('input[type=text]')
    const divElements = document.querySelectorAll('div div')
    

    for (let i = 0; i < inputElement.length; i++) {
        const element = inputElement[i];
        
        element.addEventListener('focus', () => {
            divElements[i].setAttribute('class', 'focused')
        })

        element.addEventListener('blur', () => {
            divElements[i].setAttribute('class', '')
        })
    }
}
