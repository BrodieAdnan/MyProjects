package beans;

public class Date {

    private String year;
    private String month;
    private String day;
    private String hour;
    private String min;

    public Date(String y, String Month, String d, String h, String minutes) {
        year = y;
        month = Month;
        day = d;
        hour = h;
        min = minutes;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getHour() {
        return hour;
    }

    public String getMinutes() {
        return min;
    }
    
    public String completedate (){
        return day + "/" + month + "/" + year + " alle " + hour + ":" + min;
    }
}
