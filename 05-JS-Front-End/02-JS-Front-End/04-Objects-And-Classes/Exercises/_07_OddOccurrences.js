function oddOccurrences(arr) {

    let words = arr.toLowerCase().split(' ')
    let wordArr = []
    let result = ''

    for (const element of words) {
        const count = words.filter(word => word === element).length;      

        if (count % 2 != 0 && !wordArr.includes(element)) {
            wordArr.push(element) 
        } 
    }
    
    wordArr.forEach(word => result += word + ' ')
    console.log(result);
}

