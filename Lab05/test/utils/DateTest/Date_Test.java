package hust.soict.hedspi.test.utils.DateTest;

import hust.soict.hedspi.aims.utils.DateUtils.DateUtils;
import hust.soict.hedspi.aims.utils.MyDate.MyDate;

public class DateTest {
	public static void main(String[] args) {
        MyDate aDate = new MyDate("first","February","twenty nineteen");
        MyDate bDate = new MyDate("first","February","twenty twenty");
        MyDate[] dateList = {bDate,aDate}; 
        aDate.print();
        bDate.print();
        System.out.printf("aDate vs bDate is: %d\n", DateUtils.compareMyDate(aDate, bDate));
        System.out.println("Before sorting");
        DateUtils.print(dateList);
        DateUtils.sortMyDate(dateList);
        System.out.println("After sorting");
        DateUtils.print(dateList);
    }
}