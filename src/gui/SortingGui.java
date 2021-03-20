package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SortingGui extends JFrame {

    public SortingGui(){
        //Making the Window
        super();
        int frameWidth = 490;
        int frameHeight = 380;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) - 100;
        int y = (d.height - getSize().height) -100;
        setLocation(x, y);
        setTitle("Sorting");
        setResizable(true);
        setVisible(true);
        JPanel jp = new JPanel();
        jp.setLayout(null);
        setMinimumSize(new Dimension(frameWidth,frameHeight));

        //Resize Window
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                frameResized();
            }
        });

        //Objects in the Window

    }

    private void frameResized() {

    }
}
