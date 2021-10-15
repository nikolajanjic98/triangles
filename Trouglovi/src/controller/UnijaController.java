package controller;

import model.CanvasModel;
import view.CanvasView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnijaController implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        Dimension size = CanvasView.getInstance().getSize();

        int p = 0;

        for (int i = 0; i < size.width; i++)
            for (int j = 0; j < size.height; j++)
                if (CanvasModel.getInstance().countElementsAt(new Point(i, j)) > 0)
                    p++;

        JOptionPane.showMessageDialog(null, "Povrsina unije svih trouglova je " + p + " piksela", "Unija", JOptionPane.PLAIN_MESSAGE);
    }
}
