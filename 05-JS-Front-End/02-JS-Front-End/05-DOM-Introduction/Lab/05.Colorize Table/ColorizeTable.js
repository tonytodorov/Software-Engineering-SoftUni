function colorize() {

    // With iteration

    // const tableElement = document.querySelector('table tbody')
    // const tableRowElements = tableElement.children

    // for (let i = 1; i < tableRowElements.length; i+=2) {
    //     tableRowElements[i].style.backgroundColor = 'teal'      
    // }

    // With CSS selector
    const evenTableRowElements = document.querySelectorAll('table tbody tr:nth-child(even)')
    
    for (const element of evenTableRowElements) {
        element.style.backgroundColor = 'teal'
    }
}
