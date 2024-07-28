function subtract() {
    const firstElement = document.getElementById('firstNumber')
    const secondElement = document.getElementById('secondNumber')
    const result = document.getElementById('result')

    const firstNum = Number(firstElement.value)
    const secondNum = Number(secondElement.value)

    const subtractionResult = firstNum - secondNum

    result.innerText = subtractionResult
}
