function solve(text) {
    const regex = /[A-Z][a-z]*/g;

    const matches = Array.from(text.matchAll(regex));
    const matchArray = matches.map(match => match[0]);

    const result = matchArray.join(", ");
    console.log(result);
}
