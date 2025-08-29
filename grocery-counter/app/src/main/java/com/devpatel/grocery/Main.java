package com.devpatel.grocery;

public class Main {
    public static void main(String[] args) {
        GroceryCounter counter = new GroceryCounter();

        System.out.println(counter.total()); 

        counter.tens();
        counter.tens();
        counter.hundreths();

        System.out.println(counter.total());       
        System.out.println(counter.overflows());   

        for (int i = 0; i < 35; i++) {
            counter.ones();
        }
        System.out.println(counter.total());       
        System.out.println(counter.overflows());  

        for (int i = 0; i < 100; i++) {
            counter.ones();
        }
        System.out.println(counter.total());       
        System.out.println(counter.overflows());  

        counter.clear();
        System.out.println(counter.total());       
        System.out.println(counter.overflows());   
    }
}
