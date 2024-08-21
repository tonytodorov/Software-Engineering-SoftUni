window.addEventListener("load", solve);

function solve() {
    const animalElement = document.getElementById('type')
    const ageElement = document.getElementById('age')
    const genderElement = document.getElementById('gender')

    const adoptButton = document.getElementById('adopt-btn')

    const adoptionInfo = document.getElementById('adoption-info')
    const adoptedList = document.getElementById('adopted-list')

    adoptButton.addEventListener('click', (e) => {
        e.preventDefault()

        const animal = animalElement.value
        const age = ageElement.value
        const gender = genderElement.value

        const liElement = createAnimalElement(animal, age, gender)

        adoptionInfo.appendChild(liElement)

        clearInputs()
    })

    function createAnimalElement(animal, age, gender) {
        const pAnimalElement = document.createElement('p')
        pAnimalElement.textContent = `Pet:${animal}`

        const pAgeElement = document.createElement('p')
        pAgeElement.textContent = `Gender:${gender}`

        const pGenderElement = document.createElement('p')
        pGenderElement.textContent = `Age:${age}`

        const articleElement = document.createElement('article')
        articleElement.appendChild(pAnimalElement)
        articleElement.appendChild(pAgeElement)
        articleElement.appendChild(pGenderElement)

        const editButton = document.createElement('button')
        editButton.classList.add('edit-btn')
        editButton.textContent = 'Edit'

        const doneButton = document.createElement('button')
        doneButton.classList.add('done-btn')
        doneButton.textContent = 'Done'

        const divButtons = document.createElement('div')
        divButtons.classList.add('buttons')
        divButtons.appendChild(editButton)
        divButtons.appendChild(doneButton)

        const liElement = document.createElement('li')
        liElement.appendChild(articleElement)
        liElement.appendChild(divButtons)

        editButton.addEventListener('click', () => {
            animalElement.value = animal
            ageElement.value = age
            genderElement.value = gender

            liElement.remove()
        })

        doneButton.addEventListener('click', () => {
            divButtons.remove()

            const clearButton = document.createElement('button')
            clearButton.classList.add('clear-btn')
            clearButton.textContent = 'Clear'

            clearButton.addEventListener('click', () => {
                liElement.remove()
            })

            liElement.appendChild(clearButton)
            adoptedList.appendChild(liElement)
        })
        

        return liElement
    }

    function clearInputs() {
        animalElement.value = ''
        ageElement.value = ''
        genderElement.value = ''
    }

}
