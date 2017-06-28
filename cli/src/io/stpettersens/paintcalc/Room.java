/*
    Utility to calculate the volume of paint needed to
    paint a room of supplied dimensions.

    Sam Saint-Pettersen, 2017.
*/

package io.stpettersens.paintcalc;

public class Room {
    
    private float width;
    private float length;
    private float height;

    /**
     * Define a room.
     * Logically, this is a volume of width, length and height.
     * @param width the width of the room.
     * @param length the length of the room.
     * @param height the height of the room.
    */
    public Room(float width, float length, float height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }
    /**
     * Return width of the room.
     * @return the width of the room.  
    */
    public float getWidth() {
        return width;
    }
    /**
     * Return length of the room.
     * @return the length of the room.
    */
    public float getLength() {
        return length;
    }
    /**
     * Return height of the room.
     * @return the height of the room.
    */
    public float getHeight() {
        return height;
    }
    /**
     * Return floor area of room in square metres.
     * @return the floor area in metres squared.
    */
    public float getFlSquareMetres() {
        return width * height;
    }
    /**
     * Return volume of room in cubic metres.
     * @return the room volume in metres cubed.
    */
    public float getVolCubicMetres() {
        return width * length * height;
    }
}
