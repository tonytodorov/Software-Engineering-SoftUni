function solve() {
    const buttonsElement = document.querySelectorAll('.add-product')
    const producstNameElement = document.querySelectorAll('.product-title')
    const productsPriceElement = document.querySelectorAll('.product-line-price')
    const resultElement = document.querySelector('textarea')
    const checkoutButton = document.querySelector('.checkout')
    const allButons = document.querySelectorAll('button')

    let products = {}

    for (let i = 0; i < buttonsElement.length; i++) {
        const element = buttonsElement[i];

        element.addEventListener('click', () => {
            const productName = producstNameElement[i].textContent
            const productPrice = productsPriceElement[i].textContent

            if (productName in products) {
                products[productName] += Number(productPrice)
            } else {
                products[productName] = Number(productPrice)
            }
         
            resultElement.textContent += `Added ${productName} for ${productPrice} to the cart.\n`
        })
    }

    checkoutButton.addEventListener('click', () => {
        let totalPrice = 0
        let productList = []

        for (const key in products) {
            totalPrice += products[key]
            productList.push(key)
        }

        resultElement.textContent += `You bought ${productList.join(', ')} for ${totalPrice.toFixed(2)}.`
        allButons.forEach(button => button.disabled = true)
    })

}
