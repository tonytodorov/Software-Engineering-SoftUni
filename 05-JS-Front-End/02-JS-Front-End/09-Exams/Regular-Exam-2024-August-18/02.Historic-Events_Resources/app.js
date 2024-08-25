window.addEventListener("load", solve);

function solve() {
    const nameElement = document.getElementById('name') 
    const timeElement = document.getElementById('time')
    const descriptionElement = document.getElementById('description') 
    
    const addButton = document.getElementById('add-btn') 
    
    const previewList = document.getElementById('preview-list')
    const archiveList = document.getElementById('archive-list')
    
    addButton.addEventListener('click', (e) => {
        e.preventDefault()
        
        const name = nameElement.value
        const time = timeElement.value
        const description = descriptionElement.value
        
        clearInputs()

        if (name !== '' && time !== '' && description !== '') {
            const eventElement = createEvent(name, time, description)
            previewList.appendChild(eventElement)
            addButton.setAttribute('disabled', 'disabled')
        }
        
        
    })
    
    function createEvent(name, time, description) {
        const pNameElement = document.createElement('p')
        pNameElement.textContent = name
        
        const pTimeElement = document.createElement('p')
        pTimeElement.textContent = time
        
        const pDescriptionElement = document.createElement('p')
        pDescriptionElement.textContent = description
        
        const articleElement = document.createElement('article')
        articleElement.appendChild(pNameElement)
        articleElement.appendChild(pTimeElement)
        articleElement.appendChild(pDescriptionElement)
        
        const editButton = document.createElement('button')
        editButton.classList.add('edit-btn')
        editButton.textContent = 'Edit'
        
        const nextButton = document.createElement('button')
        nextButton.classList.add('next-btn')
        nextButton.textContent = 'Next'
        
        const divButtons = document.createElement('div')
        divButtons.classList.add('buttons')
        divButtons.appendChild(editButton)
        divButtons.appendChild(nextButton)
        
        const liElement = document.createElement('li')
        liElement.appendChild(articleElement)
        liElement.appendChild(divButtons)

        editButton.addEventListener('click', () => {
            nameElement.value = name
            timeElement.value = time
            descriptionElement.value = description

            liElement.remove()
            addButton.removeAttribute('disabled')
        })

        nextButton.addEventListener('click', () => {
            divButtons.remove()

            const archiveButton = document.createElement('button')
            archiveButton.classList.add('archive-btn')
            archiveButton.textContent = 'Archive'

            archiveButton.addEventListener('click', () => {
                liElement.remove()
                addButton.removeAttribute('disabled')
            })

            liElement.appendChild(archiveButton)

            archiveList.appendChild(liElement)
        })
        
        return liElement
    }
    
    function clearInputs() {
        nameElement.value = ''
        timeElement.value = ''
        descriptionElement.value = ''
    }
}
