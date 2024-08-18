const baseUrl = 'http://localhost:3030/jsonstore/games'

const loadButton = document.getElementById('load-games')
const addButton = document.getElementById('add-game')
const editButton = document.getElementById('edit-game')

const gameNameElement = document.getElementById('g-name')
const typeElement = document.getElementById('type')
const playersElement = document.getElementById('players')

const gameList = document.getElementById('games-list')

const formElement = document.querySelector('#form form')

loadButton.addEventListener('click', loadGames)
addButton.addEventListener('click', addGame)
editButton.addEventListener('click', editGame)

async function addGame() {
    // Get input data
    const name = gameNameElement.value
    const type = typeElement.value  
    const players = playersElement.value

    // Clear inputs
    clearInputs()

    // Create post request
    await fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({name, type, players})
    })
    
    // Fetch all games
    await loadGames()    
}

async function editGame() {
    // Get id from form attribute
    const gameId = formElement.getAttribute('data-game-id')

    // Get info from inputs
    const name = gameNameElement.value
    const type = typeElement.value  
    const players = playersElement.value
    
    // Clear inputs
    clearInputs()
    
    // Send PUT request
    await fetch(`${baseUrl}/${gameId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({name, type, players, _id: gameId}),
    })

    // Load all games
    await loadGames()

    // Deactivate edit button
    editButton.setAttribute('disabled', 'disabled')

    // Activate add button
    addButton.removeAttribute('disabled')

    // Clear attribute ID
    formElement.removeAttribute('data-game-id')
}

async function loadGames()  {
    // Clear games list
    gameList.innerHTML = ''

    // Get request
    const response = await fetch(baseUrl)
    const result = await response.json()
    const games = Object.values(result)

    // Create game element
    const gameElements = games.map(game => createGameElement(game.name, game.type, game.players, game._id))

    // Add to game list
    gameList.append(...gameElements)
}

function createGameElement(name, type, players, gameId) {
    const pGameElement = document.createElement('p')
    pGameElement.textContent = name

    const pTypeElement = document.createElement('p')
    pTypeElement.textContent = type

    const pPlayersElement = document.createElement('p')
    pPlayersElement.textContent = players

    const divContent = document.createElement('div')
    divContent.classList.add('content')
    divContent.appendChild(pGameElement)
    divContent.appendChild(pTypeElement)
    divContent.appendChild(pPlayersElement)

    const changeButton = document.createElement('button')
    changeButton.classList.add('change-btn')
    changeButton.textContent = 'Change'

    const deleteButton = document.createElement('button')
    deleteButton.classList.add('delete-btn')
    deleteButton.textContent = 'Delete'

    const divButtons = document.createElement('div')
    divButtons.classList.add('buttons-container');
    divButtons.appendChild(changeButton)
    divButtons.appendChild(deleteButton)

    const gameDiv = document.createElement('div')
    gameDiv.classList.add('board-game')
    gameDiv.appendChild(divContent)
    gameDiv.appendChild(divButtons)

    changeButton.addEventListener('click', () => {
        // Populate game info into input fields 
        gameNameElement.value = name
        typeElement.value = type
        playersElement.value = players

        // Activate edit game button
        editButton.removeAttribute('disabled')

        // Deactivate add game button
        addButton.setAttribute('disabled', 'disabled')

        // Set id attribute
        formElement.setAttribute('data-game-id', gameId)
    })

    deleteButton.addEventListener('click', async () => {
        // Send DELETE request
        await fetch(`${baseUrl}/${gameId}`, {
            method: 'DELETE'
        })

        // Fetch all games
        await loadGames()
    })

    return gameDiv
}

function clearInputs() {
    gameNameElement.value = ''
    typeElement.value = '' 
    playersElement.value = ''
}
