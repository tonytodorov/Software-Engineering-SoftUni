function addItem() {
    const textInput = document.querySelector('input[type="text"]')
    const listItems = document.getElementById('items')

    const newElement = document.createElement('li')
    newElement.textContent = textInput.value

    listItems.appendChild(newElement)

    textInput.value = ''
}
