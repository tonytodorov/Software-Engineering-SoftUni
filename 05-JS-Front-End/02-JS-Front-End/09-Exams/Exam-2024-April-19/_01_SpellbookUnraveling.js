function spellbokUnreveling(input) {

    let word = input.shift()

    let command = input.shift()

    while (command !== 'End') {

        if (command === 'RemoveEven') {
            word = word.split('').filter((_, index) => index % 2 === 0).join('');
        } else if (command.startsWith('TakePart!')) {
            const [_, firstIndex, secondIndex] = command.split('!')
            word = word.slice(firstIndex, secondIndex)
        } else if (command.startsWith('Reverse!')) {
            const [_, substring] = command.split('!')

            if (!word.includes(substring)) {
                console.log('Error');
                break     
            } else {
                const reversedString = substring.split('').reverse().join('')
                word = word.replace(substring, '').concat(reversedString)                
            }
        }
        
        console.log(word);
        command = input.shift()
    }

    console.log(`The concealed spell is: ${word}`);
}
