package controller;

import gui.KoordinateDialog;
import model.CanvasModel;
import view.CanvasView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DodajController implements ActionListener {

    KoordinateDialog kd;

    public DodajController (KoordinateDialog kd) {
        this.kd = kd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
        ArrayList<Point> points = new ArrayList<>();
        Point A, B, C;
        A = new Point(Integer.parseInt(kd.getXA()), Integer.parseInt(kd.getYA()));
        B = new Point(Integer.parseInt(kd.getXB()), Integer.parseInt(kd.getYB()));
        C = new Point(Integer.parseInt(kd.getXC()), Integer.parseInt(kd.getYC()));

        Dimension size = CanvasView.getInstance().getSize();

        if (A.x < 0 || A.x >= size.width || B.x < 0 || B.x >= size.width || C.x < 0 || C.x >= size.width ||
            A.y < 0 || A.y >= size.height || B.y < 0 || B.y >= size.height || C.y < 0 || C.y >= size.height)
            throw new Exception("Koordinate trougla su van canvasa");

        points.add(A);
        points.add(B);
        points.add(C);

        CanvasModel.getInstance().addTriangle(points);
        kd.dispose();
        }
        catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Unesite validne koordinate", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
