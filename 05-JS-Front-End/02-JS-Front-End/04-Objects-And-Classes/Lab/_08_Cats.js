function cats(array) {

    class Cat {
        constructor(name, age) {
            this.name = name
            this.age = age    
        }
    
        meow() {
            console.log(`${this.name}, age ${this.age} says Meow`);
        }
    }
    

    for (let obj of array) {
        let data = obj.split(' ')

        let name = data[0]
        let age = data[1]

        let cat = new Cat(name, age)

        cat.meow();
    }

}

