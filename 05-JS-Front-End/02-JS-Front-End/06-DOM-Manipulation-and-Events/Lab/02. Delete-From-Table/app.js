function deleteByEmail() {
    const inputElement = document.querySelector('label input[type="text"]')
    const rowElements = document.querySelectorAll('table#customers tbody tr')
    const resultElement = document.getElementById('result')

    const trElement = Array
        .from(rowElements)
        .find(element => element.children[1].textContent === inputElement.value)

    if (trElement !== undefined) {
        trElement.remove()
        resultElement.textContent = 'Deleted.'
    } else {
        resultElement.textContent = 'Not found.'
    }

    inputElement.value = ''
}
