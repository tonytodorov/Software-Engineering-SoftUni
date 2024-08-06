function validate() {
    const inputElement = document.getElementById('email')
    
    inputElement.addEventListener('change', () => {
        const email = inputElement.value
        const emailRegex = /^[a-z]+@[a-z]+\.[a-z]{0,}$/;
        const isValidEmail = emailRegex.test(email)

        if (!isValidEmail) {
            inputElement.className = 'error'
        } else {
            inputElement.removeAttribute('class')
        }
    })
}
