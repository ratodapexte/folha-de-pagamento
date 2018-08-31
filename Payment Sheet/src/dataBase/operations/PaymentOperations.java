package dataBase.operations;

import Employees.*;
import Payment.*;
import Sheets.CheckSheet;
import sales.Sales;

import java.util.ArrayList;

import static dataBase.operations.EmployeeOperations.getEmployeeById;
import static utilities.Utilities.*;

public abstract class PaymentOperations {
        public static Payment addPayment()
        {
            System.out.print("Escolha o tipo de pagamento: ");
            int choice = returnInt();
            while(choice > 0 && choice < 4)
            {
                System.out.print("Escolha o tipo de pagamento: ");
                choice = returnInt();
            }
            switch (choice)
            {
                case 1:
                    return newPayment(choice);
                case 2:
                    return newPayment(choice);
                case 3:
                    return newPayment(choice);
            }
            return null;
        }

        public static Payment newPayment(int choice)
        {
            switch (choice)
            {
                case 1:
                    double hour = returnDouble();
                    return new Hourly(hourlyAndCommisionedAgenda());
                case 2:
                    return new Commissioned(hourlyAndCommisionedAgenda());
                case 3:
                    return new Salaried(salariedAgenda());//trabalhar aqui
            }
            return null;
        }

        public static String hourlyAndCommisionedAgenda()
        {
            System.out.printf("Escolha os dias da semana:%n 1 - Segunda%n2 - Terca%n3 - Quarta%n4 - Quinta%n" +
                    "5 - Sexta%n");
            int choice = returnInt();
            System.out.printf("Escolha os dias da semana:%n 1 - Segunda%n2 - Terca%n3 - Quarta%n4 - Quinta%n" +
                        "5 - Sexta%n");
                choice = returnInt();

            String day;

            switch(choice)
            {
                case 1:
                    day = "MONDAY";
                    break;
                case 2:
                    day = "TUESDAY";
                    break;
                case 3:
                    day = "WENSDAY";
                    break;
                case 4:
                    day = "THURSDAY";
                    break;
                case 5:
                    day = "FRYDAY";
                    break;
                default:
                    day = "FRYDAY";
                    break;
            }
            return day;
        }

        public static String salariedAgenda()
        {
            System.out.printf("Escolha um dia de 1 - 10 para receber o pagamento: ");
            int choice = returnInt();
            String day;

            if(choice > 0 || choice < 11)
            {
                day = "" + choice;
            }
            else
            {
                System.out.println("Pagamento padrao para o ultimo dia do mes");
                return "$";
            }
            return day;
        }

        public static void runPayment(ArrayList<Employee> listOfEmployee)
        {
            String day = getDay().toUpperCase();
            String date = getDate();
            String[] dayInfo = date.split("/");
            if (dayInfo[1].equals("2") && dayInfo[0].equals("28"))
                dayInfo[0] = "$";
            else if(dayInfo[0].equals("30"))
                dayInfo[0] = "$";

            double salary, finalSalary;

            for (Employee employee: listOfEmployee) {
                Payment payment = employee.getPayment();
                if(payment instanceof Salaried)
                {
                    if(payment.getPaymentAgenda().equals(dayInfo[0]))
                    {
                        salary = ((Salaried) payment).getSalary();
                        finalSalary = salary - (salary*employee.getServiceTax());
                        System.out.printf("Nome: " + employee.getName() + "%nSalario: " + finalSalary);
                    }
                }
                else if(payment instanceof Commissioned)
                {
                    salary = calcCommissioned(((Commissioned) payment));
                    finalSalary = salary - (salary * employee.getServiceTax());
                    System.out.println("Nome: " + employee.getName() + "%nSalario: " + finalSalary);
                }
                else
                {
                    if(payment.getPaymentAgenda().equals(day))
                    {
                        salary = calcHourly(((Hourly) payment));
                        finalSalary = salary - (salary * employee.getServiceTax());
                        System.out.println("Nome: " + employee.getName() + "%nSalario: " + finalSalary);
                    }
                }

                if(employee.getPendentServiceTax() != 0)
                {
                    employee.setServiceTax(employee.getPendentServiceTax());
                    employee.setPendentServiceTax(0);
                }
            }
        }

        public static double calcCommissioned(Commissioned payment)
        {
            double salary = 0;

            ArrayList<Sales> listOfSales = payment.getListOfSellings();
            double percent = payment.getPercent();

            for (Sales sale: listOfSales)
                salary += percent * sale.getPrice();

            listOfSales.clear();
            payment.setListOfSellings(listOfSales);

            return salary;
        }

        public static double calcHourly(Hourly payment)
        {
            double salary = 0;

            ArrayList<CheckSheet> listOfCheckSheets = payment.getListOfCheckSheets();

            for (CheckSheet checkSheet: listOfCheckSheets) {
                salary += checkSheet.getWorkedHours() * payment.getHour();
            }

            listOfCheckSheets.clear();
            payment.setListOfCheckSheets(listOfCheckSheets);

            return salary;
        }

        public static  void alterAgenda(ArrayList<Employee> listOfEmployee)
        {
            System.out.print("Digite o id do empregado: ");
            int index = getEmployeeById(listOfEmployee);

            if(index != -1) {
                if (askSomething("Deseja refazer a operacao?"))
                    alterAgenda(listOfEmployee);
                else {
                    if (askSomething("Deseja desfazer a operacao?"))
                        System.out.println("Operacao cancelada!");
                    else {
                        listOfEmployee.get(index).setPayment(addPayment());
                    }
                }
            }
            else
                System.out.println("Operacao cancelada!");
        }
}
