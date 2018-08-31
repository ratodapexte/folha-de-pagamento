package utilities;

import java.text.SimpleDateFormat;
import java.util.*;


public abstract class Utilities {
    public static String returnString()
    {
        Scanner scanner = new Scanner(System.in);
        return  scanner.nextLine();
    }

    public static int returnInt()
    {
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            try
            {
                int i = scanner.nextInt();
                return i;
            }catch(InputMismatchException e)
            {
                System.out.println("Entre apenas inteiros!!");
            }
        }
    }

    public static Double returnDouble()
    {
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            try
            {
                double i = scanner.nextDouble();
                return i;
            }catch(InputMismatchException e)
            {
                System.out.println("Entre apenas inteiros!!");
            }
        }
    }

    public static boolean askSomething(String message)
    {
        System.out.print(message + "S para confirmar.");
        String resp = returnString();

        if(resp.toUpperCase().equals("S"))
            return true;

        return false;
    }
    public static String getDate()
    {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return format.format(calendar.getTime());
    }

    public static String getDay()
    {
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat("EEEE", new Locale("en"));
        return df.format(calendar.getTime());
    }

}