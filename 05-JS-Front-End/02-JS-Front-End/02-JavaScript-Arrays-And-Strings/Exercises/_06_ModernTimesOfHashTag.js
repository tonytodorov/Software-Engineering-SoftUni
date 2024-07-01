function solve(text) {
    const pattern = /#(?<name>[A-Za-z]+)/g;

    const matches = text.matchAll(pattern);

    for (const match of matches) {
        console.log(match.groups.name);
    }        
}
