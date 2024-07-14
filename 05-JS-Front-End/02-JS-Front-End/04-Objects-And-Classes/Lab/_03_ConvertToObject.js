function convertToObject(object) {
    let result = JSON.parse(object);

    let entries = Object.entries(result);

    for (let i = 0; i < entries.length; i++) {
        let element = entries[i];

        let key = element[0];
        let value = element[1];

        console.log(`${key}: ${value}`);
        
    }
}
