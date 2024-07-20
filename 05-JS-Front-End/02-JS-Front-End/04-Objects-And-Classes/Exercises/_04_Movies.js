function movies(movies) {

    class Movie {
        constructor(name, director, date) {
            this.name = name
            this.director = director
            this.date = date
        }
    }


    let moviesDatabase = []
    
    for (const movie of movies) {
        const currentMovie = movie.split(' ')

        if (currentMovie.includes('addMovie')) {
            const movieName = currentMovie.slice(1).toString().replaceAll(',', ' ')
            moviesDatabase.push(new Movie(movieName))

        } else if (currentMovie.includes('directedBy')) {

            const indexOf = currentMovie.indexOf('directedBy')
            
            const movieName = currentMovie.slice(0, indexOf).toString().replaceAll(',', ' ')
            const director = currentMovie.slice(indexOf + 1).toString().replaceAll(',', ' ')

            for (const movie of moviesDatabase) {
                if (movie.name === movieName) {
                    movie.director = director 
                }
            }
         
        } else if (currentMovie.includes('onDate')) {
            const indexOf = currentMovie.indexOf('onDate')
            
            const movieName = currentMovie.slice(0, indexOf).toString().replaceAll(',', ' ')
            const date = currentMovie.slice(indexOf + 1).toString().replaceAll(',', ' ')


            for (const movie of moviesDatabase) {
                if (movie.name === movieName) {
                    movie.date = date 
                }
            }
        }
    }

    for (const movie of moviesDatabase) {
        if (movie.name != undefined && movie.director != undefined && movie.date != undefined) {
            console.log(`{"name":"${movie.name}","director":"${movie.director}","date":"${movie.date}"}`);
        }
    }
}
