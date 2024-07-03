function solve(grade) {
    
    const formattedGrade = `(${grade.toFixed(2)})`;

    if (grade < 3.00) {
        console.log(`Fail (2)`);
    } else if (grade < 3.50) {
        console.log(`Poor ${formattedGrade}`);
    } else if (grade < 4.50) {
        console.log(`Good ${formattedGrade}`);
    } else if (grade < 5.50) {
        console.log(`Very good ${formattedGrade}`);
    } else {
        console.log(`Excellent ${formattedGrade}`);
    } 
}

