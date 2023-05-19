package sg.com.simplus.mvms.framework.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String formatDateToDdMmmYyyyHhMm(Date d) {
        System.out.println("formatDateToDdMmmYyyyHhMm d: "+d);
        DateFormat dateDisplay = new SimpleDateFormat("dd MMM yyyy HH:mm");
        if (d != null) {
            System.out.println("formatting dateDisplay d: "+d);
            return dateDisplay.format(d);
        }
        return  "";
    }

    public static String formatDateToYyyMmDdThhMmSs(Date d) {
        System.out.println("formatDateToYyyMmDdThhMmSs d: "+d);
        //DateFormat dateDisplay = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSz"); option for milisecond
        DateFormat dateDisplay = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        if (d != null) {
            System.out.println("formatting dateDisplay d: "+d);
            return dateDisplay.format(d);
        }
        return  "";
    }
}
