function wildWestAdventure(input) {

    class Hero {
        constructor(heroName, hp, bullets) {
            this.heroName = heroName
            this.hp = hp
            this.bullets = bullets
        }
    }

    const numberOfHeroes = Number(input.shift())
    let heroes = []

    for (let i = 0; i < numberOfHeroes; i++) {
        const hero = input.shift().split(' ')
        const newHero = new Hero(hero[0], Number(hero[1]), Number(hero[2]))

        heroes.push(newHero)
    }

    let command = input.shift()

    while (command !== 'Ride Off Into Sunset') {
        const tokens = command.split(' - ')
    
        const action = tokens[0]
        const characterName = tokens[1]

        if (action === 'FireShot') {
            const target = tokens[2]
            fireShot(characterName, target)
        } else if (action === 'TakeHit') {
            const damage = Number(tokens[2])
            const attacker = tokens[3]
            takeHit(characterName, damage, attacker)
        } else if (action === 'Reload') {
           reloadGun(characterName)
        } else if (action === 'PatchUp') {
            const amount = Number(tokens[2])
            patchUp(characterName, amount)
        }

        command = input.shift()
    }

    printHeroes(heroes)

    function fireShot(characterName, target) {
        for (const hero of heroes) {
            if (hero.heroName === characterName) {
                if (hero.bullets > 0) {
                    hero.bullets -= 1
                    console.log(`${characterName} has successfully hit ${target} and now has ${hero.bullets} bullets!`);
                } else {
                    console.log(`${characterName} doesn't have enough bullets to shoot at ${target}!`);
                }
            }
        }
    }

    function takeHit(characterName, damage, attacker) {
        for (const hero of heroes) {
            if (hero.heroName === characterName) {
                if (hero.hp - damage > 0) {
                    hero.hp -= damage
                    console.log(`${characterName} took a hit for ${damage} HP from ${attacker} and now has ${hero.hp} HP!`);
                } else {
                    heroes = heroes.filter(hero => hero.heroName !== characterName)
                    console.log(`${characterName} was gunned down by ${attacker}!`);
                }
            }
        }
    }

    function reloadGun(characterName) {
        for (const hero of heroes) {
            if (hero.heroName === characterName) {
                if (hero.bullets === 6) {
                    console.log(`${characterName}'s pistol is fully loaded!`);
                } else {
                    const neededBullets = 6 - hero.bullets
                    hero.bullets += neededBullets
                    console.log(`${characterName} reloaded ${neededBullets} bullets!`);
                }
            }
        }
    }


    function patchUp(characterName, amount) {
        for (const hero of heroes) {
            if (hero.heroName === characterName) {
                if (hero.hp === 100) {
                    console.log(`${characterName} is in full health!`);
                } else if (hero.hp + amount < 100) {
                    hero.hp += amount
                    console.log(`${characterName} patched up and recovered ${amount} HP!`);
                }
            }
        }
    }


    function printHeroes(heroes) {
        for (const hero of heroes) {
            console.log(`${hero.heroName}\n HP: ${hero.hp}\n Bullets: ${hero.bullets}`);
        }
    }
}
