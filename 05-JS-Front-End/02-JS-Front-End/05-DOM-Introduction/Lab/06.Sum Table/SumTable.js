function sumTable() {
    const resultElement = document.getElementById('sum')
    const trElements = document.querySelectorAll('table tr td:last-of-type:not(#sum)')
    let sum = 0

    for (const element of trElements) {
        const price = Number(element.textContent)
        sum += price
    }

    resultElement.textContent = sum 
}
