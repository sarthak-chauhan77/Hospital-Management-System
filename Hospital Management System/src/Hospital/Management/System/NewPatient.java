package Hospital.Management.System;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NewPatient extends JFrame implements ActionListener {
    JComboBox<String> comboBox;
    JTextField textFieldNumber, textName, textFieldDisease, textFieldDeposit;
    JRadioButton r1, r2;
    Choice roomChoice;
    JLabel dateLabel;
    JButton addButton, backButton;

    NewPatient() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);

        JLabel labelName = new JLabel("New Patient Form");
        labelName.setBounds(118, 11, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(labelName);

        JLabel labelId = new JLabel("ID :");
        labelId.setBounds(35, 76, 200, 16);
        labelId.setForeground(Color.white);
        labelId.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(labelId);

        comboBox = new JComboBox<>(new String[] { "Aadhar Card", "Voter ID", "Driving License" });
        comboBox.setBounds(271, 73, 160, 20);
        comboBox.setBackground(new Color(3, 45, 48));
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
        comboBox.setForeground(Color.white);
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number :");
        labelNumber.setBounds(35, 111, 200, 18);
        labelNumber.setForeground(Color.white);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 111, 150, 20);
        panel.add(textFieldNumber);

        JLabel labelName1 = new JLabel("Name :");
        labelName1.setBounds(35, 151, 200, 18);
        labelName1.setForeground(Color.white);
        labelName1.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(271, 151, 150, 20);
        panel.add(textName);

        JLabel Gender = new JLabel("Gender :");
        Gender.setBounds(35, 191, 200, 18);
        Gender.setForeground(Color.white);
        Gender.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(Gender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 14));
        r1.setForeground(Color.white);
        r1.setBackground(new Color(109, 164, 170));
        r1.setBounds(271, 191, 80, 15);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 14));
        r2.setForeground(Color.white);
        r2.setBackground(new Color(109, 164, 170));
        r2.setBounds(271, 211, 80, 15);
        panel.add(r1);
        panel.add(r2);

        JLabel labelDisease = new JLabel("Disease :");
        labelDisease.setBounds(35, 235, 200, 18);
        labelDisease.setForeground(Color.white);
        labelDisease.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271, 235, 150, 20);
        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("Room :");
        labelRoom.setBounds(35, 274, 200, 18);
        labelRoom.setForeground(Color.white);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(labelRoom);

        roomChoice = new Choice();
        try {
            conn connection = new conn();
            ResultSet resultSet = connection.statement.executeQuery("SELECT * FROM Room");
            while (resultSet.next()) {
                roomChoice.add(resultSet.getString("Room_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        roomChoice.setBounds(271, 274, 150, 20);
        panel.add(roomChoice);

        JLabel labelDate = new JLabel("Time :");
        labelDate.setBounds(35, 316, 200, 18);
        labelDate.setForeground(Color.white);
        labelDate.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(labelDate);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
        String formattedDate = now.format(formatter);
        dateLabel = new JLabel(formattedDate);
        dateLabel.setBounds(271, 316, 200, 18);
        dateLabel.setForeground(Color.white);
        dateLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(dateLabel);

        JLabel labelDeposit = new JLabel("Deposit :");
        labelDeposit.setBounds(35, 359, 200, 18);
        labelDeposit.setForeground(Color.white);
        labelDeposit.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(labelDeposit);

        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(271, 359, 150, 20);
        panel.add(textFieldDeposit);

        addButton = new JButton("Add");
        addButton.setBounds(130, 430, 100, 30);
        addButton.setForeground(Color.white);
        addButton.setBackground(Color.black);
        addButton.addActionListener(this);
        panel.add(addButton);

        backButton = new JButton("Back");
        backButton.setBounds(260, 430, 100, 30);
        backButton.setForeground(Color.white);
        backButton.setBackground(Color.black);
        backButton.addActionListener(this);
        panel.add(backButton);

        setSize(850, 550);
        setLayout(null);
        setLocation(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NewPatient();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String gender = r1.isSelected() ? "Male" : "Female";

            String idType = (String) comboBox.getSelectedItem();
            String idNumber = textFieldNumber.getText();
            String name = textName.getText();
            String disease = textFieldDisease.getText();
            String roomNumber = roomChoice.getSelectedItem();
            String time = dateLabel.getText();
            String deposit = textFieldDeposit.getText();
            if (idNumber.isEmpty() || name.isEmpty() || gender == null || disease.isEmpty() || roomNumber == null
                    || deposit.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields.");
            } else {
                try {
                    conn connection = new conn();

                    // Check if the selected room is already occupied
                    String checkRoomQuery = "SELECT Availability FROM Room WHERE Room_no = '" + roomNumber + "'";
                    ResultSet rs = connection.statement.executeQuery(checkRoomQuery);

                    if (rs.next()) {
                        String availability = rs.getString("Availability");

                        // If the room is already occupied, show a message and stop the process
                        if ("Occupied".equals(availability)) {
                            JOptionPane.showMessageDialog(null,
                                    "This room is already occupied. Please select another room.");
                        } else {
                            // If the room is available, add the new patient and update the room status
                            String query = "INSERT INTO patient_info VALUES('" + idType + "','" + idNumber + "','"
                                    + name
                                    + "','"
                                    + gender + "','" + disease + "','" + roomNumber + "','" + time + "','" + deposit
                                    + "')";
                            String updateRoom = "UPDATE Room SET Availability = 'Occupied' WHERE Room_no = '"
                                    + roomNumber
                                    + "'";

                            connection.statement.executeUpdate(query);
                            connection.statement.executeUpdate(updateRoom);

                            JOptionPane.showMessageDialog(null, "Patient Added Successfully");
                            setVisible(false);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == backButton) {
            dispose();
        }
    }
}
