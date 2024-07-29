function calc() {
    const numElement1 = document.getElementById('num1') 
    const numElement2 = document.getElementById('num2')
    const sumElements = document.getElementById('sum')

    const firstNum = Number(numElement1.value)
    const secondNum = Number(numElement2.value)

    sumElements.value = firstNum + secondNum
}
