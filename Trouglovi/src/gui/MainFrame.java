package gui;

import model.CanvasModel;
import view.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame instance = null;

    private Toolbar toolbar;
    private CanvasView canvasView;

    private MainFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initialiseGUI();
    }

    private void initialiseGUI () {
        this.setTitle("Trouglovi");

        toolbar = Toolbar.getInstance();
        canvasView = CanvasView.getInstance();

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, toolbar, canvasView);
        add(split, BorderLayout.CENTER);
        split.setOneTouchExpandable(false);
        split.setDividerLocation(250);
        setSize(1100,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static MainFrame getInstance() {
        if (instance == null)
            instance = new MainFrame();

        return instance;
    }

}
