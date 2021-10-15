package gui;

import controller.DodajController;
import controller.OtkaziController;

import javax.swing.*;
import java.awt.*;

public class KoordinateDialog extends JDialog {

    JLabel lbl0, lblX, lblY, lblA, lblB, lblC;
    JTextField tfXA, tfXB, tfXC, tfYA, tfYB, tfYC;
    JButton btnDodaj, btnOtkazi;

    public KoordinateDialog () {
        lbl0 = new JLabel(" ");
        lbl0.setHorizontalAlignment(JLabel.CENTER);

        lblX = new JLabel("X");
        lblX.setHorizontalAlignment(JLabel.CENTER);
        lblY = new JLabel("Y");
        lblY.setHorizontalAlignment(JLabel.CENTER);

        lblA = new JLabel("A");
        lblA.setHorizontalAlignment(JLabel.CENTER);
        lblB = new JLabel("B");
        lblB.setHorizontalAlignment(JLabel.CENTER);
        lblC = new JLabel("C");
        lblC.setHorizontalAlignment(JLabel.CENTER);

        tfXA = new JTextField("Ax"); tfYA = new JTextField("Ay");
        tfXB = new JTextField("Bx"); tfYB = new JTextField("By");
        tfXC = new JTextField("Cx"); tfYC = new JTextField("Cy");

        tfXA.setHorizontalAlignment(JTextField.CENTER); tfYA.setHorizontalAlignment(JTextField.CENTER);
        tfXB.setHorizontalAlignment(JTextField.CENTER); tfYB.setHorizontalAlignment(JTextField.CENTER);
        tfXC.setHorizontalAlignment(JTextField.CENTER); tfYC.setHorizontalAlignment(JTextField.CENTER);

        btnDodaj = new JButton("Dodaj");
        btnDodaj.addActionListener(new DodajController(this));
        btnOtkazi = new JButton("Otkazi");
        btnOtkazi.addActionListener(new OtkaziController(this));

        JPanel jp = new JPanel();
        GridLayout gl = new GridLayout(4, 3, 10, 10);

        jp.setLayout(gl);

        jp.add(lbl0); jp.add(lblX); jp.add(lblY);
        jp.add(lblA); jp.add(tfXA); jp.add(tfYA);
        jp.add(lblB); jp.add(tfXB); jp.add(tfYB);
        jp.add(lblC); jp.add(tfXC); jp.add(tfYC);

        validate();

        JPanel jp2 = new JPanel();
        BoxLayout hbx = new BoxLayout(jp2, BoxLayout.X_AXIS);
        jp2.setLayout(hbx);

        jp2.add(btnDodaj);
        jp2.add(new JLabel("      "));
        jp2.add(btnOtkazi);

        JPanel jp3 = new JPanel();
        BoxLayout vbx = new BoxLayout(jp3, BoxLayout.Y_AXIS);
        jp3.setLayout(vbx);

        jp3.add(jp);
        jp3.add(jp2);

        add(jp3);

        validate();

        setTitle("Dodavanje trougla preko koordinata");
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(300, 250);
    }

    public String getXA() {
        return tfXA.getText();
    }

    public String getXB() {
        return tfXB.getText();
    }

    public String getXC() {
        return tfXC.getText();
    }

    public String getYA() {
        return tfYA.getText();
    }

    public String getYB() {
        return tfYB.getText();
    }

    public String getYC() {
        return tfYC.getText();
    }
}
