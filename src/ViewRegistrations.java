import Backend.MemberClassRegistration;
import Backend.TrainerRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class ViewRegistrations extends JFrame implements KeyListener {
    private JPanel container;
    private JTable table1;
    private JScrollPane scrollPane;
    private TrainerRolePage trainerRolePage;

    public ViewRegistrations(TrainerRole role, ArrayList<MemberClassRegistration> registrations,TrainerRolePage trainerRolePage) {
        this.trainerRolePage = trainerRolePage;
        container = new JPanel();
        table1 = new JTable();
        scrollPane = new JScrollPane(table1);
        table1.addKeyListener(this);

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
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        trainerRolePage.setVisible(true);
        setVisible(false);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
