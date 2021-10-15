package painter;

import model.Triangle;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class TrianglePainter {

    Shape shape;

    public TrianglePainter(Triangle triangle) {

        shape = new GeneralPath();

        ((GeneralPath)shape).moveTo(triangle.getAllPoints().get(0).x,triangle.getAllPoints().get(0).y);

        ((GeneralPath)shape).lineTo(triangle.getAllPoints().get(1).x,triangle.getAllPoints().get(1).y);

        ((GeneralPath)shape).lineTo(triangle.getAllPoints().get(2).x,triangle.getAllPoints().get(2).y);

        ((GeneralPath)shape).lineTo(triangle.getAllPoints().get(0).x,triangle.getAllPoints().get(0).y);

        ((GeneralPath)shape).closePath();

    }

    public void paint(Graphics2D g, Triangle triangle){

        g.setPaint(Color.BLACK);

        g.setStroke(triangle.getStroke());
        g.draw(getShape());
        g.setPaint(triangle.getPaint());

        g.fill(getShape());
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public boolean elementAt(Point pos) {
        return getShape().contains(pos);
    }

}
