function storeProvision(productsInStore, addedProducts) {

    let products = {}

    while (productsInStore.length != 0) {
        const currentProduct = productsInStore.shift()
        const currentQuantity = Number(productsInStore.shift())

        products[currentProduct] = currentQuantity
    }

    while (addedProducts.length != 0) {
        const currentProduct = addedProducts.shift()
        const currentQuantity = Number(addedProducts.shift())

        if(products[currentProduct]) {
            products[currentProduct] += currentQuantity
        } else {
            products[currentProduct] = currentQuantity
        }

    }

    for (const product in products) {
        console.log(`${product} -> ${products[product]}`);
    }
}
