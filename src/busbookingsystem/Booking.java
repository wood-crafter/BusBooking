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
public class Booking {
    String bcode;
    String cCode;
    int seat;

    public Booking(String bCode, String cCode, int seat) {
        this.bcode = bCode;
        this.cCode = cCode;
        this.seat = seat;
    }
    
    public boolean insertToArrayList(ArrayList<Booking> booking){
        for(int i = 0; i < booking.size(); i++){
            if(booking.get(i).bcode.equals(bcode)){
                System.out.println("cCode already exist!");
                System.out.println("Insert unsuccessful");
                return false;
            }
        }
        booking.add(this);
        return true;
    }
    public void display(){
        System.out.println("bCode: " + bcode);
        System.out.println("cCode: " + cCode);
        System.out.println("seat: " + seat);
    }
}
