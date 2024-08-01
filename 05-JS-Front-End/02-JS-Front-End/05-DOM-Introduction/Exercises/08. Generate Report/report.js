function generateReport() {

    class ReportData {
    
    }
    
    const checkBoxes = document.querySelectorAll('table thead tr th input[type=checkbox]')
    const trElements = document.querySelectorAll('table tbody tr')
    const resultElement = document.getElementById('output')

    let result = []
    
    for (let i = 0; i < trElements.length; i++) {
        const data = new ReportData()
        result.push(data)
    }
    
    for (let i = 0; i < checkBoxes.length; i++) {
        const element = checkBoxes[i];
        
        if (element.checked === true) {
            const field = document.querySelector('table thead tr')
            const propertyName = field.children[i].textContent.trim().toLocaleLowerCase()

            for (let j = 0; j < trElements.length; j++) {
                const element = trElements[j].children[i].innerText

                result[j][propertyName] = element
            }
        }
    }

    resultElement.textContent = JSON.stringify(result, null, ' ')
}
