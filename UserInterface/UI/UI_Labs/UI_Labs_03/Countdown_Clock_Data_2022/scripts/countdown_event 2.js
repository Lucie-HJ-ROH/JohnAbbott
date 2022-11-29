// JavaScript Document

/* 1. start up function eventClock()
   2. showDate - returns the current date in the format mm/dd/yyyy
   3. showTime - returns the current time in the format hh:mm:ss AM/PM
   4. calculateDays - returns the number of days left between the current
    date and target date (January 1st of the next year)
*/

/**
 * makes call to showDate and showTime functions
 */
function eventClock() {
    // create a variable that contains the current date and time
    // var/let variable_name 
    // var variable_name = new Date("month day, year hours:minutes:seconds");
    //  let today = new Date('August 10, 2022 14:12:21');
    let today = new Date();
    
    // display the current date and time 
    // object_name1.object_name2.value = express
    document.clockform.txtDateNow.value = showDate(today); 
    // object_name.getElementByID('id_name').value = expression
    document.getElementById('txtTimeNow').value = showTime(today);

    // make (invoke) a call to the calculateDays function
    let days = calculateDays(today);

    // calculate the time left until the New Year

    // display the days left in the txtDaysLeft textbox (textfield)
    document.getElementById('txtDaysLeft').value = Math.floor(days);
    
    // calculate the hours left in the current day
    let hours = (days - Math.floor(days)) * 24;

    // display the number of hours rounded down to the nearest integer 
    document.getElementById('txtHrLeft').value = Math.floor(hours);

    // calculate the minutes left in the current hour
    let minutes = (hours - Math.floor(hours)) * 60;

    // display the number of minutes rounded down to the nearest integer  
    document.getElementById('txtMinLeft').value = Math.floor(minutes);

    // calculate the seconds left the the courrent minute
    let seconds = (minutes - Math.floor(minutes)) * 60;

    // display the number of seconds rounded down to the nearest integer 
    document.getElementById('txtSecLeft').value = Math.floor(seconds);

} // end function eventClock

/**
 * returns the current date in the format mm/dd/yyyy
 * @param {date} dateObj 
 */
function showDate(dateObj) {
    // declare variables that hold month, day, and year values
    let thisDate = dateObj.getDate(); // extrat the date from Date object
    let thisMonth = dateObj.getMonth() + 1; // extrat the montth from Date object
    let thisYear = dateObj.getFullYear(); // extrat the year from Date object

    // return the current date in the format mm/dd/yyyy
    return thisMonth + '/' + thisDate + '/' + thisYear;
} // end function showDate


/**
 * returns the current time in the format hh:mm:ss AM/PM
 * @param {date} dateObj 
 */
function showTime(dateObj) {
    // declare variables that hold hours, minutes, and seconds values
    let thisHour = dateObj.getHours();
    let thisMinute = dateObj.getMinutes();
    let thisSecond = dateObj.getSeconds();

    // change thisHour from 24-hour format to 12-hour format by
    // 1) if thisHour < 12 set variable ampm to 'am',
    // otherwise set it to 'pm'

    let ampm = (thisHour < 12) ? ' am ' : ' pm ';

    // 2) subtract 12 from thisHour variable 
    thisHour = (thisHour > 12) ? (thisHour - 12) : thisHour;

    // 3) if thisHour equals zero, change thisHour to 12
    thisHour = (thisHour == 0) ? 12 : thisHour;

    // add leading zeros to minutes and seconds less than 10
    thisMinute = (thisMinute < 10) ? ('0' + thisMinute) : thisMinute;
    thisSecond = (thisSecond < 10) ? ('0' + thisSecond) : thisSecond;

    // return the current time in the format hh:mm:ss AM/PM
    let currentTime = thisHour + ':' + thisMinute + ':' + thisSecond + ampm;
    return currentTime;
} // end function showTime

/**
 * returns the number of days left between the current
 * date and target date (January 1st of the next year)
 * @param {date} [currentDate = new Date()]  
 */
function calculateDays(currentDate) {
    // create a date object for January 1st of the next year 
    let nextYear = currentDate.getFullYear() + 1;
    
    // set the newYear to the nextYear 
    // insert a temparory date for January 1st
    let newYear = new Date('January 1, 2030');

    newYear.setFullYear(nextYear);

    let events = new Date('September 1, 2022');
    // calculate the difference between the current date and January 1st of the next year

    // convert milliseconds to days
    let numberOfDays = (events - currentDate) / (1000 * 60 * 60 * 24);
    return numberOfDays;

} // end function calculateDays

