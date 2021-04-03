package gui;

import main.Sorting;
import utils.CUtil;
import utils.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SortingGui extends JFrame {

    private Sorting sorting = new Sorting();

    private JButton genTab = new JButton();
    private JButton showTab = new JButton();
    private JCheckBox selectDebug = new JCheckBox();

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
        genTab.setText("Generate new table");
        genTab.addActionListener(e -> genTabPressed());
        jp.add(genTab);
        showTab.setBounds(10, genTab.getHeight() + 20, getWidth() - 350,getHeight() - 330);
        showTab.setMargin(new Insets(2,2,2,2));
        showTab.setText("Print table");
        showTab.addActionListener(e -> showTabPressed());
        jp.add(showTab);
        selectDebug.setBounds(getWidth()-10, 10,10,10);
        selectDebug.setText("Debug");
        jp.add(selectDebug);

        //adding JPanel to the Window
        add(jp);
    }

    private void frameResized() {
        //TODO Finish
        genTab.setBounds(10,10,getWidth() - 350,getHeight() - 330);
    }

    private void genTabPressed(){
        List<Integer> getInput = JOptionPane.showMultiInputDialoge("Length", "Maximum",
                "Input length of the Table an the maximum value");
        getInput.toFirst();
        int length = getInput.getContent();
        getInput.toLast();
        int maximum = getInput.getContent();
        sorting.genTable(length,maximum);
    }

    private void showTabPressed(){
        //TODO ADD the Ability to open in an Table Option Pane
        int[] table = sorting.getUnsorted();
        if(table == null){
            System.err.println("Create table");
            JOptionPane.showMessageDialog(null,"Create table","Error Message", JOptionPane.ERROR_MESSAGE);
        }else {
            CUtil.table(table);
            JOptionPane.showTable(table);
        }
    }
}
