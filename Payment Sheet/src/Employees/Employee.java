package Employees;

import Payment.*;
import Sheets.*;

import java.util.ArrayList;

/**
 * Created by alunoic on 24/08/18.
 */
    public abstract class Employee {
    private String name;
    private Address address;
    private int id;
    private ArrayList<CheckSheet> listOfCheckSheets;
    private double serviceTax;
    private Payment payment;
}
