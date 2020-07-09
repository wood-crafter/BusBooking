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
public class BusNode {

    public BusNode next;
    public Bus bus;

    public BusNode(Bus bus) {
        this.bus = bus;
    }
    public BusNode getNext(){
        return next;
    }
    public void setNext(BusNode next) {
        this.next = next;
    }
    
    public Bus getInfo() {
        return bus;
    }
    
    public void setInfo(Bus info) {
        this.bus = bus;
    }
}
