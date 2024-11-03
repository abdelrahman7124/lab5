import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {
    private JPanel container;
    private JButton adminButton;
    private JButton trainerButton;

    public HomePage() {
        this.container = new JPanel();

        container.setLayout(null);

        adminButton = new JButton("Admin");
        trainerButton = new JButton("Trainer");

        adminButton.setBounds(185, 100, 100, 50);
        trainerButton.setBounds(185, 300, 100, 50);

        container.add(adminButton);
        container.add(trainerButton);

        setTitle("Gym System");
        setVisible(true);
        setContentPane(container);
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminLogin adminLogin = new AdminLogin();
                adminLogin.setVisible(true);
                setVisible(false);
            }
        });
        trainerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrainerLogin trainerLogin = new TrainerLogin();
                trainerLogin.setVisible(true);
                setVisible(false);
            }
        });
    }
    public static void main (String[] args)
    {
        HomePage home = new HomePage();
    }
}


