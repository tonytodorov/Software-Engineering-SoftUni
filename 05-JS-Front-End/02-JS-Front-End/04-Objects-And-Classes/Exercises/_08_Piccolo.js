function piccolo(cars) {

    let result = {}
    
    for (const car of cars) {
        const currentCar = car.split(', ')

        const direction = currentCar[0]
        const number = currentCar[1]

        if (direction === 'IN') {
            result[number] = ''
        } else {
            delete result[number]
        }
    }

    let entries = Object.entries(result)

    let sortedNumbers = entries.sort((a, b) => a[0].localeCompare(b[0]))

    if (sortedNumbers.length != 0) {
        sortedNumbers.forEach(car => console.log(car[0]))
    } else {
        console.log('Parking Lot is Empty');
    }

}
