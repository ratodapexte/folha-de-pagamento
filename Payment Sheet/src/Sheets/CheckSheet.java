package Sheets;

/**
 * Created by alunoic on 24/08/18.
 */
public class CheckSheet {
    private double workedHours;
    private String date;

    public CheckSheet(double workedHours, String date) {
        this.workedHours = workedHours;
        this.date = date;
    }

    public double getWorkedHours() {
        return workedHours;
    }
}
