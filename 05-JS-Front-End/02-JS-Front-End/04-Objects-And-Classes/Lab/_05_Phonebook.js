function phonebook(array) {

    let phonebook = {};

    for (let element of array) {
        let tokens = element.split(' ');

        let key = tokens[0];
        let value = tokens[1];

        phonebook[key] = value;
    }

    for (let obj in phonebook) {
        console.log(`${obj} -> ${phonebook[obj]}`); 
    }

}
