package com.devpatel.grocery;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroceryCounterTest {

    @Test
    void exampleFlow_matchesPrompt() {
        GroceryCounter counter = new GroceryCounter();

        // $0.00 and 0 overflows to start
        assertEquals("$0.00", counter.total());
        assertEquals(0, counter.overflows());

        counter.tens();
        counter.tens();
        counter.hundreths();

        assertEquals("$20.01", counter.total());
        assertEquals(0, counter.overflows());

        for (int i = 0; i < 35; i++) {
            counter.ones();
        }
        assertEquals("$55.01", counter.total());
        assertEquals(0, counter.overflows());

        for (int i = 0; i < 100; i++) {
            counter.ones();
        }
        assertEquals("$55.01", counter.total());
        assertEquals(1, counter.overflows());

        counter.clear();
        assertEquals("$0.00", counter.total());
        assertEquals(0, counter.overflows());
    }

    @Test
    void multipleOverflowsAccumulateCorrectly() {
        GroceryCounter c = new GroceryCounter();

        // Ten times $10 = $100 -> exactly one wrap to $0.00
        for (int i = 0; i < 10; i++) c.tens();
        assertEquals("$0.00", c.total());
        assertEquals(1, c.overflows());

        // Another $100 -> another wrap
        for (int i = 0; i < 10; i++) c.tens();
        assertEquals("$0.00", c.total());
        assertEquals(2, c.overflows());
    }

    @Test
    void formattingHandlesLeadingZeros() {
        GroceryCounter c = new GroceryCounter();
        for (int i = 0; i < 5; i++) c.ones();       // $5.00
        for (int i = 0; i < 9; i++) c.hundreths();  // +$0.09 => $5.09
        assertEquals("$5.09", c.total());
    }
}
