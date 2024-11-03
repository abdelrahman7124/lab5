import Backend.TrainerRole;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainerRolePage extends JFrame{
    private JPanel container;
    private JButton addMemberButton;
    private JButton viewMembersButton;
    private JButton addClassButton;
    private JButton viewClassesButton;
    private JButton registerMemberForClassButton;
    private JButton cancelRegistrationButton;
    private JButton viewRegistrationsButton;
    private JButton logoutButton;

    TrainerRole role = new TrainerRole();

    AddMember addMember = new AddMember(role, this);
    AddClass addClass = new AddClass(role, this);
    RegisterMemberForClass registerMemberForClass = new RegisterMemberForClass(role, this);
    CancelRegistration cancelRegistration = new CancelRegistration(role, this);

    public TrainerRolePage() {
        addMemberButton = new JButton("Add Member");
        viewMembersButton = new JButton("View Members");
        addClassButton = new JButton("Add Class");
        viewClassesButton = new JButton("View Classes");
        registerMemberForClassButton = new JButton("Register Member for Class");
        cancelRegistrationButton = new JButton("Cancel Registration");
        viewRegistrationsButton = new JButton("View Registrations");
        logoutButton = new JButton("Logout");

        container = new JPanel();
        container.setLayout(null);

        addMemberButton.setBounds(200, 50, 300, 50);
        viewMembersButton.setBounds(200, 100, 300, 50);
        addClassButton.setBounds(200, 150, 300, 50);
        viewClassesButton.setBounds(200, 200, 300, 50);
        registerMemberForClassButton.setBounds(200, 250, 300, 50);
        cancelRegistrationButton.setBounds(200, 300, 300, 50);
        viewRegistrationsButton.setBounds(200, 350, 300, 50);
        logoutButton.setBounds(200, 400, 300, 50);

        container.add(addMemberButton);
        container.add(viewMembersButton);
        container.add(addClassButton);
        container.add(viewClassesButton);
        container.add(registerMemberForClassButton);
        container.add(cancelRegistrationButton);
        container.add(viewRegistrationsButton);
        container.add(logoutButton);

        setContentPane(container);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Trainer Role");

        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMember.setVisible(true);

            }
        });

        viewMembersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewMembers viewMembers = new ViewMembers(role, role.getListOfMembers());
                viewMembers.setVisible(true);
            }
        });

        addClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClass.setVisible(true);
                setVisible(false);
            }
        });

    viewClassesButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ViewClasses viewClasses = new ViewClasses(role, role.getListOfClasses());
            viewClasses.setVisible(true);
        }
    });

    registerMemberForClassButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            registerMemberForClass.setVisible(true);
            setVisible(false);
        }
    });

    cancelRegistrationButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            cancelRegistration.setVisible(true);
            setVisible(false);
        }
    });

    viewRegistrationsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ViewRegistrations viewRegistrations = new ViewRegistrations(role, role.getListOfRegistrations());
            viewRegistrations.setVisible(true);
            setVisible(false);
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
