package projectB;

public class Date {

    int month;
    int day;
    int year;


    public Date(int month, int day, int year) {

        if (dateOk(month, day, year)== true) {
            this.year = year;
            this.month = month;
            this.day = day;
        }else{
            this.year = 1900;
            this.month = 1;
            this.day = 1;

        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean dateOk(int month, int day, int year) {
        if (year < 1000 || year > 9999) {
            return false;
        }
        if (day < 1 || day > 31) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Date{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }
}
