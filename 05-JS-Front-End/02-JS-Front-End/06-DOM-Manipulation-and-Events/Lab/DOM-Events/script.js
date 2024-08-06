const decrementButtonElement = document.getElementById('decrement')
const countElement = document.getElementById('count')
const resetButtonElement = document.getElementById('reset')

// With HTML Attribute
function onIncrement() {
    countElement.textContent = Number(countElement.textContent) + 1
}

// Using DOM properties
decrementButtonElement.onclick = function() {
    countElement.textContent = Number(countElement.textContent) - 1
}

// Using DOM event handler - preferred method
const eventListener = () => {
    countElement.textContent = 0
}
resetButtonElement.addEventListener('click', eventListener)

// Remove event listener for rest after 5 seconds
setTimeout(() => {
    resetButtonElement.removeEventListener('click', eventListener)
}, 5_000)
