function loadingBar(percent) {
    const numberOfPercentSymbols = '%'.repeat(percent / 10);
    const numberOfDots = '.'.repeat((100 - percent) / 10);

    if (percent === 100) {
        console.log('100% Complete!');
        console.log(`[${numberOfPercentSymbols}]`);
    } else {
        console.log(`${percent}% [${numberOfPercentSymbols}${numberOfDots}]`);
        console.log('Still loading...');
    }
}