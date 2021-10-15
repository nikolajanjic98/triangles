package model;

import painter.TrianglePainter;

import java.awt.*;
import java.util.ArrayList;

public class Triangle extends Component {

    ArrayList<Point> allPoints;

    Stroke stroke;
    Paint paint;

    TrianglePainter trianglePainter;

    public Triangle(ArrayList<Point> points) {

        if (points.size() != 3)
            return;

        allPoints = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            allPoints.add(points.get(i));

        stroke = new BasicStroke(2f);
        paint = new Color(255,255,255);

        trianglePainter = new TrianglePainter(this);
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public ArrayList<Point> getAllPoints() {
        return allPoints;
    }

    public TrianglePainter getTrianglePainter() {
        return trianglePainter;
    }

    public void setTrianglePainter(TrianglePainter trianglePainter) {
        this.trianglePainter = trianglePainter;
    }
}
