console.log('start');

delayStart(() => {

    console.log('delayed start1')
    console.log('delayed start2')
    console.log('delayed start3')

    delayStart(() => console.log('double delayed start'))

    console.log('delayed start4')
    console.log('delayed start5')
})

console.log('end');

function delayStart(callback) {
    setTimeout(() => {
        callback()
    }, 2000)
    
}


