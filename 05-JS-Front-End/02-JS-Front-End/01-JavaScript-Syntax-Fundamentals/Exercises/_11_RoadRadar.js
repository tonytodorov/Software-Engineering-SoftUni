function solve(speed, area) {
    if (area === 'residential' && speed <= 20) {
        console.log(`Driving ${speed} km/h in a 20 zone`);
    } else if (area === 'city' && speed <= 50) {
        console.log(`Driving ${speed} km/h in a 50 zone`);
    } else if (area === 'interstate' && speed <= 90) {
        console.log(`Driving ${speed} km/h in a 90 zone`);
    } else if (area === 'motorway' && speed <= 130) {
        console.log(`Driving ${speed} km/h in a 130 zone`);
    }

    if (area === 'residential' && speed > 20) {
        speed -= 20;
        if (speed <= 20) {
            console.log(`The speed is ${speed} km/h faster than the allowed speed of 20 - speeding`);
        } else if (speed <= 40) {
            console.log(`The speed is ${speed} km/h faster than the allowed speed of 20 - excessive speeding`);
        } else {
            console.log(`The speed is ${speed} km/h faster than the allowed speed of 20 - reckless driving`);
        }
    } else if (area === 'city' && speed > 50) {
        speed -= 50;
        if (speed <= 20) {
            console.log(`The speed is ${speed} km/h faster than the allowed speed of 50 - speeding`);
        } else if (speed <= 40) {
            console.log(`The speed is ${speed} km/h faster than the allowed speed of 50 - excessive speeding`);
        } else {
            console.log(`The speed is ${speed} km/h faster than the allowed speed of 50 - reckless driving`);
        }
    } else if (area === 'interstate' && speed > 90) {
        speed -= 90;
        if (speed <= 20) {
            console.log(`The speed is ${speed} km/h faster than the allowed speed of 90 - speeding`);
        } else if (speed <= 40) {
            console.log(`The speed is ${speed} km/h faster than the allowed speed of 90 - excessive speeding`);
        } else {
            console.log(`The speed is ${speed} km/h faster than the allowed speed of 90 - reckless driving`);
        }
    } else if (area === 'motorway' && speed > 130) {
        speed -= 130;
        if (speed <= 20) {
            console.log(`The speed is ${speed} km/h faster than the allowed speed of 130 - speeding`);
        } else if (speed <= 40) {
            console.log(`The speed is ${speed} km/h faster than the allowed speed of 130 - excessive speeding`);
        } else {
            console.log(`The speed is ${speed} km/h faster than the allowed speed of 130 - reckless driving`);
        }
    }
    
}
