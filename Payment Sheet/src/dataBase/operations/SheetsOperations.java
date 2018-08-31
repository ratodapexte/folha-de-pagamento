package dataBase.operations;

import Employees.Employee;
import Payment.Hourly;
import Payment.Payment;
import Sheets.CheckSheet;

import java.util.ArrayList;

import static dataBase.operations.EmployeeOperations.*;
import static utilities.Utilities.*;

public abstract class SheetsOperations {
    public static void addCheeckSheet(ArrayList<Employee> listOfEmployees)
    {
        System.out.print("Digite o id do empregado");
        int index = getEmployeeById(listOfEmployees);

        if(index != -1)
        {
            Employee employee = listOfEmployees.get(index);
            employee.toString();

            if(askSomething("Deseja adicionar o cartao ao empregado?"))
            {
                Payment payment = employee.getPayment();
                if(payment instanceof Hourly)
                {
                    ((Hourly) payment).getListOfCheckSheets().add(newCheckSheet());
                }
                else
                    System.out.println("Empregado não registra cartao de hora");
            }
            else
                System.out.println("Operacao cancelada!");
        }
        else
            System.out.println("Operacao cancelada!");

    }

    public static CheckSheet newCheckSheet()
    {
        System.out.print("Digite o numero de horas trabalhadas: ");
        double hour = returnDouble();

        while (hour <= 0 || hour > 24)
        {
            System.out.print("Digite o numero de horas trabalhadas: ");
            hour = returnDouble();
        }

        String date = getDate();

        return new CheckSheet(hour, date);
    }
}
