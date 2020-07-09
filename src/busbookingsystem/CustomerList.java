/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busbookingsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author phanh
 */
public class CustomerList {

    CustomerNode head;
    CustomerNode tail;

    public void add(Customer customer) {
        if (head == null) {
            head = new CustomerNode(customer);
            tail = head;
        } else {
            tail.next = new CustomerNode(customer);
        }
    }

    public int indexOf(String ccode) {
        CustomerNode node = head;
        int index = 0;

        while (node != null) {
            if (node.customer.ccode.equals(ccode)) {
                return index;
            }

            node = node.next;
            index += 1;
        }

        return -1;
    }

    public void delete(String ccode) {
        CustomerNode node = head;

        if (head.customer.ccode.equals(ccode)) {
            head = head.next;
        }

        while (node != null) {
            if (node.next.customer.ccode.equals(ccode)) {
                node.next = node.next.next;
                return;
            }

            node = node.next;
        }
    }

    boolean writeToFile(String filePath) {
        FileWriter fw = null;

        try {
            fw = new FileWriter(filePath);
            BufferedWriter writer = new BufferedWriter(fw);

            CustomerNode node = this.head;

            while (node != null) {
                writer.write(node.customer.toDataString());
                writer.newLine();
                node = node.next;
            }

            writer.close();

            return true;
        } catch (IOException ex) {
            Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void displayAll(CustomerList customerList) {
        CustomerNode node = head;

        while (node != null) {
            head.customer.display();
            node = node.next;
        }
    }
}