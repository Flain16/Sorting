package gui;

import algos.BubbleSort;
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
    private JButton bubble = new JButton();
    private JCheckBox debug = new JCheckBox();
    private  JLabel tDebug = new JLabel();
    private BubbleSort b = new BubbleSort();

    public SortingGui(){
        //creating the Window
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
        selectDebug.setBounds(getWidth()-85, 10,20,20);
        selectDebug.setMargin(new Insets(2,2,2,2));
        selectDebug.setText("Debug");
        jp.add(selectDebug);
        tDebug.setBounds(getWidth() -65, 10, 100,20);
        tDebug.setText("Debug");
        jp.add(tDebug);
        bubble.setBounds(10, showTab.getY() + showTab.getHeight() + 10, getWidth() -350, getHeight() - 330);
        bubble.setMargin(new Insets(2,2,2,2));
        bubble.setText("Bubblesort run");
        bubble.addActionListener(e -> bubblePressed());
        jp.add(bubble);
        debug.setBounds(getWidth() - 20,10,10,10);
        debug.setMargin(new Insets(2,2,2,2));
        debug.addActionListener(e -> checkboxPressed());
        jp.add(debug);


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
            if(checkboxPressed()){
                CUtil.table(table);
            }
            JOptionPane.showTable(table, "Table");
        }
    }

    private void bubblePressed(){
        int[] re;
        re = b.bubbleSort(sorting.getUnsorted(), checkboxPressed());
        CUtil.n("finished in " + b.getTime() + "seconds");
        CUtil.n("Table Bubblesort:");
        CUtil.table(re);
    }

    private boolean checkboxPressed(){
        return selectDebug.isSelected();
    }
}
