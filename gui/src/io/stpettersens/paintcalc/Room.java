/*
    Utility to calculate the volume of paint needed to
    paint a room of supplied dimensions.

    Sam Saint-Pettersen, 2017.
*/
package io.stpettersens.paintcalc;

class Room {
    
    private float width;
    private float length;
    private float height;

    Room(float width, float length, float height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }
    public float getWidth() {
        return width;
    }
    public float getLength() {
        return length;
    }
    public float getHeight() {
        return height;
    }
    public float getFlSquareMetres() {
        return width * height;
    }
    public float getVolCubicMetres() {
        return width * length * height;
    }
}
