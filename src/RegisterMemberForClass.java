import Backend.TrainerRole;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;

public class RegisterMemberForClass extends JFrame {
    private JPanel container;
    private JTextField memberIdTextField;
    private JTextField classIdTextField;
    private JTextField registrationDateTextField;
    private JButton registerButton;

    public RegisterMemberForClass(TrainerRole role, TrainerRolePage trainerRolePage) {
        memberIdTextField = new JTextField();
        classIdTextField = new JTextField();
        registrationDateTextField = new JTextField();
        registerButton = new JButton("Register");

        container = new JPanel();

        JLabel memberIdLabel = new JLabel("Member Id");
        JLabel classIdLabel = new JLabel("Class Id");
        JLabel registrationDateLabel = new JLabel("Registration Date");

        container.setLayout(null);

        memberIdLabel.setBounds(100,100,150,30);
        classIdLabel.setBounds(100,150,150,30);
        registrationDateLabel.setBounds(100,200,150,30);

        memberIdTextField.setBounds(300,100,150,20);
        classIdTextField.setBounds(300,150,150,20);
        registrationDateTextField.setBounds(300,200,150,20);

        registerButton.setBounds(170,400,150,30);

        container.add(memberIdLabel);
        container.add(classIdLabel);
        container.add(registrationDateLabel);
        container.add(memberIdTextField);
        container.add(classIdTextField);
        container.add(registrationDateTextField);
        container.add(registerButton);

        setContentPane(container);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Register Member for Class");

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberId = memberIdTextField.getText();
                String classId = classIdTextField.getText();
                String registrationDate = registrationDateTextField.getText();

                if (memberId.isEmpty() || classId.isEmpty() || registrationDate.isEmpty())
                    JOptionPane.showMessageDialog(RegisterMemberForClass.this, "Some fields are empty");
                else {
                    boolean isRegistered = role.registerMemberForClass(memberId, classId, LocalDate.parse(registrationDate));

                    if (isRegistered)
                        JOptionPane.showMessageDialog(null, "The Member with id = " + memberId + " has successfully registered to class " + classId);
                    else
                        JOptionPane.showMessageDialog(null, "The class has no available seats");
                    setVisible(false);
                    trainerRolePage.setVisible(true);
                    memberIdTextField.setText("");
                    classIdTextField.setText("");
                    registrationDateTextField.setText("");
                }
            }
        });
    }
}
