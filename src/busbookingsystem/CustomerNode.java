/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busbookingsystem;

/**
 *
 * @author phanh
 */
public class CustomerNode {
    public CustomerNode next;
    public Customer customer;

    public CustomerNode(Customer customer) {
        this.customer = customer;
    }
}