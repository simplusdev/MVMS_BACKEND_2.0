package sg.com.simplus.mvms.framework.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date parseDateFromYyyyMmDdTHhMmSs(String sdate){
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        if(sdate!=null){
            try {
                return sdf.parse(sdate);

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public static Date parseDateFromDdMmYyyyHhMmSs(String sdate){
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        if(sdate!=null){
            try {
                return sdf.parse(sdate);

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public static Date parseDateFromDdMmYyyyHhMm(String sdate){
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        if(sdate!=null){
            try {
                return sdf.parse(sdate);

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
    public static String formatDateToDdMmmYyyyHhMm(Date d) {
       // System.out.println("formatDateToDdMmmYyyyHhMm d: "+d);
        DateFormat dateDisplay = new SimpleDateFormat("dd MMM yyyy HH:mm");
        if (d != null) {
           // System.out.println("formatting dateDisplay d: "+d);
            return dateDisplay.format(d);
        }
        return  "";
    }

    public static String formatDateToYyyMmDdThhMmSs(Date d) {
       // System.out.println("formatDateToYyyMmDdThhMmSs d: "+d);
        //DateFormat dateDisplay = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSz"); option for milisecond
        DateFormat dateDisplay = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        if (d != null) {
            //System.out.println("formatting dateDisplay d: "+d);
            return dateDisplay.format(d);
        }
        return  "";
    }
}
