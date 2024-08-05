function solve() {
    const tbodyElement = document.querySelector('table tbody')
    const generateButtonElement = document.querySelector('#exercise button')
    const textAreaInputElement = document.querySelector('#exercise textarea')
    const textAreaResultElement = document.querySelector('#exercise textarea:last-of-type')
    const buyButtonElement = document.querySelector('#exercise button:last-of-type')
    
    generateButtonElement.addEventListener('click', () => {
        const parseJson = JSON.parse(textAreaInputElement.value)

        parseJson.forEach(furniture => {
            const name = furniture.name
            const img = furniture.img
            const price = furniture.price
            const decFactor = furniture.decFactor

            const createTr = document.createElement('tr')
            
            const firstTd = document.createElement('td')
            const createImg = document.createElement('img')
            createImg.setAttribute('src', img)
            firstTd.appendChild(createImg)
            
            const secondTd = document.createElement('td')
            const firstParagraph = document.createElement('p')
            firstParagraph.textContent = name
            secondTd.appendChild(firstParagraph)
            
            const thirdTd = document.createElement('td')
            const secondParagraph = document.createElement('p')
            secondParagraph.textContent = price
            thirdTd.appendChild(secondParagraph)
            
            const fourthTd = document.createElement('td')
            const thirdParagraph = document.createElement('p')
            thirdParagraph.textContent = decFactor
            fourthTd.appendChild(thirdParagraph)
            
            const fifthTd = document.createElement('td')
            const checkBox = document.createElement('input')
            checkBox.setAttribute('type', 'checkbox')
            fifthTd.appendChild(checkBox)

            createTr.append(firstTd, secondTd, thirdTd, fourthTd, fifthTd)

            tbodyElement.appendChild(createTr)
        })

        textAreaInputElement.value = ''
    })

    buyButtonElement.addEventListener('click', () => {
        const checkBoxes = document.querySelectorAll('input[type=checkbox]')
        
        const boughtFurnitures = []
        let totalPrice = 0
        let sumDecFactor = 0
        let countDecFactor = 0
        let averageDecFactor = 0

        for (let i = 0; i < checkBoxes.length; i++) {
            const checkBox = checkBoxes[i];            

            if (checkBox.checked === true) {
                const tdElement = tbodyElement.children[i].children
                const name = tdElement[1].textContent
                const price = Number(tdElement[2].textContent)
                const decFactor = Number(tdElement[3].textContent)

                boughtFurnitures.push(name)
                totalPrice += price
                sumDecFactor += decFactor
                countDecFactor++
            }
        }

        averageDecFactor = sumDecFactor / countDecFactor
        textAreaResultElement.disabled = false
        textAreaResultElement.textContent = `Bought furniture: ${boughtFurnitures.join(', ')}\nTotal price: ${totalPrice.toFixed(2)}\nAverage decoration factor: ${averageDecFactor}`
        textAreaResultElement.disabled = true

    })
}
