package model;

import observer.Publisher;
import observer.Subscriber;
import painter.TrianglePainter;
import view.CanvasView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CanvasModel implements Publisher {

    private static CanvasModel instance = null;

    ArrayList<Point> activePoints;
    ArrayList<Triangle> triangles;

    List<Subscriber> subscribers;

    private boolean crtaj = false;

    private CanvasModel() {
        activePoints = new ArrayList<>();
        triangles = new ArrayList<>();
        addSubscriber(CanvasView.getInstance());
    }

    public static CanvasModel getInstance() {
        if (instance == null)
            instance = new CanvasModel();

        return instance;
    }

    public void addTriangle(ArrayList<Point> activePoints) {
        Triangle t = new Triangle(activePoints);
        triangles.add(t);
        notifySubscribers(this);
    }

    public void addPoint(Point newPoint) {
        activePoints.add(newPoint);

        if (activePoints.size() == 3) {
            addTriangle(activePoints);
            activePoints.clear();
            setCrtaj(false);
        }
    }

    public ArrayList<Point> getActivePoints() {
        return activePoints;
    }

    public ArrayList<Triangle> getTriangles() {
        return triangles;
    }

    public void setCrtaj(boolean crtaj) {
        this.crtaj = crtaj;
    }

    public boolean isCrtaj() {
        return crtaj;
    }

    public int countElementsAt(Point pos) {
        int cnt = 0;
        for (Triangle t : triangles) {
            TrianglePainter tp = t.getTrianglePainter();
            if (tp.elementAt(pos))
                cnt++;
        }
        return cnt;
    }

    @Override
    public void addSubscriber(Subscriber sub) {
        if(sub == null)
            return;
        if(this.subscribers ==null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(Subscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if(notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;
        for(Subscriber listener : subscribers){
            listener.update(notification);
        }
    }
}
