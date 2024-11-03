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

        addMemberButton.setBounds(105, 50, 300, 40);
        viewMembersButton.setBounds(105, 100, 300, 40);
        addClassButton.setBounds(105, 150, 300, 40);
        viewClassesButton.setBounds(105, 200, 300, 40);
        registerMemberForClassButton.setBounds(105, 250, 300, 40);
        cancelRegistrationButton.setBounds(105, 300, 300, 40);
        viewRegistrationsButton.setBounds(105, 350, 300, 40);
        logoutButton.setBounds(105, 400, 300, 40);

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
