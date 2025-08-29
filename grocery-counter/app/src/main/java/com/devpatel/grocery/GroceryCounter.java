package com.devpatel.grocery;


public class GroceryCounter {

    private int cents; // 0 to 9999 ($0.00 to $99.99)
    private int overflowCount;

    public GroceryCounter() {
        clear();
    }

    /** +$10.00 */
    public void tens() {
        addCents(1000);
    }

    /** +$1.00 */
    public void ones() {
        addCents(100);
    }

    /** +$0.01 */
    public void hundreths() {
        addCents(1);
    }

    
    public String total() {
        int dollars = (cents / 100);
        int hundredths = cents % 100;
        return String.format("$%d.%02d", dollars, hundredths);
    }

   
    public int overflows() {
        return overflowCount;
    }

    
    public void clear() {
        cents = 0;
        overflowCount = 0;
    }

    private void addCents(int amount) {
        cents += amount;
        if (cents >= 10000) { // $100.00
            cents = cents % 10000;
            overflowCount++;
        }
    }
}
        add(1);
    }

    

    
    private void add(int delta) {
        int sum = this.value + delta;

        if (sum >= 10000) {
            
            this.overflowCount += sum / 10000;
            sum = sum % 10000;
        }
        this.value = sum;
    }
}
