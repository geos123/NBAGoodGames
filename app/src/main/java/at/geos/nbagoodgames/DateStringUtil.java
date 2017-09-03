package at.geos.nbagoodgames;

import java.util.Calendar;


public class DateStringUtil {

    public String getDateString(int year, int month, int dayOfMonth) {

        String yearString = String.format("%02d", year);
        String monthString = String.format("%02d", month);
        String dayOfMonthString = String.format("%02d", dayOfMonth);

        String dateString = monthString + "%2F" + dayOfMonthString + "%2F" + yearString;
        return dateString;
    }

    public String getYesterdayDateString() {
        final Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, - 1);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);

        return this.getDateString(year, month, dayOfMonth);
    }


    public String getYsterdayDateStringPretty(){
        final Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, - 1);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);

        return this.getDateStringPretty(year, month, dayOfMonth);

    }

    public String getDateStringPretty(int year, int month, int dayOfMonth){
        String dateStringPretty = dayOfMonth + "." + (month+1) + "." + year;
        return dateStringPretty;
    }
}
