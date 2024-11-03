import Backend.TrainerRole;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AddClass extends JFrame implements KeyListener{
    private JPanel container;
    private JTextField classIdTextField;
    private JTextField classNameTextField;
    private JTextField trainerIdTextField;
    private JTextField durationTextField;
    private JTextField maxParticipantsTextField;
    private JButton addClassButton;
    private TrainerRolePage trainerRolePage;

    public AddClass(TrainerRole role, TrainerRolePage trainerRolePage) {
        this.trainerRolePage = trainerRolePage;
        classIdTextField = new JTextField();
        classNameTextField  = new JTextField();
        trainerIdTextField = new JTextField();
        durationTextField = new JTextField();
        maxParticipantsTextField = new JTextField();
        addClassButton = new JButton("Add Class");

        container = new JPanel();

        classIdTextField.addKeyListener(this);
        classNameTextField.addKeyListener(this);
        trainerIdTextField.addKeyListener(this);
        durationTextField.addKeyListener(this);
        maxParticipantsTextField.addKeyListener(this);

        JLabel classId = new JLabel("Class Id");
        JLabel className = new JLabel("Class Name");
        JLabel trainerId = new JLabel("Trainer Id");
        JLabel duration = new JLabel("Duration");
        JLabel maxParticipants = new JLabel("Max Participants");

        container.setLayout(null);

        classId.setBounds(100,100,150,30);
        className.setBounds(100,150,150,30);
        trainerId.setBounds(100,200,150,30);
        duration.setBounds(100,250,150,30);
        maxParticipants.setBounds(100,300,150,30);

        classIdTextField.setBounds(300,100,150,20);
        classNameTextField.setBounds(300,150,150,20);
        trainerIdTextField.setBounds(300,200,150,20);
        durationTextField.setBounds(300,250,150,20);
        maxParticipantsTextField.setBounds(300,300,150,20);

        addClassButton.setBounds(170,400,150,30);

        container.add(classId);
        container.add(className);
        container.add(trainerId);
        container.add(duration);
        container.add(maxParticipants);
        container.add(classIdTextField);
        container.add(classNameTextField);
        container.add(trainerIdTextField);
        container.add(durationTextField);
        container.add(maxParticipantsTextField);
        container.add(addClassButton);

        setContentPane(container);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add Class");

        addClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String classId = classIdTextField.getText();
                String className = classNameTextField.getText();
                String trainerId = trainerIdTextField.getText();
                String duration = durationTextField.getText();
                String  maxParticipants = maxParticipantsTextField.getText();

                if (classId.isEmpty() || className.isEmpty() || trainerId.isEmpty() || duration.isEmpty() || maxParticipants.isEmpty())
                    JOptionPane.showMessageDialog(AddClass.this, "Some fields are empty");
                else
                {
                    boolean isAdded = role.addClass(classId, className, trainerId, Integer.parseInt(duration), Integer.parseInt(maxParticipants));

                    if(isAdded)
                        JOptionPane.showMessageDialog(null, "Class with id = " + classId + " was added successfully");
                    else
                        JOptionPane.showMessageDialog(null, "Class with id = " + classId + " already exists");
                    setVisible(false);
                    trainerRolePage.setVisible(true);
                    classIdTextField.setText("");
                    classNameTextField.setText("");
                    trainerIdTextField.setText("");
                    durationTextField.setText("");
                    maxParticipantsTextField.setText("");
                }
            }
        });

    }
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            addClassButton.doClick();
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
