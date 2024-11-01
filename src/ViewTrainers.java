import Backend.AdminRole;
import Backend.Trainer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ViewTrainers extends JFrame {
    private JPanel container;
    private JScrollPane scrollPane;
    private JTable table1;


    public ViewTrainers(AdminRole role,ArrayList<Trainer> trainers) {
        // Initialize the GUI components
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Speciality");
        model.addColumn("Phone Number");

        //ArrayList<Trainer> trainers = role.getListOfTrainers();

        for (Trainer trainer : trainers) {
            model.addRow(new Object[]{trainer.getId(), trainer.getName(), trainer.getEmail(), trainer.getSpeciality(), trainer.getPhoneNumber()});
        }

        // Set the model to the JTable
        table1.setModel(model);

        // Set up the JFrame
        setTitle("View Trainers");
        setContentPane(container);
        setSize(500, 500);
        setLocationRelativeTo(null);

    }
}
