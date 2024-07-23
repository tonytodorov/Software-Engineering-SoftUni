function makeDictionary(array) {

    let map = {}

    for (const element of array) {
        const obj = JSON.parse(element)   
        const entries = Object.entries(obj)

        const term = entries[0][0]
        const definition = entries[0][1]

        map[term] = definition
    }

    const result = Object.entries(map)

    result.sort((a, b) => a[0].localeCompare(b[0]))
            .forEach(term => console.log(`Term: ${term[0]} => Definition: ${term[1]}`))
}

