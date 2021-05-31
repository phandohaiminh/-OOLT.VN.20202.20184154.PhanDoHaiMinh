package hust.soict.hedspi.aims.Aims;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order.Order;

public class DiskTest {
	public static void main(String[] args) {
		Order anOrder = Order.getInstanceOrder();
	    
	    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
	    dvd1.setCategory("Animation");
	    dvd1.setCost(19.95f);
	    dvd1.setDirector("Roger Allers");
	    dvd1.setLength(87);      
	    anOrder.addDigitalVideoDisc(dvd1);
	    
	    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
	    dvd2.setCategory("Science Fiction");
	    dvd2.setCost(24.95f);
	    dvd2.setDirector("Geogre Lucas");
	    dvd2.setLength(124);
	    anOrder.addDigitalVideoDisc(dvd2);
	    
	    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
	    dvd3.setCategory("Animation");
	    dvd3.setCost(18.99f);
	    dvd3.setDirector("John Musker");
	    dvd3.setLength(90);
	    anOrder.addDigitalVideoDisc(dvd3);
	    
	    DigitalVideoDisc dvd4 = new DigitalVideoDisc("Star And Wars");
	    dvd4.setCategory("Animat");
	    dvd4.setCost(18.99f);
	    dvd4.setDirector("John Musker");
	    dvd4.setLength(90);
	    anOrder.addDigitalVideoDisc(dvd4);
	    
	    DigitalVideoDisc[] Disks = anOrder.getItemsOrdered();
 	    int amountDisk = anOrder.getQtyOrdered();
		
 	    System.out.println("Search results: "); 
		for (int i = 0; i < amountDisk; i++) { 
			if (Disks[i].search("Star War")) {
				System.out.println(Disks[i].getTitle()); 
			}
		}
		anOrder.printOrdered();
	}
}
