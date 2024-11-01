import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {
    private JPanel container;
    private JButton adminButton;
    private JButton trianerButton;

    public HomePage() {
        setVisible(true);
        setContentPane(container);
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminLogin adminLogin = new AdminLogin();
                adminLogin.setVisible(true);
                setVisible(false);
            }
        });
        trianerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public static void main (String[] args)
    {
        HomePage home = new HomePage();
    }
}


