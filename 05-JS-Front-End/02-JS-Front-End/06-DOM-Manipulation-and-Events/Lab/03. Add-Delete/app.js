function addItem() {
    const inputText = document.getElementById('newItemText')
    const listItems = document.getElementById('items')

    const createElement = document.createElement('li')
    const createLink = document.createElement('a')
    createElement.textContent = inputText.value

    listItems.appendChild(createElement)
    createElement.appendChild(createLink)

    createLink.setAttribute('href', '#')
    createLink.textContent = '[Delete]'

    createLink.addEventListener('click', (event) => {
        // createElement.remove() // Tight coupling (not recommended)
        event.currentTarget.parentElement.remove() // Loose coupling (recommended)
    })

    inputText.value = ''
}
