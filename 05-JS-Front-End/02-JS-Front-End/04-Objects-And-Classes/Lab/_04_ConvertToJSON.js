function convertToJSON(name, lastName, hairColor) {
    let object = {
        name,
        lastName,
        hairColor,
    };

    let jsonFormat = JSON.stringify(object);

    console.log(jsonFormat);
}
