// Declare an array
let numbers = [13, 42, 73, 69];

// Access element from array
let num = numbers[1];
console.log(num);

// Accessing invalid indexes (result is undefined)
let firstNum = numbers[-1];
let secondNum = numbers[19];

console.log(firstNum);
console.log(secondNum);

// For of loop (like foreach)
for (let values of numbers) {
    console.log(values);
}

// Classic for (when need indexes)
for (let i = 0; i < numbers.length; i++) {
    console.log(numbers[i]);    
}

// Print elements in one row
let result = '';

for (let num of numbers) {
    // result += num + ' ';
    result += `${num} `;    
}

console.log(result);

// When initialized 10 element in array
numbers[10] = 849;
console.log(numbers.length);
console.log(numbers);

// Set upper array length
let arr = [1, 2, 3];
console.log(arr.length);
arr.length = 10;

console.log(arr.length);
console.log(arr);

// Set lower array length
arr.length = 2;
console.log(arr);



// Methods
let cars = ['BMW', 'Audi', 'Mercedes'];

// Get and remove last element (pop)
let lastCar = cars.pop();
console.log(lastCar);
console.log(cars);

// Add last position element (push)
let newLength = cars.push('Honda');
console.log(newLength);
console.log(cars);

// Add more than one element (push)
cars.push('Toyota', 'Volkswagen', 'Opel');
console.log(cars);

// Get and remove first element (shift)
let firstCar = cars.shift();
console.log(firstCar);
console.log(cars);

// Add element at start position (unshift)
let newElement = cars.unshift('BMW');
console.log(newElement);
console.log(cars);

// Remove element with splice 
let deletedCars = cars.splice(2, 1);

// Return removed elements in array
console.log(deletedCars);
console.log(cars);

// Add element to array with splice
cars.splice(2, 0, 'Ferrari');
console.log(cars);

// Add and remove elements with splice
cars.splice(1, 3, 'Lamborghini', 'Volvo');
console.log(cars);

// Reverse array
cars.reverse();
console.log(cars);