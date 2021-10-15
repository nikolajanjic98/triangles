package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OtkaziController implements ActionListener {

    JDialog jd;

    public OtkaziController (JDialog jd) {
        this.jd = jd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jd.dispose();
    }
}
