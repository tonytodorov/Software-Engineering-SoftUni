function addItem() {
    const textElement = document.getElementById('newItemText')
    const valueElement = document.getElementById('newItemValue')
    const menu = document.getElementById('menu')

    const text = textElement.value
    const value = valueElement.value 

    const createOption = document.createElement('option') 
    createOption.textContent = text
    createOption.value = value

    menu.appendChild(createOption)

    textElement.value = ''
    valueElement.value = ''
}
