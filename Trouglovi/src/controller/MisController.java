package controller;

import model.CanvasModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MisController implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        CanvasModel.getInstance().setCrtaj(true);
    }
}

