package Payment;

import static utilities.Utilities.returnDouble;

/**
 * Created by alunoic on 24/08/18.
 */
public class Salaried extends Payment {
    private double salary;

    public Salaried(String paymentAgenda)
    {
        super(paymentAgenda);
        this.salary = returnDouble();
    }

    public double getSalary() {
        return salary;
    }
}
