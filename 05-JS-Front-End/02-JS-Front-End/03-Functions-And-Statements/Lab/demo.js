// Function declaration
function log(text) {
    console.log(text);
}

// Function expression
const log2 = function(text) {
    console.log(text);
}

// Arrow function
const log3 = (text) => console.log(text);

// Function invokation
log('Some text');
log2('Some text 2');
log3('Some text 3');

// Default return value
const defaultValue = log('Text');
console.log(defaultValue);

console.log(log('Some'));


// Invoke function from another function
function masterLog(text) {
    log(`1 - ${text}`);
    log2(`2 - ${text}`);
    log3(`3 - ${text}`);
}

masterLog('Ivo');

// Recursion

function countDown(x) {
    console.log(x);
    if (x > 0) {
        countDown(x -1);
    }
}

countDown(10);


// Pass function by argument
function executeOperation(operation, operandA, operandB) {
    const result = operation(operandA, operandB);

    console.log(`The result of this operation is equal to ${result.toFixed(2)}`);
}

function sum (a, b) {
    return a + b;
}

executeOperation(sum, 1, 2);