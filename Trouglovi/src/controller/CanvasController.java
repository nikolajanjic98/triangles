package controller;

import model.CanvasModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CanvasController extends MouseAdapter {

    public void mousePressed(MouseEvent e) {

        if (e.getButton() == MouseEvent.BUTTON1) {
            if (CanvasModel.getInstance().isCrtaj()) {
                CanvasModel.getInstance().addPoint(e.getPoint());
            }
        }
    }

}