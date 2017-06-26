/*
    Utility to calculate the volume of paint needed to
    paint a room of supplied dimensions.

    Sam Saint-Pettersen, 2017.
*/
package io.stpettersens.paintcalc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class PaintCalcGUI extends JFrame implements ActionListener {
    
    private JTextField txtRoomWidth;
    private JTextField txtRoomLength;
    private JTextField txtRoomHeight;
    private JEditorPane txtResult;
    private float squareMPerLitre;
    private int coats;
    
    public PaintCalcGUI() {
        
        super("Paint Calc");
        initialize();
        
        setSize(260, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        Container ca = getContentPane();
        ca.setBackground(Color.lightGray);
        FlowLayout flm = new FlowLayout();
        ca.setLayout(flm);
        
        JLabel lblRoomWidth = new JLabel("Room width (m):");
        ca.add(lblRoomWidth);
        
        txtRoomWidth = new JTextField("", 10);
        ca.add(txtRoomWidth);
        
        JLabel lblRoomLength = new JLabel("Room length (m):");
        ca.add(lblRoomLength);
        
        txtRoomLength = new JTextField("", 10);
        ca.add(txtRoomLength);
        
        JLabel lblRoomHeight = new JLabel("Room height (m):");
        ca.add(lblRoomHeight);
        
        txtRoomHeight = new JTextField("", 10);
        ca.add(txtRoomHeight);
        
        JButton btnCalc = new JButton("Calculate...");
        btnCalc.addActionListener(this);
        ca.add(btnCalc);
        
        setContentPane(ca);

    }
    
    void initialize() {
        squareMPerLitre = 10.0f;
        coats = 1;
    }

    List<String> calculatePaintNeeded(float squareMPerLitre, Room room, int coats) {
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
        List<String> results = new ArrayList<String>();
        results.add(String.format(
        "Room floor area is %3.1f square metres (w%3.1fm x h%3.1fm)\nand requires %3.1f litre%s of paint.",
        room.getFlSquareMetres(), room.getWidth(), room.getHeight(), requiredPaint, sopl));
        results.add(String.format(
        "\nVolume of room is %3.1f cubic metres (w%3.1fm x l%3.1fm x h%3.1fm).",
        room.getVolCubicMetres(), room.getWidth(), room.getLength(), room.getHeight()));
        results.add(String.format(
        "Coverage is %3.1f square metres per litre and %d coat%s applied.",
        squareMPerLitre, coats, sopc));
        return results;
    }
    
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if(command.equals("Calculate...")) {
            Room room = new Room(
            Float.parseFloat(txtRoomWidth.getText()),
            Float.parseFloat(txtRoomLength.getText()),
            Float.parseFloat(txtRoomHeight.getText()));
            List<String> results = calculatePaintNeeded(10.0f, room, 1);
            JOptionPane.showMessageDialog(this, 
            String.format("%s\n%s\n%s", results.get(0), results.get(1), results.get(2)));
        }
    }
}
