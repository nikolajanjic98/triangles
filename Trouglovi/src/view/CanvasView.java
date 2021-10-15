package view;

import controller.CanvasController;
import model.CanvasModel;
import model.Triangle;
import observer.Subscriber;
import painter.TrianglePainter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class CanvasView extends JPanel implements Subscriber {

    private static CanvasView instance = null;

    private CanvasView() {

        setBorder(new LineBorder(Color.BLACK,1));
        setMinimumSize(new Dimension(500,500));
        setPreferredSize(new Dimension(500,500));
        setMaximumSize(new Dimension(500,500));
        setBackground(Color.WHITE);
        addMouseListener(new CanvasController());
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // omogucava providnost elemenata prilikom njihovog preklapanja
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));


        ArrayList<Triangle> triangles = CanvasModel.getInstance().getTriangles();

        for (Triangle t : triangles) {
            TrianglePainter tp = t.getTrianglePainter();
            tp.paint(g2, t);
        }
    }

    @Override
    public void update(Object event) {
        this.repaint();
    }


    public static CanvasView getInstance() {
        if (instance == null)
            instance = new CanvasView();

        return  instance;
    }

}
