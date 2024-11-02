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
    private JButton logoutButton;
    private JButton viewRegistrationsButton;

    TrainerRole role = new TrainerRole();

    AddMember addMember = new AddMember(role, this);
    AddClass addClass = new AddClass(role, this);
    ViewClasses viewClasses = new ViewClasses(role, this);
    RegisterMemberForClass registerMemberForClass = new RegisterMemberForClass(role, this);
    CancelRegistration cancelRegistration = new CancelRegistration(role, this);
    ViewRegistrations viewRegistrations = new ViewRegistrations(role, this);

    public TrainerRolePage() {
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
