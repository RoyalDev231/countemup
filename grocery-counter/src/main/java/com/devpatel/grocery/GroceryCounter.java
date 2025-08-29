package com.devpatel.grocery;

/**
 * GroceryCounter represents a 4-digit dollar-and-cents counter:
 * ABCD  -> displays as $AB.CD
 * Range is 0000..9999 (i.e., $00.00 .. $99.99).
 *
 * Increment methods add the corresponding amount and wrap modulo 10000.
 * Each wrap increments the overflow counter.
 */
public class GroceryCounter {

    private int value;          // 0..9999
    private int overflowCount;  // number of wraps

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
