function inventory(arr) {

    class Hero {
        constructor(name, level, items) {
            this.name = name
            this.level = level
            this.items = items
        }
    }

    let heroes = []
    
    for (let i = 0; i < arr.length; i++) {
        const currentHero = arr[i].split(' / ')
        
        const name = currentHero[0]
        const level = Number(currentHero[1])
        const items = currentHero[2]


        const hero = new Hero(name, level, items)
        heroes.push(hero)
    }

    heroes
        .sort((a, b) => a.level - b.level)
        .forEach(hero => console.log(`Hero: ${hero.name}\nlevel => ${hero.level}\nitems => ${hero.items}`))   
}
