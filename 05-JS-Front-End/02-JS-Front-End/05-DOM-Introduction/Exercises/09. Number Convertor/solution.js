function solve() {
    const button = document.querySelector('button')
    const resultElement = document.querySelector('#result')
    
    let toMenu = document.querySelector('#selectMenuTo')
    let input = document.querySelector('#input')
    
    const optionsMenu = {
        'Binary': 'binary',
        'Hexadecimal': 'hexadecimal',
    }
    
    for (const key in optionsMenu) {
        let createOption = document.createElement('option')
        createOption.value = optionsMenu[key]
        createOption.textContent = key
        toMenu.appendChild(createOption)
    }
    
    function convert() {
        debugger
        const [number, optionResult] = [Number(input.value), toMenu.value]

        if (optionResult === 'binary') {
            resultElement.value = number.toString(2)
        } else if (optionResult === 'hexadecimal') {
            resultElement.value = number.toString(16).toUpperCase() 
        }
        
    }
    
    button.addEventListener('click', convert)
}
