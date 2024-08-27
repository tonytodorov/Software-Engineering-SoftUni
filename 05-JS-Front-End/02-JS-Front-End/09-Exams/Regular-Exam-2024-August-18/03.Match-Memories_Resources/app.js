const baseUrl = 'http://localhost:3030/jsonstore/matches'

const addButton = document.getElementById('add-match')
const editButton = document.getElementById('edit-match')
const loadButton = document.getElementById('load-matches')

const hostElement = document.getElementById('host')
const scoreElement = document.getElementById('score')
const guestElement = document.getElementById('guest')

const matchesList = document.getElementById('list')

addButton.addEventListener('click', addMatch)
editButton.addEventListener('click', editMatch)
loadButton.addEventListener('click', loadMatches)

async function addMatch() {
    const host = hostElement.value
    const score = scoreElement.value
    const guest = guestElement.value

    clearInputs()
    
    await fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({host, score, guest})
    })

    await loadMatches()
}

async function editMatch() {
    const matchId = matchesList.getAttribute('data-match-id')

    const host = hostElement.value
    const score = scoreElement.value
    const guest = guestElement.value

    clearInputs()

    await fetch(`${baseUrl}/${matchId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({host, score, guest, _id: matchId})
    })

    await loadMatches()

    editButton.setAttribute('disabled', 'disabled')

    addButton.removeAttribute('disabled')

    matchesList.removeAttribute('data-record-id')
}

async function loadMatches() {
    matchesList.innerHTML = ''
    
    const response = await fetch(baseUrl)
    const result = await response.json()
    const matches = Object.values(result)
    
    const matchesElements = matches.map(match => createMatchElement(match.host, match.score, match.guest, match._id))
    
    matchesList.append(...matchesElements)
}

function createMatchElement(host, score, guest, matchId) {
    const pHostElement = document.createElement('p')
    pHostElement.textContent = host
    
    const pScoreElement = document.createElement('p')
    pScoreElement.textContent = score
    
    const pGuestElement = document.createElement('p')
    pGuestElement.textContent = guest
    
    const divInfo = document.createElement('div')
    divInfo.classList.add('info')
    divInfo.appendChild(pHostElement)
    divInfo.appendChild(pScoreElement)
    divInfo.appendChild(pGuestElement)
    
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
    liElement.classList.add('match')
    liElement.appendChild(divInfo)
    liElement.appendChild(divButtons)

    changeButton.addEventListener('click', () => {
        hostElement.value = host
        scoreElement.value = score
        guestElement.value = guest

        editButton.removeAttribute('disabled')

        addButton.setAttribute('disabled', 'disabled')

        matchesList.setAttribute('data-match-id', matchId)
    })

    deleteButton.addEventListener('click', async () => {
        await fetch(`${baseUrl}/${matchId}`, {
            method: 'DELETE'
        })

        await loadMatches()
    })
    
    return liElement
}

function clearInputs() {
    hostElement.value = ''
    scoreElement.value = ''
    guestElement.value = ''
}

