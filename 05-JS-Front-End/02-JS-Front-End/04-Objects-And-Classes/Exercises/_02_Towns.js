function towns(towns) {
    
    class Town {
        constructor(town, latitude, longitude) {
            this.town = town;
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }

    let result = []

    for (const town of towns) {
        const data = town.split(' | ')
        
        const name = data[0]
        const latitude = data[1]
        const longitude = data[2]

        const currentTown = new Town(name, latitude, longitude)
        
        result.push(currentTown)
    }


    for (const town of result) {
        console.log(`{ town: '${town.town}', latitude: '${Number(town.latitude).toFixed(2)}', longitude: '${Number(town.longitude).toFixed(2)}' }`);
    }
}

