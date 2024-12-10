package Hospital.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Room extends JFrame {
    JTable table;

    Room() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/roomm.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(600, 200, 200, 200);
        panel.add(label);

        table = new JTable();
        table.setBounds(10, 40, 500, 400);
        table.setBackground(new Color(90, 156, 163));
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from Room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(Dbutil.resultSetTableModel(resultSet));

        } catch (Exception e) {

        }

        JLabel label1 = new JLabel("Room No");
        label1.setBounds(12, 15, 80, 15);
        label1.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(label1);
        JLabel label2 = new JLabel("Availability");
        label2.setBounds(140, 15, 100, 15);
        label2.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(label2);
        JLabel label3 = new JLabel("Price");
        label3.setBounds(265, 15, 80, 15);
        label3.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(label3);
        JLabel label4 = new JLabel("Bad Type");
        label4.setBounds(390, 15, 80, 18);
        label4.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(label4);

        JButton back = new JButton("Back");
        back.setBounds(200, 500, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setSize(900, 600);
        setLayout(null);
        setLocation(300, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Room();
    }
}
