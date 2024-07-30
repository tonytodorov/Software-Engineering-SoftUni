function toggle() {
    const button = document.getElementsByClassName('button')[0]
    const additionalText = document.getElementById('extra')

    if (additionalText.style.display === 'none') {
        additionalText.style.display = 'block'
        button.innerText = 'Less'
    } else {
        additionalText.style.display = 'none'
        button.innerText = 'More'
    }
}
