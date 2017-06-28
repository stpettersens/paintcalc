/*
    Utility to calculate the volume of paint needed to
    paint a room of supplied dimensions.

    Sam Saint-Pettersen, 2017.
*/

package io.stpettersens.paintcalc;
import java.util.Scanner;

public class PaintCalc {

    /**
     * Get input from user.
     * @param prompt String for the prompt.
     * @return The input received from the user.
    */
    public static String getInput(String prompt) {
        System.out.println(String.format("%s?", prompt));
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    /** 
     * Calculate the amount of paint in litres needed to decorate a room.
     * Also display the area and volume of the room.
     * @param squareMPerLitre Litres of paint required to cover 1 square metre.
     * @param room The room to cover for calculation.
     * @param coats The number of coats of paint to apply.
     * @return The amount of paint required to decorate the room in litres.
    */
    public static float calculatePaintNeeded(float squareMPerLitre, Room room, int coats) {
        float requiredPaint = (room.getFlSquareMetres() * 1.0f) / squareMPerLitre;
        requiredPaint = requiredPaint * coats;
        String sopl = new String();
        String sopc = " is";
        if((requiredPaint > 0.0f && requiredPaint < 1.0f) || requiredPaint > 1.0f) {
            sopl = "s";
        }
        if(coats > 1) {
            sopc = "s are";
        }
        System.out.println(String.format(
        "\nRoom floor area is %3.1f square metres (w%3.1fm x h%3.1fm) and requires %3.1f litre%s of paint.",
        room.getFlSquareMetres(), room.getWidth(), room.getHeight(), requiredPaint, sopl));
        System.out.println(String.format(
        "The volume of the room is %3.1f cubic metres (w%3.1fm x l%3.1fm x h%3.1fm).",
        room.getVolCubicMetres(), room.getWidth(), room.getLength(), room.getHeight()));
        System.out.println(String.format(
        "Coverage is %3.1f square metres per litre and %d coat%s applied.",
        squareMPerLitre, coats, sopc));
        return requiredPaint;
    }

    /**
     * Display program command line usage and exit.
     * @param program The executable name of the program.
    */
    public static void displayUsage(String program) {
        System.out.println("Utility to calculate the volume of paint needed to");
        System.out.println("paint a room of supplied dimensions.");
        System.out.println(String.format("\nUsage: %s [options]", program));
        System.out.println("\nOptions are:");
        System.out.println("-a | --advanced: Allow advanced input such as paint coverage in square metres per litre.");
        System.out.println("-h | --help: Display this usage information and exit.");
        System.exit(0);
    }

    /**
     * Entry method for the program.
     * @param args Command line arguments. Only -h and -a are used.
    */
    public static void main(String[] args) {
        float squareMPerLitre = 10.0f;
        int coats = 1;
        boolean advanced = false;
        if(args.length > 0) {
            for(int i = 0; i < args.length; i++) {
                if(args[i].equals("-h")) {
                    displayUsage("paintcalc");
                }
                if(args[i].equals("-a")) {
                    advanced = true;
                }
            }
        }
        System.out.println("Calculating paint needed...");
        float width = Float.parseFloat(getInput("Room width (m)"));
        float length = Float.parseFloat(getInput("Room length (m)"));
        float height = Float.parseFloat(getInput("Room height (m)"));
        Room room = new Room(width, length, height);
        if(advanced) { // Further options, when -a switch is provided.
            squareMPerLitre = Float.parseFloat(getInput("Paint coverage in square metres per litre"));
            coats = Integer.parseInt(getInput("How many coats"));
        }
        calculatePaintNeeded(squareMPerLitre, room, coats);
    }
}
