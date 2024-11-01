import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin extends JFrame implements LoginCredentials {
    private JButton loginButton;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel container;

    public AdminLogin() {
        super("Admin Login");
        setContentPane(container);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                String password = textField2.getText();
                if(!username.equalsIgnoreCase(ADMIN_USERNAME) || !password.equalsIgnoreCase(ADMIN_PASSWORD)) {
                    JOptionPane.showMessageDialog(container, "Wrong UserName or Password");
                }
                else {
                   AdminRolePage adminRolePage = new AdminRolePage();
                    adminRolePage.setVisible(true);
                    setVisible(false);
                }

            }
        });
    }
}
