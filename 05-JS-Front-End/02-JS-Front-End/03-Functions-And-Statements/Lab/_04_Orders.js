function solve(product, count) {
    let price = 0;

    if (product === 'coffee') {
        price = 1.50;
    } else if (product === 'water') {
        price = 1.00;
    } else if (product === 'coke') {
        price = 1.40;
    } else {
        price = 2.00
    }

    let totalPrice = price * count;
    console.log(`${totalPrice.toFixed(2)}`);
}
