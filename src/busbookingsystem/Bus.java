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
public class Bus {
    String bcode;
    String busName;
    int seat;
    int booked;
    double departTime;
    double arrivalTime;

    public Bus(String bCode, String busName, int seat, int booked, double departTime, double arrivalTime) {
        this.bcode = bCode;
        this.busName = busName;
        this.seat = seat;
        this.booked = booked;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
    }
    
    public boolean insertToArrayList(ArrayList<Bus> buses){
        for(int i = 0; i < buses.size(); i++){
            if(buses.get(i).bcode.equals(bcode)){
                System.out.println("bCode already exist!");
                System.out.println("Insert unsuccessful");
                return false;
            }
        }
        buses.add(this);
        return true;
    }
    
    public void display(){
        System.out.println("bcode: " + bcode);
        System.out.println("bus name:" + busName);
        System.out.println("seat: " + seat);
        System.out.println("booked: " + booked);
        System.out.println("depart time: "+ departTime);
        System.out.println("arrival time: " + arrivalTime);
    }
    
    public String toDataString() {
        return bcode + "\t" + busName + "\t" + seat + "\t" + booked + "\t" + departTime + "\t" + arrivalTime;
    }
}
