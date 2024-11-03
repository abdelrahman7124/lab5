import Backend.TrainerRole;

import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class TrainerLogin extends JFrame implements LoginCredentials, KeyListener {
    private JPanel container;
    private JButton loginButton;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JLabel trainerLabel;
    private JLabel passwordLabel;

    public TrainerLogin() {
        this.container = new JPanel();

        container.setLayout(null);

        loginButton = new JButton("login");
        loginButton.setBounds(190, 400, 100, 40);

        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        textField1.addKeyListener(this);
        passwordField1.addKeyListener(this);
        textField1.setBounds(200, 110, 200, 20);
        passwordField1.setBounds(200, 210, 200, 20);


        trainerLabel = new JLabel("User Name");
        passwordLabel = new JLabel("Password");
        trainerLabel.setBounds(100, 100, 150, 40);
        passwordLabel.setBounds(100, 200, 150, 40);

        container.add(loginButton);
        container.add(trainerLabel);
        container.add(passwordLabel);
        container.add(textField1);
        container.add(passwordField1);

        setTitle("Trainer Login");
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            loginButton.doClick();
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setVisible(false);
            HomePage homePage = new HomePage();
            homePage.setVisible(true);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
