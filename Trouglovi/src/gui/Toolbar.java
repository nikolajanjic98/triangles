package gui;

import controller.KoordinateController;
import controller.MisController;
import controller.PresekController;
import controller.UnijaController;

import javax.swing.*;

public class Toolbar extends JToolBar {

    private static Toolbar instance = null;
    JLabel lbl1, lbl2, lbl3, lbl4;
    JButton btn1, btn2, btn3, btn4;

    private Toolbar() {
        super(SwingConstants.VERTICAL);

        lbl1 = new JLabel("Dodavanje trougla preko misa");
        lbl2 = new JLabel("Dodavanje trougla preko koordinata");
        lbl3 = new JLabel("Izracunaj povrsinu unije trouglova");
        lbl4 = new JLabel("Izracunaj povrsinu preseka trouglova");

        btn1 = new JButton("Mis");
        btn2 = new JButton("Koordinate");
        btn3 = new JButton("Unija");
        btn4 = new JButton("Presek");

        btn1.addActionListener(new MisController());
        btn2.addActionListener(new KoordinateController());
        btn3.addActionListener(new UnijaController());
        btn4.addActionListener(new PresekController());

        add(lbl1);
        add(btn1);
        addSeparator();
        add(lbl2);
        add(btn2);
        addSeparator();
        add(lbl3);
        add(btn3);
        addSeparator();
        add(lbl4);
        add(btn4);

        setFloatable(false);
    }

    public static Toolbar getInstance() {
        if (instance == null)
            instance = new Toolbar();

        return  instance;
    }

}
