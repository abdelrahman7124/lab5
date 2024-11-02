import Backend.TrainerRole;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClass extends JFrame {
    private JPanel container;
    private JTextField classIdTextField;
    private JTextField classNameTextField;
    private JTextField trainerIdTextField;
    private JTextField durationTextField;
    private JTextField maxParticipantsTextField;
    private JButton addClassButton;

    public AddClass(TrainerRole role, TrainerRolePage trainerRolePage) {
        setContentPane(container);
        setSize(500, 500);
        setLocationRelativeTo(null);
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
}
