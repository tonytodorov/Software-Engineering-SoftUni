// DOM query
const movieListElement = document.getElementById('movies')
const firstMovieElement = document.querySelector('.first-movie')

// Create element
const secondMovieElement = document.createElement('li')
secondMovieElement.textContent = 'Man of Steel'

// Append element to DOM
movieListElement.appendChild(secondMovieElement)

// Append existing element to DOM
movieListElement.appendChild(firstMovieElement)

// Clone existing element and prepend (add element on the first position)
const firstMovieCloneElement = firstMovieElement.cloneNode(true)
firstMovieCloneElement.textContent = 'Avatar'
movieListElement.prepend(firstMovieCloneElement)

// Append element on specific place before another child element 
const thirdMovieElement = document.createElement('li')
thirdMovieElement.textContent = 'Lord of the Rings'

movieListElement.insertBefore(thirdMovieElement, secondMovieElement)

// Use before or after
const fourthMovieElement = document.createElement('li')
fourthMovieElement.textContent = 'In Time'
thirdMovieElement.after(fourthMovieElement)
