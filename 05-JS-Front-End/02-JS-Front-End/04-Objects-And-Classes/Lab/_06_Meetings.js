function meeting(data) {
    let scheduleMeetings = {}

    for (let record of data) {
        let tokens = record.split(' ') 

        let day = tokens[0]
        let name = tokens[1]


        if (day in scheduleMeetings) {
            console.log(`Conflict on ${day}!`);
        } else {
            scheduleMeetings[day] = name
            console.log(`Scheduled for ${day}`);
        }
    }

    for (let obj in scheduleMeetings) {
        console.log(`${obj} -> ${scheduleMeetings[obj]}`);
    }

}
