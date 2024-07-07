function login(text) {

    let password = text[0].split('')
            .reverse()
            .join('');
    let countTimes = 1;

    for (let i = 1; i < text.length; i++) {
        let currentStr = text[i];
        
        if (currentStr === password) {
            console.log(`User ${text[0]} logged in.`);
            break;
        } else if (countTimes != 4) {
            console.log('Incorrect password. Try again.');
        }

        if (countTimes >= 4) {
            console.log(`User ${text[0]} blocked!`);
            break
        }
        
        countTimes++;
    }
}

login(['Acer','login','go','let me in','recA']);
login(['sunny','rainy','cloudy','sunny','not sunny']);
// login(['momo','omom']);