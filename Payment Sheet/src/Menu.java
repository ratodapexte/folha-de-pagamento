import dataBase.SystemDataBase;

import static dataBase.operations.EmployeeOperations.*;
import static dataBase.operations.PaymentOperations.*;
import static dataBase.operations.SalesOperations.*;
import static dataBase.operations.SheetsOperations.*;
import static utilities.Utilities.*;

public class Menu {

    public static void main(String[] args)
    {
        SystemDataBase dataBase = new SystemDataBase();
        int choice, count = 0;

        while(true)
        {
            System.out.print("1 - Adicionar empregado\n2 - Remover empregado\n3 - Remover empregado\n4 - Adicionar " +
                    "cartao de ponto\n5 - Adicionar venda\n6 - Nova taxa de servico\n7 - rodar folha de pagamento" +
                    "\n8 - Alterar agenda de pagamento");
            choice = returnInt();
            switch (choice)
            {
                case 1:
                    addEmployee(dataBase.getListOfEmployees(), count);
                    count ++;
                    break;
                case 2:
                    removeById(dataBase.getListOfEmployees());
                    break;
                case 3:
                    addCheeckSheet(dataBase.getListOfEmployees());
                    break;
                case 4:
                    addSales(dataBase.getListOfEmployees());
                    break;
                case 5:
                    newServiceTax(dataBase.getListOfEmployees());
                    break;
                case 6:
                    alterEmployeeData(dataBase.getListOfEmployees());
                    break;
                case 7:
                    runPayment(dataBase.getListOfEmployees());
                    break;
                case 8:
                    alterAgenda(dataBase.getListOfEmployees());
                    break;

            }
        }

    }
}
