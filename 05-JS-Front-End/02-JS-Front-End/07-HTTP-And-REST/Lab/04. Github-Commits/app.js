function loadCommits() {
    
    const usernameElement = document.getElementById('username')
    const repoElement = document.getElementById('repo')
    const resultElement = document.getElementById('commits')
    
    const ulElement = document.createElement('ul')
    ulElement.setAttribute('id', 'result')
    resultElement.appendChild(ulElement)
    
    const baseURL = `https://api.github.com/repos/${usernameElement.value}/${repoElement.value}/commits`
    
    resultElement.innerHTML = ''

    fetch(baseURL)
    .then(response => response.json())
    .then(result => 
        result.forEach(state => {
            const authorName = state.commit.author.name 
            const commitMessage = state.commit.message            

            const liElement = document.createElement('li')
            liElement.textContent = `${authorName}: ${commitMessage}`
            resultElement.appendChild(liElement)

            usernameElement.value = ''
            repoElement.value = ''
        }))
        
    }
    