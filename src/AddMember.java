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
