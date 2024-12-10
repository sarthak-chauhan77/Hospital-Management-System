package Hospital.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class All_Patient_Info extends JFrame {
    All_Patient_Info() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(109, 164, 170));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 40, 900, 450);
        table.setBackground(new Color(90, 156, 163));
        table.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(Dbutil.resultSetTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("ID");
        label1.setBounds(31, 11, 100, 16);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);
        JLabel label2 = new JLabel("Number");
        label2.setBounds(150, 11, 100, 16);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);
        JLabel label3 = new JLabel("Name");
        label3.setBounds(270, 11, 100, 16);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);
        JLabel label4 = new JLabel("Gender");
        label4.setBounds(360, 11, 100, 16);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);
        JLabel label5 = new JLabel("Disease");
        label5.setBounds(470, 11, 100, 16);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label5);
        JLabel label6 = new JLabel("Room");
        label6.setBounds(580, 11, 100, 16);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label6);
        JLabel label7 = new JLabel("Time");
        label7.setBounds(700, 11, 100, 16);
        label7.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label7);
        JLabel label8 = new JLabel("Deposite");
        label8.setBounds(800, 11, 100, 16);
        label8.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label8);

        JButton back = new JButton("Back");
        back.setBounds(750, 490, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setSize(900, 600);
        setLocation(300, 200);
        setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new All_Patient_Info();
    }
}
