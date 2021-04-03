package gui;

import javax.swing.*;
import java.util.List;

public class JOptionPaneMultiInput {

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
}