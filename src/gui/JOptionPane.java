package gui;

import javax.swing.*;

public class JOptionPane extends javax.swing.JOptionPane {

    public static utils.List<Integer> showMultiInputDialoge(String message1, String message2, String headline){
        utils.List<Integer> re = new utils.List<>();

        JTextField field1 = new JTextField(5);
        JTextField field2 = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel(message1));
        myPanel.add(field1);
        myPanel.add(new JLabel(message2));
        myPanel.add(field2);

        int result =JOptionPane.showConfirmDialog(null, myPanel, headline, JOptionPane.OK_CANCEL_OPTION);
        if(result == 0){
            re.append(Integer.parseInt(field1.getText()));
            re.append(Integer.parseInt(field2.getText()));
            return re;
        }
        return null;
    }

    public static void showTable(int[] table, String title){
        //TODO finish Methode
        /*
        String[] name = new String[table.length];
        for(int i = 0; i < table.length; i++){
            name[i] = "" + i;
        }
        String[] data = new String[table.length];

        JTextField field1 = new JTextField();


        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel(message1));
        myPanel.add(field1);
        myPanel.add(new JLabel(message2));
        myPanel.add(field2);

        int result =JOptionPane.showConfirmDialog(null, myPanel, headline, JOptionPane.OK_CANCEL_OPTION);
        if(result == 0){
            re.append(Integer.parseInt(field1.getText()));
            re.append(Integer.parseInt(field2.getText()));
            return re;
        }*/
    }
}
