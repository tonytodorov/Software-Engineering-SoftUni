// Target by id
const movieList = document.getElementById('movie-list')
console.log(movieList);

// Target by class name
const headings = document.getElementsByClassName('heading')
console.log(headings);

// Iterate over result
for (const heading of headings) {
    console.log(heading);
}

// Target by tag name
const movieListElements = document.getElementsByTagName('li')
console.log(movieListElements);

// Target by css selector
const favouriteMovieElement = document.querySelector('#movie-list li:first-of-type') // Return HTML Collection
console.log(favouriteMovieElement);

const allMovieElements = document.querySelectorAll('#movie-list li') // Return NodeList
console.log(allMovieElements); // Access by index or iterate with for-of


// HTML Collection vs NodeList

// 1. Both are collections of DOM nodes
// 2. NodeList can contain any type (text, whitespaces etc)
// 3. Both are iterable
// 4. HTML Collection is LIVE, NodeList can be LIVE or STATIC


// Convert HTML Collection or NodeList to array
const convertToArray = Array.from(allMovieElements)
// const convertToArray = [...allMovieElements] Equavalent
console.log(convertToArray);
