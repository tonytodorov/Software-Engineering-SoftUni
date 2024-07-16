function employees(names) {

    class Employee {
        constructor(name) {
            this.name = name
        }
    }

    for (let name of names) {
        const employee = new Employee(name)
        console.log(`Name: ${employee.name} -- Personal Number: ${employee.name.length}`);
    }

}
