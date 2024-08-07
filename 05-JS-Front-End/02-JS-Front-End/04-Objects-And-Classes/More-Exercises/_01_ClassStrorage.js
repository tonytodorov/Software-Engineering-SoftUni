class Storage {
    constructor(capacity) {
        this.capacity = capacity
        this.storage = []
    }

    get totalCost() {        
        return this.storage.reduce((acc, el) => {return acc + el.price * el.quantity}, 0);
    }

    addProduct(product) {
        this.storage.push(product)
        this.capacity -= product.quantity
    }

    getProducts() {
        let result = []
        this.storage.forEach(product => result.push(JSON.stringify(product)))
        return result.join('\n')
    }
}
