function solve(fruit, weight, pricePerKg) {
    const weightInKg = weight / 1000;
    const totalPrice = weightInKg * pricePerKg;
    console.log(`I need $${totalPrice.toFixed(2)} to buy ${weightInKg.toFixed(2)} kilograms ${fruit}.`);
}
