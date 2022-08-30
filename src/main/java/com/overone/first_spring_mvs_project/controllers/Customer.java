package com.overone.first_spring_mvs_project.controllers;

public class Customer {
    String name;
    String lastName;
    String date;
    String phone;

    public boolean ifEqual(String number, Customer customer){
        if (number.equals(customer.phone))
            return true;
        return false;
    }
}
