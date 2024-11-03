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

        addMemberButton.setBounds(170, 50, 150, 40);
        viewMembersButton.setBounds(170, 100, 150, 40);
        addClassButton.setBounds(170, 150, 150, 40);
        viewClassesButton.setBounds(170, 200, 150, 40);
        registerMemberForClassButton.setBounds(170, 250, 150, 40);
        cancelRegistrationButton.setBounds(170, 300, 150, 40);
        viewRegistrationsButton.setBounds(170, 350, 150, 40);
        logoutButton.setBounds(170, 400, 150, 40);

        container.add(addMemberButton);
        container.add(viewMembersButton);
        container.add(addClassButton);
        container.add(viewClassesButton);
        container.add(registerMemberForClassButton);
        container.add(cancelRegistrationButton);
        container.add(viewRegistrationsButton);
        container.add(logoutButton);

        setContentPane(container);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Trainer Role");

        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMember.setVisible(true);
                setVisible(false);
            }
        });

        viewMembersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewMembers viewMembers = new ViewMembers(role, role.getListOfMembers(),TrainerRolePage.this);
                viewMembers.setVisible(true);
                setVisible(false);
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
            ViewClasses viewClasses = new ViewClasses(role, role.getListOfClasses(),TrainerRolePage.this);
            viewClasses.setVisible(true);
            setVisible(false);
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
            ViewRegistrations viewRegistrations = new ViewRegistrations(role, role.getListOfRegistrations(),TrainerRolePage.this);
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
