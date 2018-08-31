import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Test {
        public static void main(String[] args) {
            System.out.println("Hello world!");
            GregorianCalendar calendar = new GregorianCalendar();
            SimpleDateFormat df = new SimpleDateFormat("EEEE", new Locale("en"));
            System.out.println( df.format(calendar.getTime() ) );
        }
}
