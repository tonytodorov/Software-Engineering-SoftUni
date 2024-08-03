function attachEventsListeners() {
    const buttons = document.querySelectorAll('input[type=button]')
    const textInput = document.querySelectorAll('input[type=text]')

        buttons.forEach(button => {
        button.addEventListener('click', (e) => {
            const textID = e.target.id.replace('Btn', '');
            const value = document.getElementById(textID).value
            
            debugger
            if (textID === 'days') {
                textInput[1].value = value * 24 
                textInput[2].value = value * 1440
                textInput[3].value = value * 86400
            } else if (textID === 'hours') {
                textInput[0].value = value / 24
                textInput[2].value = value * 60
                textInput[3].value = value * 3600 
            } else if (textID === 'minutes') {
                textInput[0].value = value / 1440 
                textInput[1].value = value / 60
                textInput[3].value = value * 60
            } else if (textID === 'seconds') {
                textInput[0].value = value / 86400
                textInput[1].value = value / 3600
                textInput[2].value = value / 60
            }
          
        })
    })
}
