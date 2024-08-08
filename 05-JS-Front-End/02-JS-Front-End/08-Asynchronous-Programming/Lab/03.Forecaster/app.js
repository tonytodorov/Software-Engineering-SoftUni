function attachEvents() {
    const inputElement = document.getElementById('location')
    const submitElement = document.getElementById('submit')
    const resultElement = document.getElementById('forecast')
    const divCurrentElement = document.getElementById('current')
    const baseURL = `http://localhost:3030/jsonstore/forecaster/`

    let code
    let name

    resultElement.style.display = 'block'

    submitElement.addEventListener('click', () => {
        fetch(`${baseURL}locations`)
        .then(response => response.json())
        .then(result => {
            const data = Object.entries(result)

            const town = data.find(city => city[1].name === inputElement.value)
            code = town[1].code
            name = town[1].name

            fetchCurrentConditions()
        })
    })


    function fetchCurrentConditions() {
        fetch(`${baseURL}today/${code}`)
        .then(response => response.json())
        .then(result => {
            const townName = result.name
            const condition = result.forecast.condition
            const highTemp = result.forecast.high
            const lowTemp = result.forecast.low

            const divContainer = document.createElement('div')
            divContainer.setAttribute('class', 'forecasts')

            const conditionSymbolSpan = document.createElement('span')
            conditionSymbolSpan.setAttribute('class', 'condition symbol')
            
            const symbolResult = checkCondition(condition)
            conditionSymbolSpan.innerHTML = symbolResult

            const mainSpan = document.createElement('span')
            mainSpan.setAttribute('class', 'condition')
        
            const citySpan = document.createElement('span')
            citySpan.setAttribute('class', 'forecast-data')
            citySpan.textContent = townName

            const degreesSpan = document.createElement('span')
            degreesSpan.setAttribute('class', 'forecast-data')
            degreesSpan.innerHTML = `${lowTemp + '&#176;'+ '/' +  highTemp + '&#176;'}`

            const conditionSpan = document.createElement('span')
            conditionSpan.setAttribute('class', 'forecast-data')
            conditionSpan.textContent = condition

            divContainer.appendChild(conditionSymbolSpan)
            divContainer.appendChild(mainSpan)
            mainSpan.append(citySpan, degreesSpan, conditionSpan)

            divCurrentElement.appendChild(divContainer)
            
        })
    }


    function checkCondition(condition) {
        if (condition === 'Sunny') {
            return '&#x2600;'
        } else if (condition === 'Partly sunny') {
            return '&#x26C5;'
        } else if (condition === 'Overcast') {
            return '&#x2601;'
        } else if (condition === 'Rain') {
            return '&#x2614;'
        } 
    }

}

attachEvents();
