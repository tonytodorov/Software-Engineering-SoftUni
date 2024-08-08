const baseURL = 'https://api.github.com/users/testnakov/repos'

function loadRepos() {
    const button = document.querySelector('button')
    const resultElement = document.getElementById('res')
    
    button.addEventListener('click', () => {
        fetch(baseURL)
        .then(response => response.text())
        .then(result => {
            resultElement.textContent = result
        })
    })
}
