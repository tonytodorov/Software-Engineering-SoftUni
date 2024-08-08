function loadRepos() {
	const inputElement = document.getElementById('username')
	const resultElement = document.getElementById('repos')

	const baseURL = `https://api.github.com/users/${inputElement.value}/repos`
	
	resultElement.innerHTML = ''

	fetch(baseURL)
	.then(response => response.json())
	.then(result => {
		result.forEach(repo => {
			const liElement = document.createElement('li')
			const aElement = document.createElement('a')

			aElement.setAttribute('href', repo.html_url)
			aElement.textContent = `${repo.full_name}`
			liElement.appendChild(aElement)
			resultElement.appendChild(liElement)

			inputElement.value = ''
		});
	})
	
}
