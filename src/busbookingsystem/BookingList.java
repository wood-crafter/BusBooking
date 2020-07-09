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
public class BookingList {

    ArrayList<Booking> bookings = new ArrayList<>();

    public boolean add(Booking booking) {
        if (this.has(booking.bcode)) {
            System.out.println("bCode already exist!");
            System.out.println("Insert unsuccessful");
            return false;
        }

        bookings.add(booking);
        return true;
    }

    public boolean has(String bcode) {
        return this.indexOf(bcode) != -1;
    }

    public int indexOf(String bcode) {
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).bcode.equals(bcode)) {
                return i;
            }
        }

        return -1;
    }
}
