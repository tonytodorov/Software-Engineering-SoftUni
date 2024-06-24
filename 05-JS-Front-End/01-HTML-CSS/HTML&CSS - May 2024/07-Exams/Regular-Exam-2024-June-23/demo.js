// Declare variable
let a = 20;
let b = 10;

// Console print
console.log(a + b);

const pi = 3.14151647;

// Statement
if (a > b) {
    console.log("A is greater than B");
}

// Fuction declaration
function add(first, second) {
    console.log(first + second);
}

// Function invocation
add(3, a);

// Console print with string concatenation
console.log('The result of pi is: ' + pi + '!');

// Console print with string interpolation / template literal
console.log(`The number pi is: ${pi}!`);

add(1, pi);

// Fix number sign
console.log(pi.toFixed(2));
console.log(5.12313531.toFixed(2));

// Single vs double quotes for strings

console.log('Mr. Pesho');
console.log("Pesho");

// Switch statement

const name = 'Test';

switch (name) {
    case 'Start':
        console.log('Start');
        break;
    case 'End':
        console.log('End');
        break;
    default:
        console.log('Victory');;
}

// Truthy and falsy values
if (name) {
    console.log('There is Test');
}
