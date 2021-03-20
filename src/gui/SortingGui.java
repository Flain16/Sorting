package gui;

import main.Sorting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SortingGui extends JFrame {

    private Sorting sorting = new Sorting();

    private JButton genTab = new JButton();
    private JButton showTab = new JButton();

    public SortingGui(){
        //Making the Window
        super();
        int frameWidth = 490;
        int frameHeight = 380;
        setSize(frameWidth, frameHeight);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
        genTab.setBounds(10,10,getWidth() - 350,getHeight() - 330);
        genTab.setMargin(new Insets(2,2,2,2));
        genTab.setText("generate new table");
        genTab.addActionListener(e -> genTabPressed());
        jp.add(genTab);
        showTab.setBounds(10, genTab.getHeight() + 20, getWidth() - 350,getHeight() - 330);
        showTab.setMargin(new Insets(2,2,2,2));
        showTab.addActionListener(e -> );

        //adding JPanel to the Window
        add(jp);
    }

    private void frameResized() {
        genTab.setBounds(10,10,getWidth() - 350,getHeight() - 330);
    }

    private void genTabPressed(){
        sorting.genTable(Integer.parseInt(JOptionPane.showInputDialog("Length of the table")),
                Integer.parseInt(JOptionPane.showInputDialog("Maximum value of the Math.random ints")));
    }

    private void showTabPressed(){

    }
}
