package liscense;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Activation {
    public static int numberOfDaysLeft(){
        try{
            SimpleDateFormat dates = new SimpleDateFormat("dd-MM-yyyy");
            Date startDate = dates.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            Date endDate = dates.parse("12-08-2021");
            long diff = endDate.getTime() - startDate.getTime();
            int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
            return diffDays;
        }catch (Exception ex){
            return -1;
        }
    }

    public static String daysLeft(){
        int d = numberOfDaysLeft();
        if(d != -1)
            return d + " Days Left!";
        return "Cannot fetch data.";
    }

    public static String generateUID() {
        return "SIRTAMOJIT12AUG";
    }

    public int getDifferenceDays(Date d1, Date d2) {
        int daysdiff = 0;
        long diff = d2.getTime() - d1.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000) + 1;
        daysdiff = (int) diffDays;
        return daysdiff;
    }

    public static boolean isActive(){
        if(numberOfDaysLeft() <= 0)
            return false;
        return true;
    }
}
