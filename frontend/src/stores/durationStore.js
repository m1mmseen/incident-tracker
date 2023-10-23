export const duration = {

    calculate(unix) {
        const unixTimestamp = unix;

        const milliseconds = Date.now() ;

        const difference = milliseconds - unixTimestamp;

        const days = Math.floor(difference/1000/60/60/24)
        const hours = Math.floor(difference/1000/60/60)
        const minutes = Math.floor(difference/1000/60)
        const seconds = Math.floor(difference/1000)


        console.log("unixTimestamp: ", unixTimestamp, " unix: ", unix)

        console.log("difference: ", difference, " days: ", days, " hours:", hours, " minutes", minutes, " seconds: ", seconds)

        if (days === 1) {
            return days + " day ago";
        } else if (days > 1) {
            return days + " days ago";
        } else if (hours === 1) {
            return hours + " hour ago";
        } else if (hours > 1) {
            return hours + " hours ago";
        } else if (minutes === 1) {
            return minutes + " minute ago";
        } else if (minutes > 1) {
            return minutes + " minutes ago";
        } else if (seconds > 0) {
            return seconds + " seconds ago";
        }
        return "now";
    }

}