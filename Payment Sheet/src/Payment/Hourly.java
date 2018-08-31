package Payment;
import Sheets.CheckSheet;

import java.util.ArrayList;

import static utilities.Utilities.*;

/**
 * Created by alunoic on 24/08/18.
 */
public class Hourly extends Payment {
    private double hour;
    private ArrayList<CheckSheet> listOfCheckSheets;

    public Hourly(String paymentAgenda)
    {
        super(paymentAgenda);
        this.hour = returnDouble();
    }

    public ArrayList<CheckSheet> getListOfCheckSheets() {
        return listOfCheckSheets;
    }

    public double getHour() {
        return hour;
    }

    public void setListOfCheckSheets(ArrayList<CheckSheet> listOfCheckSheets) {
        this.listOfCheckSheets = listOfCheckSheets;
    }
}
