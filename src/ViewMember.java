import Backend.Member;
import Backend.TrainerRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class ViewMember extends JFrame {
    private JPanel container;
    private JTable table1;


    public ViewMember(TrainerRole role, ArrayList<Member> members) {
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
}
