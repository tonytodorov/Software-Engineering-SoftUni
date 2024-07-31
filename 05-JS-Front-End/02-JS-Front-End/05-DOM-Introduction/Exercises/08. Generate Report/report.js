function generateReport() {
    const checkBoxes = document.querySelectorAll('table thead tr th input[type=checkbox]')
    const trElements = document.querySelectorAll('table tbody tr')
    console.log(checkBoxes);
    console.log(trElements);

    for (let i = 0; i < checkBoxes.length; i++) {
        const element = checkBoxes[i];

        if (element.checked === true) {

        }
        
    }
}
