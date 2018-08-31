package dataBase.operations;


import Employees.*;
import Payment.*;

import java.util.ArrayList;

import static dataBase.operations.AddressOperations.*;
import static dataBase.operations.PaymentOperations.*;
import static utilities.Utilities.*;

public abstract class EmployeeOperations {
    public static void addEmployee(ArrayList<Employee> listOfEmployee, int id)
    {
        System.out.print("Entre com o nome: ");
        String name = returnString();

        System.out.print("Entre com o cpf: ");
        String cpf = returnString();

        Address address = newAddress();

        System.out.print("Entre a taxa de servico: ");
        double serviceTax = returnDouble();

        Payment payment = addPayment();

        if(askSomething("Deseja refazer operacao?"))
        {
            addEmployee(listOfEmployee, id);
        }
        else
        {
            if(askSomething("Deseja desfazer operacao?") == false)
            {
                listOfEmployee.add(new Employee(name, cpf, address, id, serviceTax, payment));
            }
            else
                System.out.println("Operacao cancelada!");
        }
    }

    public static void removeById(ArrayList<Employee> listOfEmployee)
    {
        System.out.print("Digite o id do empregado a ser deletado: ");
        int id = returnInt();

        for (Employee employee: listOfEmployee)
        {
            if(employee.getId() == id)
            {
                listOfEmployee.toString();//ver aqui
                if(askSomething("Deseja excluir o empregado? "))
                {
                    if(askSomething("Deseja refazer operacao?"))
                        removeById(listOfEmployee);
                    else
                        listOfEmployee.remove(employee);
                }
                else
                    System.out.println("operacao cancelada");
            }
        }
    }

    public static void newServiceTax(ArrayList<Employee> listOfEmployee)
    {
        System.out.print("Digite o id do empregado a receber uma nova taxa: ");
        int index = getEmployeeById(listOfEmployee);

        if(index != -1)
        {
            System.out.print("Digite o novo valor da taxa: ");
            double pendentServiceTax = returnDouble();
            if(askSomething("Deseja refazer a operacao?"))
            {
                newServiceTax(listOfEmployee);
            }
            else
            {
                if(askSomething("Deseja cancelar a operacao?"))
                    System.out.println("Operacao cancelada!");
                else
                    listOfEmployee.get(index).setPendentServiceTax(pendentServiceTax);
            }
        }
        else
            System.out.println("Operacao cancelada!");
    }

    public  static void alterEmployeeData(ArrayList<Employee> listOfEmployee)
    {
        System.out.print("Digite o id do empregado para alterar dados:");
        int index = getEmployeeById(listOfEmployee);

        if(index != -1)
        {
            System.out.print("Novo nome: ");
            String name = returnString();

            System.out.print("Endereço: ");
            Address address = newAddress();

            System.out.print("Pagamento");
            Payment payment = addPayment();

            Type eType;
            if(askSomething("Deseja incluir no sindicato? "))
                eType = Type.SYNDICATED;
            else
                eType = Type.ORDINARY;

            System.out.print("Taxa de servico: ");
            double serviceTax = returnDouble();

            if(askSomething("Deseja refazer a operacao?"))
                alterEmployeeData(listOfEmployee);
            else
            {
                if(askSomething("Deseja desfazer a operacao?"))
                    System.out.println("Operacao cancelada!");
                else
                {
                    listOfEmployee.get(index).setName(name);
                    listOfEmployee.get(index).setAddress(address);
                    listOfEmployee.get(index).setPayment(payment);
                    listOfEmployee.get(index).setType(eType);
                    listOfEmployee.get(index).setPendentServiceTax(serviceTax);
                }
            }
        }
        else
            System.out.println("Operacao cancelada");


    }

    public static int getEmployeeById(ArrayList<Employee> listOfEmployee)
    {
        int id = returnInt();

        for (Employee employee: listOfEmployee)
        {
            if(employee.getId() == id)
                return listOfEmployee.indexOf(employee);
        }
        return  -1;
    }

}
