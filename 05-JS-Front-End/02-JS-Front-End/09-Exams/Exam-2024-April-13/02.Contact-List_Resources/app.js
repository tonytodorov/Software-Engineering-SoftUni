window.addEventListener("load", solve);

function solve() {
    const nameElement = document.getElementById('name')
    const phoneElement = document.getElementById('phone')
    const categoryElement = document.getElementById('category')

    const addButton = document.getElementById('add-btn')

    const checkList = document.getElementById('check-list')
    const contactList = document.getElementById('contact-list')

    addButton.addEventListener('click', () => {
        const name = nameElement.value
        const phone = phoneElement.value
        const category = categoryElement.value

        const liElement = createElement(name, phone, category)

        checkList.appendChild(liElement)

        clearInputs()
    })

    function createElement(name, phone, category) {
        const pNameElement = document.createElement('p')
        pNameElement.textContent = `name:${name}`
        
        const pPhoneElement = document.createElement('p')
        pPhoneElement.textContent = `phone:${phone}`
        
        const pCategoryElement = document.createElement('p')
        pCategoryElement.textContent = `category:${category}`

        const articleElement = document.createElement('article')
        articleElement.appendChild(pNameElement)
        articleElement.appendChild(pPhoneElement)
        articleElement.appendChild(pCategoryElement)

        const editButton = document.createElement('button')
        editButton.classList.add('edit-btn')

        const saveButton = document.createElement('button')
        saveButton.classList.add('save-btn')

        const divButtons = document.createElement('div')
        divButtons.classList.add('buttons');
        divButtons.appendChild(editButton)
        divButtons.appendChild(saveButton)

        const liElement = document.createElement('li')
        liElement.appendChild(articleElement)
        liElement.appendChild(divButtons)

        editButton.addEventListener('click', () => {
            nameElement.value = name
            phoneElement.value = phone
            categoryElement.value = category

            liElement.remove()
        })
        
        saveButton.addEventListener('click', () => {
            divButtons.remove()

            const deleteButton = document.createElement('button')
            deleteButton.classList.add('del-btn')

            deleteButton.addEventListener('click', () => {
                liElement.remove()
            })

            liElement.appendChild(deleteButton)
            contactList.appendChild(liElement)
        })

        return liElement
    }


    function clearInputs() {
        nameElement.value = ''
        phoneElement.value = ''
        categoryElement.value = ''
    }
}
