function solve(number) {
    let type = typeof number;
    if (type === 'number') {
        const area = Math.pow(number, 2) * Math.PI; 
        console.log(area.toFixed(2));
    } else {
        console.log(`We can not calculate the circle area, because we receive a ${type}.`);
    }
}


