package academy.prog;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
   private Date userDate;
   private int delay = 30; // if date of user's message older than this value, => user is not present :)

    public DateUtil() {
    }

    public boolean isUserPresent(Date userDate){
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(userDate);
        calendar.add(Calendar.SECOND, delay);
        Date compareDate = calendar.getTime();

        return currentDate.before(compareDate);
    }


}
