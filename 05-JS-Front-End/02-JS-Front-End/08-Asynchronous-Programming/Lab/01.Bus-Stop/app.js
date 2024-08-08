function getInfo() {
    const busNumberElement = document.querySelector('input[type=text]')
    const busStopNameElement = document.getElementById('stopName') 
    const resultElement = document.getElementById('buses') 
    const baseURL = `http://localhost:3030/jsonstore/bus/businfo/${busNumberElement.value}`

    resultElement.innerHTML = ''

    fetch(baseURL)
    .then(response => response.json())
    .then(result => {
        const stopName = result.name
        busStopNameElement.textContent = stopName
    
        const buses = Object.entries(result.buses)

        buses.forEach(bus => {
            const number = bus[0]
            const minutes = bus[1]
          
            const liElement = document.createElement('li')
            liElement.textContent = `Bus ${number} arrived in ${minutes} minutes`
            resultElement.appendChild(liElement)

        })  
    })
    .catch(busStopNameElement.textContent = 'Error')

    busNumberElement.value = ''
}
