function solve(arr) {
    arr.sort((a, b) => a.localeCompare(b))
        .forEach((name, index) => {
            console.log(`${index + 1}.${name}`);
        });
}
