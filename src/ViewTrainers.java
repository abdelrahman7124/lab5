import Backend.AdminRole;
import Backend.Trainer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class ViewTrainers extends JFrame implements KeyListener {
    private JPanel container;
    private JScrollPane scrollPane;
    private JTable table1;
    private AdminRolePage adminRolePage;


    public ViewTrainers(AdminRole role,ArrayList<Trainer> trainers,AdminRolePage adminRolePage) {
        this.adminRolePage = adminRolePage;
        container = new JPanel();
        table1 = new JTable();
        scrollPane = new JScrollPane(table1);
        table1.addKeyListener(this);
        container.add(scrollPane);

        // Initialize the GUI components
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Speciality");
        model.addColumn("Phone Number");


        for (Trainer trainer : trainers) {
            model.addRow(new Object[]{trainer.getId(), trainer.getName(), trainer.getEmail(), trainer.getSpeciality(), trainer.getPhoneNumber()});
        }

        // Set the model to the JTable
        table1.setModel(model);

        // Set up the JFrame
        setTitle("View Trainers");
        setContentPane(container);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
            adminRolePage.setVisible(true);
            setVisible(false);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
