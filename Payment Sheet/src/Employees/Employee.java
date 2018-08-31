package Employees;

import Payment.*;
import Sheets.PaymentSheet;

/**
 * Created by alunoic on 24/08/18.
 */
    public class Employee {
    private String name;
    private String cpf;
    private Address address;
    private int id;
    private double serviceTax;
    private double pendentServiceTax;
    private Payment payment;
    private Type type;

    public void setPendentServiceTax(double pendentServiceTax) {
        this.pendentServiceTax = pendentServiceTax;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setServiceTax(double serviceTax) {
        this.serviceTax = serviceTax;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Employee(String name, String cpf, Address address, int id, double serviceTax, Payment payment) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.id = id;
        this.serviceTax = serviceTax;
        this.payment = payment;
        this.pendentServiceTax = 0;
    }

    public Payment getPayment() {
        return payment;
    }

    public double getPendentServiceTax() {
        return pendentServiceTax;
    }

    public double getServiceTax() {
        return serviceTax;
    }

    @Override
    public String toString() {
        return "Nome: " + this.name + "\n";
    }
}
