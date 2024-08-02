function create(words) {
    const mainDiv = document.getElementById('content')
    
    words.forEach(element => {
        const createDiv = document.createElement('div')
        const createParagraph = document.createElement('p')
        createParagraph.textContent = element
        createParagraph.style.display = 'none'
        
        createDiv.appendChild(createParagraph)
        mainDiv.appendChild(createDiv)
    });
    
    const divChilds = document.querySelectorAll('#content div')
    const paragraphs = document.querySelectorAll('#content div p')
    
    for (let i = 0; i < divChilds.length; i++) {
        const element = divChilds[i];
        
        element.addEventListener('click', () => {
            paragraphs[i].style.display = 'block'
        })
    }
}
