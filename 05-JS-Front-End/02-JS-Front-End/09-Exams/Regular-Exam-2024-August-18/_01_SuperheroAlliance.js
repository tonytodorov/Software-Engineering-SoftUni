function superheroAlliance(input) {
    class Hero {
        constructor(name, power, energy) {
            this.name = name
            this.power = power
            this.energy = energy
        }
    }
    
    const numberOfHeroes = input.shift()
    let heroes = []
    
    for (let i = 0; i < numberOfHeroes; i++) {
        const hero = input.shift().split('-');
        
        const name = hero[0]
        const power = hero[1]
        const energy = Number(hero[2])
        
        const createdHero = new Hero(name, power, energy)
        heroes.push(createdHero)
    }
    
    let command = input.shift()
    
    while (command !== 'Evil Defeated!') {
        const tokens = command.split(' * ')
        
        const operation = tokens[0]
        const heroName = tokens[1]
        
        if (operation === 'Use Power') {
            const heroSuperpower = tokens[2]
            const energyRequired = Number(tokens[3])
            usePower(heroName, heroSuperpower, energyRequired)
        } else if (operation === 'Train') {
            const trainingEnergy = Number(tokens[2])
            train(heroName, trainingEnergy)
        } else if (operation === 'Learn') {
            const newSuperpower = tokens[2]
            learn(heroName, newSuperpower)
        }
        
        command = input.shift()
    }

    printHeroes()

    function usePower(heroName, heroSuperpower, energyRequired) {
        for (const hero of heroes) {
            if (hero.name === heroName) {
                if (hero.power.includes(heroSuperpower) && hero.energy > energyRequired) {
                    hero.energy -= energyRequired
                    console.log(`${heroName} has used ${heroSuperpower} and now has ${hero.energy} energy!`);
                } else {
                    console.log(`${heroName} is unable to use ${heroSuperpower} or lacks energy!`);
                }
            }                
        }
    }

    function train(heroName, trainingEnergy) {
        for (const hero of heroes) {
            if (hero.name === heroName) {
                if (hero.energy !== 100) {
                    if (hero.energy + trainingEnergy <= 100) {
                        hero.energy += trainingEnergy
                        console.log(`${heroName} has trained and gained ${trainingEnergy} energy!`);
                    } else {
                        const addedEnergy = 100 - hero.energy
                        hero.energy += addedEnergy
                        console.log(`${heroName} has trained and gained ${addedEnergy} energy!`);
                    }
                } else {
                    console.log(`${heroName} is already at full energy!`);
                }
            }                
        }
    }

    function learn(heroName, newSuperpower) {
        for (const hero of heroes) {
            if (hero.name === heroName) {
                if (hero.power.includes(newSuperpower)) {
                    console.log(`${heroName} already knows ${newSuperpower}.`);
                } else {
                    hero.power += `,${newSuperpower}`
                    console.log(`${heroName} has learned ${newSuperpower}!`);
                    
                }
            }                
        }
    }

    function printHeroes() {
        for (const hero of heroes) {
            console.log(`Superhero: ${hero.name}`);
            console.log(`- Superpowers: ${hero.power.split(',').join(', ')}`);
            console.log(`- Energy: ${hero.energy}`);
        }
    }
}
