function addressBook(array) {

    let addressBook = {}

    for (let address of array) {
        let data = address.split(':')

        let key = data[0]
        let value = data[1]
        

        addressBook[key] = value
    }

    Object.entries(addressBook)
        .sort((a, b) => a[0].localeCompare(b[0]))
        .forEach(element => console.log(`${element[0]} -> ${element[1]}`))
}
