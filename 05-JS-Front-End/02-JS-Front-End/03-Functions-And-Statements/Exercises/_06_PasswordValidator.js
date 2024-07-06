function passwordValidator(password = '') {
    const isLengthValid = password.length >= 6 && password.length <= 10;

    let isContainsOnlyLettersAndDigits = true;
    let countDigits = 0;

    for (let i = 0; i < password.length; i++) {
        let char = password.charCodeAt(i);

        if (char < 47 || char > 58 &&
            char < 65  || char > 90 &&
            char < 97  || char > 122) {
                isContainsOnlyLettersAndDigits = false;
                break;
        }
    }


    for (let i = 0; i < password.length; i++) {
        let char = password.charCodeAt(i);

        if (char > 47 && char < 58) {
            countDigits++;
        }
    }

    if (!isLengthValid) {
        console.log('Password must be between 6 and 10 characters');
    }

    if (!isContainsOnlyLettersAndDigits) {
        console.log('Password must consist only of letters and digits');
    }

    if (countDigits < 2) {
        console.log('Password must have at least 2 digits');
    }

    if (isLengthValid && isContainsOnlyLettersAndDigits && countDigits >= 2) {
        console.log('Password is valid');
    }
}
