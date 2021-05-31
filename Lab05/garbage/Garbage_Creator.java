package hust.soict.hedspi.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GarbageCreator {
    public static void main(String[] args) {
    	StringBuilder sb = new StringBuilder();
    	String s;
        try {
            File myText = new File("C:\\\\Users\\\\admin\\\\eclipse-workspace\\\\java-test\\\\src\\\\hust\\\\soict\\\\hedspi\\\\garbage\\\\text.txt");
            Scanner myScanner = new Scanner(myText);
            while(myScanner.hasNext()) 
            	sb.append(myScanner.nextInt(2));
            s = sb.toString();
            myScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found or can't read");
            e.printStackTrace();
        }
    }
}
