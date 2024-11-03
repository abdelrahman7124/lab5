import Backend.Member;
import Backend.TrainerRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class ViewMembers extends JFrame implements KeyListener {
    private JPanel container;
    private JTable table1;
    private JScrollPane scrollPane;
    private TrainerRolePage trainerRolePage;

    public ViewMembers(TrainerRole role, ArrayList<Member> members,TrainerRolePage trainerRolePage) {
        this.trainerRolePage = trainerRolePage;
        container = new JPanel();
        table1 = new JTable();
        scrollPane = new JScrollPane(table1);
        table1.addKeyListener(this);

        container.add(scrollPane);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Membership Type");
        model.addColumn("Phone Number");
        model.addColumn("Status");


        for (Member member : members) {
            model.addRow(new Object[]{member.getSearchKey(), member.getName(), member.getEmail(), member.getMembershipType(), member.getPhoneNumber(), member.getStatus()});
        }

        table1.setModel(model);

        setTitle("View Members");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setContentPane(container);
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
