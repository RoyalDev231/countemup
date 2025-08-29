package com.devpatel.grocery;


public class GroceryCounter {

    private int value;          
    private int overflowCount;  

    public GroceryCounter() {
        this.value = 0;
        this.overflowCount = 0;
    }

    public void clear() {
        this.value = 0;
        this.overflowCount = 0;
    }

    public String total() {
        int dollars = value / 100;
        int cents   = value % 100;
        return String.format("$%d.%02d", dollars, cents);
    }

    public int overflows() {
        return overflowCount;
    }

    public void tens() { add(1000); }
    public void ones() { add(100); }
    public void tenths() { add(10); }
    public void hundreths() { add(1); }
    public void hundredths() { add(1); }

    private void add(int delta) {
        int sum = this.value + delta;
        if (sum >= 10000) {
            this.overflowCount += sum / 10000;
            sum = sum % 10000;
        }
        this.value = sum;
    }
}
