import Backend.TrainerRole;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;

public class RegisterMemberForClass extends JFrame implements  KeyListener {
    private JPanel container;
    private JTextField memberIdTextField;
    private JTextField classIdTextField;
    private JTextField registrationDateTextField;
    private JButton registerButton;
    private TrainerRolePage trainerRolePage;

    public RegisterMemberForClass(TrainerRole role, TrainerRolePage trainerRolePage) {
        this.trainerRolePage = trainerRolePage;
        memberIdTextField = new JTextField();
        classIdTextField = new JTextField();
        registrationDateTextField = new JTextField();
        registrationDateTextField.setText(LocalDate.now()+"");
        registerButton = new JButton("Register");

        container = new JPanel();

        memberIdTextField.addKeyListener(this);
        registrationDateTextField.addKeyListener(this);
        classIdTextField.addKeyListener(this);

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                    registrationDateTextField.setText(LocalDate.now()+"");
                }
            }
        });
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            registerButton.doClick();
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setVisible(false);
            trainerRolePage.setVisible(true);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
