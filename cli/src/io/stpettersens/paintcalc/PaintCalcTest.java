/*
    Utility to calculate the volume of paint needed to
    paint a room of supplied dimensions.

    Unit test.

    Sam Saint-Pettersen, 2017.
*/

package io.stpettersens.paintcalc;
import org.junit.Test;
import static org.junit.Assert.*;

public class PaintCalcTest {

    /**
     * JUnit test method to test that calculatePaintNeeded
     * method and Room class works as they should.
    */
    @Test
    public void testCalculatePaintNeeded() {
        Room room = new Room(5.0f, 5.0f, 2.0f); // Room of w5.0m x l 5.0m x h2.0m or volume of 50 cubic metres.
        float requiredPaint = PaintCalc.calculatePaintNeeded(10.0f, room, 1);

        float delta = 0.0f;
        assertEquals(1.0f, requiredPaint, delta); // Expected (1.0 litre), actual, delta offset.
        assertEquals(5.0f, room.getWidth(), delta); // Expected (w5.0m), actual, delta offset.
        assertEquals(5.0f, room.getLength(), delta); // Expected (l5.0m), acutal, delta offset.
        assertEquals(2.0f, room.getHeight(), delta); // Expected (h2.0m), actual, delta offset.
        assertEquals(50.0f, room.getVolCubicMetres(), delta); // Expected (50 cubic m.), actual, delta offset.
        assertEquals(10.0f, room.getFlSquareMetres(), delta); // Expected (10 square m.), actual, delta offset.
    }
}
