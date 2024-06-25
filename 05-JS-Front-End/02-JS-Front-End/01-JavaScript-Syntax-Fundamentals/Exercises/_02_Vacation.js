function solve(numberOfPeople, typeOfGroup, dayOfWeek) {
    let price = 0;

    if (typeOfGroup === 'Students') {
        if (dayOfWeek === 'Friday') {
            price = 8.45;
        } else if (dayOfWeek === 'Saturday') {
            price =  9.80;
        } else if (dayOfWeek === 'Sunday') {
            price = 10.46;
        }
    } else if (typeOfGroup === 'Business') {
        if (dayOfWeek === 'Friday') {
            price = 10.90;
        } else if (dayOfWeek === 'Saturday') {
            price = 15.60;
        } else if (dayOfWeek === 'Sunday') {
            price = 16;
        }
    } else if (typeOfGroup === 'Regular') {
        if (dayOfWeek === 'Friday') {
            price = 15;
        } else if (dayOfWeek === 'Saturday') {
            price = 20;
        } else if (dayOfWeek === 'Sunday') {
            price = 22.50;
        }
    }

    let totalPrice = numberOfPeople * price;

    if (typeOfGroup === 'Students' && numberOfPeople >= 30) {
        totalPrice *= 0.85;
    } else if (typeOfGroup === 'Business' && numberOfPeople >= 100) {
        totalPrice = totalPrice - (10 * price);
    } else if (typeOfGroup === 'Regular' && numberOfPeople >= 10 && numberOfPeople <= 20) {
        totalPrice *= 0.95;
    }

    console.log(`Total price: ${totalPrice.toFixed(2)}`);
}