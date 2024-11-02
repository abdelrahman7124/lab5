import Backend.MemberClassRegistration;
import Backend.TrainerRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ViewRegistrations extends JFrame {
    private JPanel container;
    private JTable table1;
    private JScrollPane scrollPane;

    public ViewRegistrations(TrainerRole role, ArrayList<MemberClassRegistration> registrations) {
        container = new JPanel();
        table1 = new JTable();
        scrollPane = new JScrollPane();

        container.add(scrollPane);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Member Id");
        model.addColumn("Class Id");
        model.addColumn("Registration Date");

        for (MemberClassRegistration registration : registrations) {
            model.addRow(new Object[]{registration.getMemberID(), registration.getClassID(), registration.getRegistrationDate()});
        }

        table1.setModel(model);

        setContentPane(container);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("View Registrations");
    }
}
