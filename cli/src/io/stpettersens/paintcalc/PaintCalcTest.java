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

    @Test
    public void testCalculatePaintNeeded() {
        Room room = new Room(5.0f, 5.0f, 2.0f);
        float requiredPaint = PaintCalc.calculatePaintNeeded(10.0f, room, 1);

        float delta = 0.0f;
        assertEquals(1.0f, requiredPaint, delta);
        assertEquals(5.0f, room.getWidth(), delta);
        assertEquals(5.0f, room.getLength(), delta);
        assertEquals(2.0f, room.getHeight(), delta);
    }
}
