import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AdminLogin extends JFrame implements LoginCredentials, KeyListener {
    private JButton loginButton;
    private JTextField textField1;
    private JPasswordField textField2;
    private JLabel adminLabel;
    private JLabel passwordLabel;
    private JPanel container;

    public AdminLogin() {
        this.container = new JPanel();

        container.setLayout(null);

        loginButton = new JButton("login");
        loginButton.setBounds(190, 400, 100, 40);

        textField1 = new JTextField();
        textField2 = new JPasswordField();
        textField1.addKeyListener(this);
        textField2.addKeyListener(this);
        textField1.setBounds(200, 110, 200, 20);
        textField2.setBounds(200, 210, 200, 20);


        adminLabel = new JLabel("User Name");
        passwordLabel = new JLabel("Password");
        adminLabel.setBounds(100, 100, 150, 40);
        passwordLabel.setBounds(100, 200, 150, 40);

        container.add(loginButton);
        container.add(adminLabel);
        container.add(passwordLabel);
        container.add(textField1);
        container.add(textField2);

        setTitle("Admin Login");
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            loginButton.doClick();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

