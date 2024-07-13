function city(object) {

    const entries = Object.entries(object);
    
    for (let i = 0; i < entries.length; i++) {
        let property = entries[i];

        let key = property[0];
        let value = property[1];

        console.log(`${key} -> ${value}`);
    }
}

