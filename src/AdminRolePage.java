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
        container = new JPanel();
        addTrainerButton = new JButton("Add Trainer");
        removeTrainerButton = new JButton("Remove Trainer");
        viewTrainersButton = new JButton("View Trainers");
        logoutButton = new JButton("Logout");

        container.setLayout(null);

        addTrainerButton.setBounds(170, 50, 150, 50);
        removeTrainerButton.setBounds(170, 150, 150, 50);
        viewTrainersButton.setBounds(170, 250, 150, 50);
        logoutButton.setBounds(170, 350, 150, 50);

        container.add(addTrainerButton);
        container.add(removeTrainerButton);
        container.add(viewTrainersButton);
        container.add(logoutButton);

        setTitle("Admin Role");
        setContentPane(container);
        setSize(500,500);
        setLocationRelativeTo(null);
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
