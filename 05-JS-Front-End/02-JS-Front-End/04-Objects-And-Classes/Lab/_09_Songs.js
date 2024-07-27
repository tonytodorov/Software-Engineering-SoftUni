function songs(array) {

    class Song {
        constructor(typeList, name, time) {
            this.typeList = typeList
            this.name = name
            this.time = time
        }
    }

    let result = []

    const numberOfSongs = array[0]

    for (let i = 1; i <= numberOfSongs; i++) {
        const currentSong = array[i].split('_')

        const typeList = currentSong[0]
        const name = currentSong[1]
        const time = currentSong[2]

        let song = new Song(typeList, name, time)

        result.push(song)
    }

    const searchedList = array[array.length - 1]

    if (searchedList === 'all') {
        result.forEach(song => console.log(song.name))
    }

    for (let i = 0; i < result.length; i++) {
        if (result[i].typeList === searchedList) {
            console.log(result[i].name);
        }
    }
}
