package Employees;

/**
 * Created by alunoic on 24/08/18.
 */
public class Address {
    private String street;
    private int houseNumber;
    private String complement;
    private String city;
    private String state;
    private String neighborhood;

    public Address(String street, int houseNumber, String complement, String city, String state, String neighborhood) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.neighborhood = neighborhood;
    }
}
