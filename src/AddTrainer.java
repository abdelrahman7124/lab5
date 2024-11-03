import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Backend.AdminRole;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AddTrainer extends JFrame implements KeyListener{
    private JTextField IdField1;
    private JTextField NameField2;
    private JTextField EmailField3;
    private JTextField SpecialityField4;
    private JTextField NumberField5;
    private JButton addButton;
    private JPanel container;
    private AdminRolePage adminRolePage;


    public AddTrainer(AdminRole role,AdminRolePage adminRolePage) {
        this.adminRolePage = adminRolePage;
        IdField1 = new JTextField();
        NameField2 = new JTextField();
        EmailField3 = new JTextField();
        SpecialityField4 = new JTextField();
        NumberField5 = new JTextField();
        addButton = new JButton("Add Trainer");
        container = new JPanel();

        IdField1.addKeyListener(this);
        NameField2.addKeyListener(this);
        EmailField3.addKeyListener(this);
        SpecialityField4.addKeyListener(this);
        NumberField5.addKeyListener(this);

        JLabel idLabel = new JLabel("ID");
        JLabel nameLabel = new JLabel("Name");
        JLabel emailLabel = new JLabel("Email");
        JLabel specialityLabel = new JLabel("Speciality");
        JLabel numberLabel = new JLabel("Phone Number");

        container.setLayout(null);

        idLabel.setBounds(100,100,150,30);
        nameLabel.setBounds(100,150,150,30);
        emailLabel.setBounds(100,200,150,30);
        specialityLabel.setBounds(100,250,150,30);
        numberLabel.setBounds(100,300,150,30);

        IdField1.setBounds(300,100,150,20);
        NameField2.setBounds(300,150,150,20);
        EmailField3.setBounds(300,200,150,20);
        SpecialityField4.setBounds(300,250,150,20);
        NumberField5.setBounds(300,300,150,20);

        addButton.setBounds(170,400,150,30);

        container.add(idLabel);
        container.add(nameLabel);
        container.add(emailLabel);
        container.add(specialityLabel);
        container.add(numberLabel);
        container.add(IdField1);
        container.add(NameField2);
        container.add(EmailField3);
        container.add(SpecialityField4);
        container.add(NumberField5);
        container.add(addButton);


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
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            addButton.doClick();
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setVisible(false);
            adminRolePage.setVisible(true);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
