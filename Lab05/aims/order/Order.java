package hust.soict.hedspi.aims.order.Order;

import java.util.Random;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.hedspi.aims.utils.MyDate.MyDate;

public class Order {
    public static final int MAX_LIMITTED_ORDERS = 5;
    public static final int MAX_NUMBERS_ORDERED = 10;
    
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    
    private static int nbOrders = 0;
    private int qtyOrdered = 0;
    private float ttCost;
    private MyDate dateOrdered;

    private Order() {
        dateOrdered = new MyDate();
    }
    
    public DigitalVideoDisc[] getItemsOrdered(){
    	return this.itemsOrdered;
    }
    public static Order getInstanceOrder() {
        if(nbOrders < MAX_LIMITTED_ORDERS)
        {
            nbOrders++;
            Order newOrder = new Order();
            return newOrder;
        }
        else {
            System.out.println("The numbers of orders is almost max.");
            return null;
        }
            
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED){
            this.itemsOrdered[this.qtyOrdered++] = disc;
            System.out.printf("The disc %s has been added.\n",disc.getTitle());
        }
        else System.out.println("The order is almost full.");
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc ... dvdlist) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The order is almost full.");
            return;
        }
        
        for (DigitalVideoDisc dvdlist1 : dvdlist) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                this.itemsOrdered[this.qtyOrdered++] = dvdlist1;
                System.out.printf("The disc %s has been added.\n", dvdlist1.getTitle());
            } else {
                System.out.printf("The disc %s cannot be added.\n", dvdlist1.getTitle());
            }
        }
    }
            
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED -1){
            this.itemsOrdered[this.qtyOrdered++] = dvd1;
            this.itemsOrdered[this.qtyOrdered++] = dvd2;
            System.out.printf("The disc %s has been added.\n",dvd1.getTitle());
            System.out.printf("The disc %s has been added.\n",dvd2.getTitle());
        }
        else if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            this.itemsOrdered[this.qtyOrdered++] = dvd1;
            System.out.printf("The disc %s has been added.\n",dvd1.getTitle());
            System.out.printf("The disc %s cannot be added.\n",dvd2.getTitle());
    }
        else System.out.println("The order is almost full.");
    }
            
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered > 0 ){
            for(int i = 0; i < qtyOrdered; i++){
                if(itemsOrdered[i] == disc) 
                {
                    for(int j=i; j<qtyOrdered-1; j++)
                        itemsOrdered[j] = itemsOrdered[j+1];
                    itemsOrdered[--qtyOrdered] = null;
                    break;
                }
            }
            System.out.printf("The disc %s has been removed.\n",disc.getTitle());
        }
        else System.out.println("The order is almost empty.");
    }
    
    public float totalCost() {
        ttCost = 0;
        for(int i = 0; i < qtyOrdered; i++){
            ttCost += itemsOrdered[i].getCost();
        }
        return ttCost;
    }
    
    public void printOrdered() {
    	DigitalVideoDisc disc = this.getALuckyItem();
        System.out.println("****Order****");
        System.out.print("Date: ");
        dateOrdered.print();
        System.out.print("\nOrdered Items:\n");
        
        for(int i = 0; i < qtyOrdered; i++) {
    		System.out.printf("%d. DVD - " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() +
                " - " + itemsOrdered[i].getDirector() + " - %d: %.2f$\n",i + 1, itemsOrdered[i].getLength(), itemsOrdered[i].getCost());
        }
        System.out.printf("Lucky item: ");
        System.out.printf("DVD - " + disc.getTitle() + " - " + disc.getCategory() +
                " - " + disc.getDirector() + " - %d: %.2f$\n", disc.getLength(), disc.getCost());
        System.out.printf("Total cost before free item: %.2f$\n", totalCost());
        System.out.printf("Total cost after free item: %.2f$\n", totalCost() - disc.getCost());
    }
    
    public DigitalVideoDisc getALuckyItem() {
    	Random rd = new Random();
    	int number = rd.nextInt(this.qtyOrdered - 1);
    	return itemsOrdered[number];
    }
}