const baseUrl = 'http://localhost:3030/jsonstore/records'

const addButton = document.getElementById('add-record')
const editButton = document.getElementById('edit-record')
const loadButton = document.getElementById('load-records')

const nameElement = document.getElementById('p-name')
const stepsElement = document.getElementById('steps')
const caloriesElement = document.getElementById('calories')

const recordsList = document.getElementById('list')

addButton.addEventListener('click', addRecord)
editButton.addEventListener('click', editRecord)
loadButton.addEventListener('click', loadRecords)

async function addRecord() {
    const name = nameElement.value
    const steps = stepsElement.value
    const calories = caloriesElement.value

    clearInputs()

    await fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({name, steps, calories})
    })

    await loadRecords()
}

async function editRecord() {
    const recordID = recordsList.getAttribute('data-record-id')

    const name = nameElement.value
    const steps = stepsElement.value
    const calories = caloriesElement.value

    clearInputs()

    await fetch(`${baseUrl}/${recordID}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({name, steps, calories, _id: recordID})
    })

    await loadRecords()

    editButton.setAttribute('disabled', 'disabled')

    addButton.removeAttribute('disabled')

    recordsList.removeAttribute('data-record-id')
}

async function loadRecords() {
    recordsList.innerHTML = ''

    const response = await fetch(baseUrl)
    const result = await response.json()
    const records = Object.values(result)

    const recordsElements = records.map(record => createRecordElement(record.name, record.steps, record.calories, record._id))

    recordsList.append(...recordsElements)
}

function createRecordElement(name, steps, calories, recordId) {
    const pNameElement = document.createElement('p')
    pNameElement.textContent = name

    const pStepsElement = document.createElement('p')
    pStepsElement.textContent = steps

    const pCaloriesElement = document.createElement('p')
    pCaloriesElement.textContent = calories

    const divInfo = document.createElement('div')
    divInfo.classList.add('info')
    divInfo.appendChild(pNameElement)
    divInfo.appendChild(pStepsElement)
    divInfo.appendChild(pCaloriesElement)

    const changeButton = document.createElement('button')
    changeButton.classList.add('change-btn')
    changeButton.textContent = 'Change'

    const deleteButton = document.createElement('button')
    deleteButton.classList.add('delete-btn')
    deleteButton.textContent = 'Delete'

    const divButtons = document.createElement('div')
    divButtons.classList.add('btn-wrapper')
    divButtons.appendChild(changeButton)
    divButtons.appendChild(deleteButton)

    const liElement = document.createElement('li')
    liElement.classList.add('record')
    liElement.appendChild(divInfo)
    liElement.appendChild(divButtons)

    changeButton.addEventListener('click', () => {
        nameElement.value = name
        stepsElement.value = steps
        caloriesElement.value = calories

        editButton.removeAttribute('disabled')

        addButton.setAttribute('disabled', 'disabled')

        recordsList.setAttribute('data-record-id', recordId)
    })

    deleteButton.addEventListener('click', async () => {
        await fetch(`${baseUrl}/${recordId}`, {
            method: 'DELETE'
        })

        await loadRecords()
    })

    return liElement
}

function clearInputs() {

}
