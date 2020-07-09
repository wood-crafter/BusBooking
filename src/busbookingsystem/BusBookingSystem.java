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
public class BusBookingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CustomerList customerList = new CustomerList();

        customerList.add(new Customer("HE140624", "@PVH", "0366513328"));
        customerList.add(new Customer("SE04849", "@HHP", "0975009271"));
        customerList.add(new Customer("SE1", "@NMQ", "0"));
        customerList.writeToFile("E:\\customers.txt");

        customerList.displayAll(customerList);
    }
}
