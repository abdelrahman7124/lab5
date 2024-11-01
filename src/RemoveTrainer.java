import Backend.AdminRole;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveTrainer extends JFrame {
    private JPanel container;
    private JTextField textField1;
    private JButton removeButton;

    public RemoveTrainer(AdminRole role,AdminRolePage adminRolePage) {
        setContentPane(container);
        setTitle("Remove Trainer");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField1.getText();
                if(role.removeTrainer(id)) {
                    JOptionPane.showMessageDialog(null, "Trainer removed");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Trainer not removed");
                }
                textField1.setText("");
                adminRolePage.setVisible(true);
                setVisible(false);
            }
        });
    }
}
