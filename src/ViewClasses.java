import Backend.Class;
import Backend.TrainerRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class ViewClasses extends JFrame implements KeyListener {
    private JPanel container;
    private JTable table1;
    private JScrollPane scrollPane;
    private TrainerRolePage trainerRolePage;

    public ViewClasses(TrainerRole role, ArrayList<Class> classes,TrainerRolePage trainerRolePage) {
        this.trainerRolePage = trainerRolePage;
        container = new JPanel();
        table1 = new JTable();
        scrollPane = new JScrollPane(table1);
        table1.addKeyListener(this);

        container.add(scrollPane);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Class Id");
        model.addColumn("Class Name");
        model.addColumn("Trainer Id");
        model.addColumn("Duration");
        model.addColumn("Max Participants");

        for (Class theClass : classes) {
            model.addRow(new Object[]{theClass.getSearchKey(), theClass.getClassName(), theClass.getTrainerID(), theClass.getDuration(), theClass.getAvailableSeats()});
        }

        table1.setModel(model);

        setContentPane(container);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("View Classes");
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
