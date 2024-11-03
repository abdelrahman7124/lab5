import Backend.AdminRole;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveTrainer extends JFrame {
    private JPanel container;
    private JTextField textField1;
    private JButton removeButton;
    private JLabel label;

    public RemoveTrainer(AdminRole role,AdminRolePage adminRolePage) {
        container = new JPanel();
        textField1 = new JTextField();
        removeButton = new JButton("Remove");
        label = new JLabel("Trainer Id");

        container.setLayout(null);

        label.setBounds(75,250,150,30);
        textField1.setBounds(150,255,150,20);
        removeButton.setBounds(300,255,100,20);


        container.add(textField1);
        container.add(removeButton);
        container.add(label);


        setContentPane(container);
        setTitle("Remove Trainer");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField1.getText();
                if(role.removeTrainer(id)) {
                    JOptionPane.showMessageDialog(null, "Trainer removed");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Cannot remove trainer");
                }
                textField1.setText("");
                adminRolePage.setVisible(true);
                setVisible(false);
            }
        });
        }
}
