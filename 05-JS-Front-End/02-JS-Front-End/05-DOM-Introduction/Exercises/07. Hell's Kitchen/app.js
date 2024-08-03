function solve() {
    document.querySelector('#btnSend').addEventListener('click', onClick);
    
    function onClick () {
        const textAreaInputElement = document.querySelector('#inputs textarea')
        const bestRestaurant = document.querySelector('#bestRestaurant p')
        const bestEmployees = document.querySelector('#workers p ')
        const restaurantData = JSON.parse(textAreaInputElement.value)

        let restaurantInfo = {}
        let restaurantEmployees = {}
        let bestAverageSalaries = 0
        let bestSalary = 0

        restaurantData.forEach(restaurant => {
            const data = restaurant.split(/[-,]/).map(item => item.trim());

            let currentRestaurantInfo = {}
            let currentRestaurantEmployees = {}
            for (let i = 1; i < data.length; i++) {
                const element = data[i].split(' ');

                const name = element[0]
                const salary = Number(element[1])

                currentRestaurantEmployees[name] = salary

            }

            let totalSalary = 0
            let countEmp = 0
            let currentBestSalary = 0

            for (const emp in currentRestaurantEmployees) {
                const salary = currentRestaurantEmployees[emp];
                if (salary > currentBestSalary) {
                    currentBestSalary = salary
                }
                totalSalary += salary   
                countEmp++
            }

            let currentAverage = (totalSalary / countEmp).toFixed(2)
            currentRestaurantInfo[data[0]] = currentAverage
            
            if (currentAverage > bestAverageSalaries) {
                restaurantInfo = currentRestaurantInfo
                restaurantEmployees = currentRestaurantEmployees
                bestAverageSalaries = currentAverage
                bestSalary = currentBestSalary
            }
        });

        const bestRestaurantInfo = Object.entries(restaurantInfo)

        bestRestaurant.textContent = `Name: ${bestRestaurantInfo[0][0]} Average Salary: ${bestRestaurantInfo[0][1]} Best Salary: ${bestSalary.toFixed(2)}`
        bestEmployees.textContent = `${printEmployees()}`



        function printEmployees() {
            let result = ''
            let employees = Object.entries(restaurantEmployees)
            
            employees.sort((a, b) => b[1] - a[1])
            console.log(employees);

            for (const emp of employees) {
                const name = emp[0]
                const salary = emp[1]

                result += `Name: ${name} With Salary: ${salary} `
            }

            return result
        }
    }
}
