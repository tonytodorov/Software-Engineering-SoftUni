// Create an object
let person = { name: 'Pesho', age: 20 };



// Create an object with non classis identifier
let person2 = { 'full-name': 'Ivan' };



// Use dot syntax to get property value (accept only standard syntax properties (full-name will not working in this case)
console.log(person.name);



// Use bracket syntax to get property
console.log(person['age']);
console.log(person2['full-name']);



// Create an empty object and dynamically add values
const animal = {};



// Add with dot syntax
animal.name = 'Navcho';



// Add with bracket syntax
animal['min-weight'] = 2;



// Add dynamic name property
let propName = 'type';
animal[propName] = 'Cat';

console.log(animal);



// Get undefined property
console.log(animal.nonExistent);



// Add dynamic name property in the literal
const dynamicPropName = 'fullName';
const person3 = {
    [dynamicPropName]: 'Ivan Ivanov'
};

console.log(person3);


// Multiline object literal (over 2 properties)

let firstName = 'Ivan';
let lastName = 'Ivanov';
let age = 19;

const personInfo = {
    firstName: firstName,
    lastName: lastName,
    age: age,
};

console.log(personInfo);


// Object literal with shorthand syntax
const shortPersonInfo = {
    firstName,
    lastName,
    age,
};

console.log(shortPersonInfo);



// Object destructuring assignment
let person4 = {name: 'Gosho', age: 21, height: 199, eyeColor: 'blue'}

// Delete property
delete person4.name
console.log(person4);

const {age: personAge, ...restPersonInfo} = person4

console.log(personAge);
console.log(restPersonInfo);




// Define method in object literal 
const cat = {
    name: 'Navcho',
    breed: 'Persian',
    age: 9,
    grades: [9, 5, 8, 9],
    owner: {
        name: 'Ivo',
        age: 24,
    },

    // Function expression
    makeSound: function() {
        console.log('Meow...');
    },

    // Arrow function
    sleep: () => console.log('zzzzzzzz'),
}




// Call method
let methodName = 'makeSound';
cat.makeSound();
cat['makeSound']();
cat[methodName]();




// Add method dynamically
cat.eat = function() {
    console.log('Test....');
}

cat.eat();




// Use method notation syntax
const dog = {
    name: 'Sharo',
    breed: 'Cane Corso',
    makeSound() {
        console.log('Wof wof...');       
    },
    ownerName: 'Pesho',
    
}


// Check for method and call
dog.name && dog.makeSound()



// Get all property names of an object
const propertyNames = Object.keys(cat);
console.log(propertyNames); 




// Get all property values of an object
const propertyValues = Object.values(cat);
console.log(propertyValues); 




// Get object key-value pairs
const simpleObject = {
    name: 'Pesho',
    age: 20,
}
const entries = Object.entries(simpleObject);

console.log(entries); 


// Reverser entries
const originalSimpleObject = Object.fromEntries(entries);
console.log(originalSimpleObject);







// JSON
let person1 = {name: 'Pesho', age: 20};



// Convert JS Object to JSON
const data = JSON.stringify(person1);



// Result is STRING NOT OBJECT (if we try to get property age it will return undefined)
console.log(data);
console.log(data.name);



// Format String result
const format = JSON.stringify(person1, null, 2);
console.log(format);




// Convert JSON to JS object
const originalObject = JSON.parse(data); 
console.log(originalObject);






// Associative array

let personName = 'Stamat Petkov'
let personName2 = 'Maria Nikolova'


let phonebook = {
    'Ivan Ivanov': '+359884921512',
    'Georgi Georgiev': '+359824981008',
    [personName2]: '+359824981008',
    'Ivo Papazov': null // if value is null, the result is not found
}

phonebook['Pesho Gerov'] = '+35982284158';
phonebook[personName] = '+35992451250';

console.log(phonebook);



// Check if property name exist (check key)
if (phonebook.hasOwnProperty('Ivo Papazov')) {
    console.log('Name found');
} else {
    console.log('Name not found');
}


// Check if person has value in the phonebook (check value)
if (phonebook['Ivo Papazov']) {
    console.log('Phone found');
} else {
    console.log('Phone not found');
}



// Sort an object (associative array)
let sortedArray = Object
    .entries(phonebook)
    .sort((a, b) => a[0].localeCompare(b[0]))

console.log(sortedArray);

console.log(Object.fromEntries(sortedArray));






// Classes

class Person {
    constructor(firstName, lastName) {
        this.firstName = firstName
        this.lastName = lastName
    }   

    greet(to) {
        console.log(`${this.firstName} says hello to ${to.firstName}`);
    }
}

const fisrtPerson = new Person('Pesho', 'Ivanov')
const secondPerson = new Person('Gosho', 'Petkov')
console.log(fisrtPerson);
console.log(secondPerson);

console.log(typeof fisrtPerson);
console.log(fisrtPerson instanceof Person);

// Call method from class
fisrtPerson.greet(secondPerson5)
secondPerson.greet(fisrtPerson)
