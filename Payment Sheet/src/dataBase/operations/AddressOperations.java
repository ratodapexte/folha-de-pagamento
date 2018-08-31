package dataBase.operations;

import Employees.Address;

import static utilities.Utilities.*;

public abstract class AddressOperations {
    public static Address newAddress()
    {
        System.out.print("Entre com o nome da rua");
        String street = returnString();

        System.out.print("Entre com o numero da casa: ");
        int houseNumber = returnInt();

        System.out.print("Entre com o bairro: ");
        String neighborhood = returnString();

        System.out.print("Entre com a cidade: ");
        String city = returnString();

        System.out.print("Entre com o estado: ");
        String state = returnString();

        System.out.print("Entre com complemento do endereco: ");
        String complement = returnString();

        return new Address(street, houseNumber, complement, city, state, neighborhood);
    }
}
