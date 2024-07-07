function btcMining(goldDig) {

    const goldPrice = 67.51;
    const btcPrice = 11949.16;

    let totalMoney = 0;
    let totalBtc = 0;
    let countDays = 0;
    let purchasedDayBtc = 0;

    for (let i = 0; i < goldDig.length; i++) {
        let gold = goldDig[i];
        
        countDays++;
        
        if (countDays % 3 === 0) {
            gold *= 0.7;
        }

        let currentMoney = gold * goldPrice;
        
        totalMoney += currentMoney;

        while (totalMoney >= btcPrice) {
            totalBtc += 1;
            totalMoney -= btcPrice;

            if (totalBtc === 1) {
                purchasedDayBtc = countDays;
            }
        }
    }

    console.log(`Bought bitcoins: ${totalBtc}`);

    if (purchasedDayBtc !== 0) {
        console.log(`Day of the first purchased bitcoin: ${purchasedDayBtc}`);
    }

    console.log(`Left money: ${totalMoney.toFixed(2)} lv.`);

}
