import Backend.Class;
import Backend.TrainerRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ViewClasses extends JFrame {
    private JPanel container;
    private JTable table1;
    private JScrollPane scrollPane;

    public ViewClasses(TrainerRole role, ArrayList<Class> classes) {
        container = new JPanel();
        table1 = new JTable();
        scrollPane = new JScrollPane();

        container.add(scrollPane);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Class Id");
        model.addColumn("Class Name");
        model.addColumn("Trainer Id");
        model.addColumn("Duration");
        model.addColumn("Max Participants");

        for (Class theClass : classes) {
            model.addRow(new Object[]{theClass.getSearchKey(), theClass.getClassName(), theClass.getTrainerID(), theClass.getDuration(), theClass.getMaxParticipants()});
        }

        table1.setModel(model);

        setContentPane(container);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("View Classes");
    }
}
