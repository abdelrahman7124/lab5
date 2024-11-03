import Backend.TrainerRole;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelRegistration extends JFrame {
    private JPanel container;
    private JTextField memberIdTextField;
    private JTextField classIdTextField;
    private JButton cancelRegisterationButton;

    public CancelRegistration(TrainerRole role, TrainerRolePage trainerRolePage) {
        memberIdTextField = new JTextField();
        classIdTextField = new JTextField();
        cancelRegisterationButton = new JButton("Cancel Registration");

        container = new JPanel();

        JLabel memberIdLabel = new JLabel("Member Id");
        JLabel classIdLabel = new JLabel("Class Id");

        container.setLayout(null);

        memberIdLabel.setBounds(100,100,150,30);
        classIdLabel.setBounds(100,150,150,30);

        memberIdTextField.setBounds(300,100,150,20);
        classIdTextField.setBounds(300,150,150,20);

        cancelRegisterationButton.setBounds(170,400,150,30);

        container.add(memberIdLabel);
        container.add(classIdLabel);
        container.add(memberIdTextField);
        container.add(classIdTextField);
        container.add(cancelRegisterationButton);

        setContentPane(container);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cancel Registration");

        cancelRegisterationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberId = memberIdTextField.getText();
                String classId = classIdTextField.getText();

                if (memberId.isEmpty() || classId.isEmpty())
                    JOptionPane.showMessageDialog(CancelRegistration.this, "Some fields are empty");
                else {
                    boolean isCancelled = role.cancelRegistration(memberId, classId);

                    if (isCancelled)
                        JOptionPane.showMessageDialog(null, "The Member with id = " + memberId + " has been unregistered from class " + classId);
                    else
                        JOptionPane.showMessageDialog(null, "Registration of Member with id " + memberId + " for class " + classId + " is already cancelled");

                }
                setVisible(false);
                trainerRolePage.setVisible(true);
                memberIdTextField.setText("");
                classIdTextField.setText("");
            }
        });
    }
}
