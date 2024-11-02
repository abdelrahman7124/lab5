import Backend.TrainerRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMember extends JFrame {
    private JPanel container;
    private JButton addMemberButton;
    private JTextField idTextField;
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField membershipTypeTextField;
    private JTextField phoneNumberTextField;
    private JTextField statusTextField;

    public AddMember(TrainerRole role, TrainerRolePage trainerRolePage) {
        idTextField = new JTextField();
        nameTextField = new JTextField();
        emailTextField = new JTextField();
        membershipTypeTextField = new JTextField();
        phoneNumberTextField = new JTextField();
        statusTextField = new JTextField();
        addMemberButton = new JButton("Add Member");

        container = new JPanel();

        JLabel id = new JLabel("Id");
        JLabel name = new JLabel("Name");
        JLabel email = new JLabel("Email");
        JLabel membershipType = new JLabel("Membership Type");
        JLabel phoneNumber = new JLabel("Phone Number");
        JLabel status = new JLabel("Status");

        container.setLayout(null);

        id.setBounds(100,100,150,30);
        name.setBounds(100,150,150,30);
        email.setBounds(100,200,150,30);
        membershipType.setBounds(100,250,150,30);
        phoneNumber.setBounds(100,300,150,30);
        status.setBounds(100,350,150,30);

        idTextField.setBounds(300,100,150,20);
        nameTextField.setBounds(300,150,150,20);
        emailTextField.setBounds(300,200,150,20);
        membershipTypeTextField.setBounds(300,250,150,20);
        phoneNumberTextField.setBounds(300,300,150,20);
        statusTextField.setBounds(300,350,150,20);

        addMemberButton.setBounds(170,400,150,30);

        container.add(id);
        container.add(name);
        container.add(email);
        container.add(membershipType);
        container.add(phoneNumber);
        container.add(status);
        container.add(idTextField);
        container.add(nameTextField);
        container.add(emailTextField);
        container.add(membershipTypeTextField);
        container.add(phoneNumberTextField);
        container.add(statusTextField);
        container.add(addMemberButton);

        setContentPane(container);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Add Member");

        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idTextField.getText();
                String name = nameTextField.getText();
                String email = emailTextField.getText();
                String membershipType = membershipTypeTextField.getText();
                String phoneNumber = phoneNumberTextField.getText();
                String status = statusTextField.getText();

                if (id.isEmpty() || name.isEmpty() || email.isEmpty() || membershipType.isEmpty() || phoneNumber.isEmpty() || status.isEmpty())
                {
                    JOptionPane.showMessageDialog(AddMember.this, "Some fields are empty");
                }
                else {
                    boolean isAdded = role.addMember(id, name, membershipType, email, phoneNumber, status);
                    if (isAdded)
                        JOptionPane.showMessageDialog(null, "The member with id = " + id + " was added successfully");
                    else
                        JOptionPane.showMessageDialog(null, "The member with id = " + id + " already exists");
                    idTextField.setText("");
                    nameTextField.setText("");
                    emailTextField.setText("");
                    membershipTypeTextField.setText("");
                    statusTextField.setText("");
                    phoneNumberTextField.setText("");
                    setVisible(false);
                    trainerRolePage.setVisible(true);
                }
            }
        });
    }
}
