package controller;

import gui.KoordinateDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KoordinateController implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        KoordinateDialog kd = new KoordinateDialog();
    }
}
