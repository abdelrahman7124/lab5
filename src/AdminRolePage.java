import Backend.AdminRole;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminRolePage extends JFrame {
    private JButton addTrainerButton;
    private JButton removeTrainerButton;
    private JButton viewTrainersButton;
    private JButton logoutButton;
    private JPanel container;

    AdminRole role = new AdminRole();

    public AdminRolePage() {
        setContentPane(container);
        setSize(500,500);
        setLocationRelativeTo(null);
        setTitle("Admin Role");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        AddTrainer addTrainer = new AddTrainer(role,this);
        RemoveTrainer removeTrainer = new RemoveTrainer(role,this);

        addTrainerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                addTrainer.setVisible(true);
                setVisible(false);
            }
        });
        removeTrainerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeTrainer.setVisible(true);
                setVisible(false);
            }
        });
        viewTrainersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewTrainers viewTrainers = new ViewTrainers(role,role.getListOfTrainers());
                viewTrainers.setVisible(true);
                //setVisible(false);
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                role.logout();
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
                setVisible(false);
            }
        });
    }
}
