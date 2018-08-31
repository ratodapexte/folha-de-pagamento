package dataBase.operations;

import Employees.Employee;
import Payment.*;
import sales.Sales;

import java.util.ArrayList;

import static dataBase.operations.EmployeeOperations.getEmployeeById;
import static utilities.Utilities.*;

public abstract class SalesOperations {
    public static void addSales(ArrayList<Employee> listOfEmployees)
    {
        System.out.print("Digite o id do empregado");
        int index = getEmployeeById(listOfEmployees);

        Employee employee = listOfEmployees.get(index);
        employee.toString();

        if(askSomething("Deseja adicionar o cartao ao empregado?"))
        {
            Payment payment = employee.getPayment();
            if(payment instanceof Commissioned)
            {
                Sales sale = newSales();
                if(askSomething("Deseja refazer a operacao?"))
                    addSales(listOfEmployees);
                else
                    ((Commissioned) payment).getListOfSellings().add(sale);
            }
            else
                System.out.println("Empregado não registra cartao de hora");
        }
        else
            System.out.println("Operacao cancelada!");
    }

    public static Sales newSales()
    {
        System.out.print("Digite o valor da venda: ");
        double price = returnDouble();

        String date = getDate();
        return new Sales(price, date);
    }
}
