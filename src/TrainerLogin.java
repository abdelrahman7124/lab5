import Backend.TrainerRole;

import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class TrainerLogin extends JFrame implements LoginCredentials {
    private JPanel container;
    private JButton loginButton;
    private JPasswordField passwordField1;
    private JTextField textField1;

    public TrainerLogin() {
        super("Trainer Login");
        setContentPane(container);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                String password = passwordField1.getText();
                if (!username.equalsIgnoreCase(TRAINER_USERNAME) || !password.equals(TRAINER_PASSWORD)) {
                    JOptionPane.showMessageDialog(container, "Wrong username or password");
                } else {
                    TrainerRolePage trainerRolePage = new TrainerRolePage();
                    trainerRolePage.setVisible(true);
                    setVisible(false);
                }
            }
        });
    }
}
