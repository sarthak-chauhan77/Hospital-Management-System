package Hospital.Management.System;

import java.awt.Choice;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Patient_Update extends JFrame {
    Patient_Update() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550, 100, 300, 300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124, 11, 260, 25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25, 88, 70, 14);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248, 85, 140, 25);
        panel.add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()) {
                choice.add(resultSet.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(25, 139, 150, 14);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248, 129, 140, 20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("In-Time :");
        label4.setBounds(25, 174, 100, 14);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JTextField textFieldInTime = new JTextField();
        textFieldInTime.setBounds(248, 174, 140, 20);
        panel.add(textFieldInTime);

        JLabel label5 = new JLabel("Amount Paid :");
        label5.setBounds(25, 216, 150, 14);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.white);
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248, 216, 140, 20);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Pending Amount :");
        label6.setBounds(25, 261, 150, 14);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setForeground(Color.white);
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248, 261, 140, 20);
        panel.add(textFieldPending);

        JButton Check = new JButton("Check");
        Check.setBounds(281, 378, 140, 20);
        Check.setBackground(Color.BLACK);
        Check.setForeground(Color.WHITE);
        panel.add(Check);
        Check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from patient_info where Name = '" + id + "'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()) {
                        textFieldR.setText(resultSet.getString("Room_Number"));
                        textFieldInTime.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposite"));
                    }

                    // Fetch room price and calculate pending amount
                    ResultSet resultSet1 = c.statement
                            .executeQuery("select * from Room where Room_no = '" + textFieldR.getText() + "'");
                    while (resultSet1.next()) {
                        String price = resultSet1.getString("Price");
                        int roomPrice = Integer.parseInt(price);
                        int depositAmount = Integer.parseInt(textFieldAmount.getText());

                        // Check if deposit is greater than or equal to the room price
                        if (depositAmount >= roomPrice) {
                            textFieldPending.setText("0"); // Fully paid
                        } else {
                            int pendingAmount = roomPrice - depositAmount;
                            textFieldPending.setText("" + pendingAmount);
                        }
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton Update = new JButton("Update");
        Update.setBounds(56, 378, 89, 23);
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.WHITE);
        panel.add(Update);
        Update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent E) {
                // Check if any of the fields are empty
                if (textFieldR.getText().isEmpty() || textFieldInTime.getText().isEmpty()
                        || textFieldAmount.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields before updating.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method if validation fails
                }

                try {
                    conn c = new conn();
                    String q = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldInTime.getText();
                    String amount = textFieldAmount.getText();
                    c.statement.executeUpdate("UPDATE patient_info SET Room_Number = '" + room
                            + "', Time ='" + time + "', Deposite = '" + amount + "' WHERE Name = '" + q + "'");
                    JOptionPane.showMessageDialog(null, "Update Successfully");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JButton Back = new JButton("Back");
        Back.setBounds(160, 378, 89, 23);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.white);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setUndecorated(true);
        setSize(950, 500);
        setLocation(400, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Patient_Update();
    }
}
