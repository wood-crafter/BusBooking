/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busbookingsystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phanh
 */
public class BusList {
    BusNode head;
    BusNode tail;

    public void add(Bus bus) {
        if (head == null) {
            head = new BusNode(bus);
            tail = head;
        } else {
            tail.next = new BusNode(bus);
        }
    }
    
    public boolean isEmpty(){
        return head == null;
    }

    public void clear(){
        head = tail = null;
    }
    
    private void addFirst(BusNode x) {
        if (isEmpty()) {
            head = tail = x;
        } else {
            x.setNext(head);
            head = x;
        }
    }
    
    public void addFirst(Bus x) {
        addFirst(new BusNode(x));
    }
    
    private void addLast(BusNode x) {
        if (isEmpty()) {
            head = tail = x;
        } else if (head.getNext() == null) {
            tail = x;
            head.setNext(tail);
        } else {
            tail.setNext(x);
            tail = x;
        }
    }
    
    public void addLast(Bus x) {
        addLast(new BusNode(x));
    }
    
    public void removeLast() {
        if (isEmpty()) {
            return;
        }
        BusNode p = head;
        while (p.getNext() != tail) {
            p = p.getNext();
        }
        tail = p;
        tail.setNext(null);
    }

    public int indexOf(String ccode) {
        BusNode node = head;
        int index = 0;

        while (node != null) {
            if (node.bus.bcode.equals(ccode)) {
                return index;
            }

            node = node.next;
            index += 1;
        }

        return -1;
    }
    
    public void visit(BusNode x) {
        if (x != null) {
            System.out.println(x.getInfo());
        }
    }
    
    public void traverse() {
        BusNode p = head;
        while (p != null) {
            visit(p);
            p = p.getNext();
        }
    }
    
    public BusNode search(String xCode) {
        BusNode result = null;
        BusNode p = head;
        if (!isEmpty()) {
            if (head.getInfo().bcode.equals(xCode)&& head.getNext() == null) {
                result = head;
            } else {
                while (p != null) {
                    if (xCode.equals(p.getInfo().bcode)) {
                        result = p;
                        break;
                    }
                    p = p.getNext();
                }
            }
        }
        return result;
    }

    public void delete(String ccode) {
        BusNode node = head;

        if (head.bus.bcode.equals(ccode)) {
            head = head.next;
        }

        while (node != null) {
            if (node.next.bus.bcode.equals(ccode)) {
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

            BusNode node = this.head;

            while (node != null) {
                writer.write(node.bus.toDataString());
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
        BusNode node = head;

        while (node != null) {
            head.bus.display();
            node = node.next;
        }
    }
    
    public void sortByBcode() {
        BusNode pi = head, pj;
        while (pi != null) {
            pj = pi.getNext();
            while (pj != null) {
                if (pi.getInfo().bcode.compareTo(pj.getInfo().bcode) > 0) {
                    Bus temp = pi.getInfo();
                    pi.setInfo(pj.getInfo());
                    pj.setInfo(temp);
                }
                pj = pj.getNext();
            }
            pi = pi.getNext();
        }
    }

    private boolean addAfterPos(int k, BusNode x) {
        boolean result = false;
        BusNode p = head;
        int i = 0;
        while (p != null) {
            if (i == k) {
                x.setNext(p.getNext());
                p.setNext(x);
                result = true;
                break;
            }
            i += 1;
            p = p.getNext();
        }
        return result;
    }

    public boolean addAfterPos(int k, Bus x) {
        boolean result = false;
        if (addAfterPos(k, new BusNode(x))) {
            result = true;
        }
        return result;
    }

    public boolean deletePos(int k) {
        boolean result = false;
        BusNode p = head;
        int i = 0;
        while (p != null) {
            if (i == k - 1) {
                p.setNext(p.getNext().getNext());
                result = true;
                break;
            }
            i += 1;
            p = p.getNext();
        }
        return result;
    }
}
