function printMatrix(n) {
    let row = '';

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {            
            row += n + ' ';
        }

        console.log(row);
        row = '';
    }
}
