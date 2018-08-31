package Payment;

import sales.*;

import java.util.ArrayList;

import static utilities.Utilities.*;

/**
 * Created by alunoic on 24/08/18.
 */
public class Commissioned extends Payment {
    private double salary;
    private double percent;
    private ArrayList<Sales> listOfSellings;

    public Commissioned(String paymentAgenda)
    {
        super(paymentAgenda);
        System.out.print("Digite o valor do salario: ");
        this.salary = returnDouble();
        System.out.print("Digite o percentual de comissao: ");
        this.percent = returnDouble();
    }

    public ArrayList<Sales> getListOfSellings() {
        return listOfSellings;
    }

    public double getSalary() {
        return salary;
    }

    public double getPercent() {
        return percent;
    }

    public void setListOfSellings(ArrayList<Sales> listOfSellings) {
        this.listOfSellings = listOfSellings;
    }
}
