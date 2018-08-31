package dataBase;

import Employees.Employee;

import java.util.ArrayList;

public class SystemDataBase {
    private ArrayList<Employee> listOfEmployees = null;
    private int count = 0;
    public ArrayList<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

    public void setListOfEmployees(ArrayList<Employee> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
    }

}
