import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Backend.AdminRole;

public class AddTrainer extends JFrame {
    private JTextField IdField1;
    private JTextField NameField2;
    private JTextField EmailField3;
    private JTextField SpecialityField4;
    private JTextField NumberField5;
    private JButton addButton;
    private JPanel container;


    public AddTrainer(AdminRole role,AdminRolePage adminRolePage) {
        setTitle("Add Trainer");
        setContentPane(container);
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = IdField1.getText();
                String name = NameField2.getText();
                String email = EmailField3.getText();
                String speciality = SpecialityField4.getText();
                String phoneNumber = NumberField5.getText();
                if (id.isEmpty() || name.isEmpty() || email.isEmpty() || speciality.isEmpty() || phoneNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(AddTrainer.this, "Some fields are empty");
                }
                else {
                    boolean bool = role.addTrainer(id, name, email, speciality, phoneNumber);
                    if (bool) {
                        JOptionPane.showMessageDialog(null, "The Trainer with id=" + id + " was added successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "The Trainer with id=" + id + " already exists!");
                    }
                }
                IdField1.setText("");
                NameField2.setText("");
                EmailField3.setText("");
                SpecialityField4.setText("");
                NumberField5.setText("");
                adminRolePage.setVisible(true);
                setVisible(false);
            }
        });
    }
}
