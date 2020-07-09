/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busbookingsystem;

import java.util.ArrayList;

/**
 *
 * @author phanh
 */
public class Customer {

    static Customer fromDataString(String line) {
        String parts[] = line.split("\t");

        return new Customer(parts[0], parts[1], parts[2]);
    }

    String ccode;
    String cusName;
    String phone;

    public Customer(String cCode, String cusName, String phone) {
        this.ccode = cCode;
        this.cusName = cusName;
        this.phone = phone;
    }

    public void display() {
        System.out.println("cCode: " + ccode);
        System.out.println("cusName: " + cusName);
        System.out.println("phone: " + phone);
    }

    public String toDataString() {
        return ccode + "\t" + cusName + "\t" + phone;
    }

}
