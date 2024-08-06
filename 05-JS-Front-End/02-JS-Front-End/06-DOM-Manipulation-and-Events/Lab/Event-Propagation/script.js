const orangeElement = document.querySelector('.orange')
const greenElement = document.querySelector('.green')
const yellowElement = document.querySelector('.yellow')

orangeElement.addEventListener('click', () => {
    console.log('Orange clicked');
}, {capture: false}) 

greenElement.addEventListener('click', (event) => {
    event.stopPropagation()
    console.log('Green clicked');
}, {capture: false})

yellowElement.addEventListener('click', () => {
    console.log('Yellow clicked');
}, {capture: false})

// With capture: true, the output will be orange, green and yellow because use capturing.
// The default behavior is bubling -> the output will be yellow, green orange
