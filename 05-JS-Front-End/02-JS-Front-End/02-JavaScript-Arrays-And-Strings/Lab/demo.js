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



// Mutating Methods (change the original array)

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





// Non-Mutating methods (not change the original array)
let nums = [13, 42, 69, 73, 89, 13];


// Join array as string
let string = nums.join(', ');
console.log(string);



// Slice (NOT SPLICE)
let middleNumbers = nums.slice(1, 3);
console.log(middleNumbers);

// Create array copy (without slice bound)
let shallowCopy = nums.slice();
console.log(shallowCopy);



// Includes (check if element exist in array)
let isIncluded = nums.includes(13);
console.log(isIncluded);

// Check if element exist after certain index
let isNumIncluded = nums.includes(13, 2);
console.log(isNumIncluded);



// IndexOf (find element by index)
let numIndex = nums.indexOf(73);
console.log(numIndex);

// Return -1 when element not found
let dummyNum = nums.indexOf(4125);
console.log(dummyNum);



// Find (return specific element)
let findNum = nums.find(num => num === 13);
console.log(findNum);

// Find all indexes of 13

let tIndex = nums.indexOf(13);

while (tIndex >= 0) {
    console.log(tIndex);
    tIndex = nums.indexOf(13, tIndex + 1);
}



// ForEach
cars.forEach(car => console.log(car));



// Map
let randomNumbers = [1, 2, 3, 4, 5];
let doubleNumbers =  randomNumbers.map(number => number * 2);
console.log(randomNumbers);
console.log(doubleNumbers);



// Filter
let oddNumbers = randomNumbers.filter(number => number % 2 !== 0);
console.log(oddNumbers);


// Reduce method (for homework)
