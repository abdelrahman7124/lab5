import Backend.TrainerRole;

import javax.swing.*;
import java.awt.event.*;

public class CancelRegistration extends JFrame {
    private JPanel container;

    public CancelRegistration(TrainerRole role, TrainerRolePage trainerRolePage) {
        setContentPane(container);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Trainer Role");
    }
}
