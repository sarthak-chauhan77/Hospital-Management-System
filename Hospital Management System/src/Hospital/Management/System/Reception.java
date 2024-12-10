package Hospital.Management.System;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Reception extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;

    public Reception() {
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 5, 1525, 150); // Top panel
        panel1.setBackground(new Color(109, 164, 170));
        add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(5, 160, 1525, 670); // Main panel
        panel2.setBackground(new Color(109, 164, 170));
        add(panel2);

        // Adding the images in panel1
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/dr.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(1300, 0, 250, 200);
        panel1.add(label);

        ImageIcon imageIconn = new ImageIcon(ClassLoader.getSystemResource("icons/amb.png"));
        Image i2 = imageIconn.getImage().getScaledInstance(300, 100, Image.SCALE_DEFAULT);
        ImageIcon imageIcon11 = new ImageIcon(i2);
        JLabel labell = new JLabel(imageIcon11);
        labell.setBounds(1000, 50, 300, 100);
        panel1.add(labell);

        // This is the full.jpg image, shifting it to panel2
        ImageIcon imagef = new ImageIcon(ClassLoader.getSystemResource("icons/full.jpg"));
        Image imagee = imagef.getImage().getScaledInstance(1525, 670, Image.SCALE_DEFAULT); // Adjusting size
        ImageIcon imagef1 = new ImageIcon(imagee);
        JLabel label1 = new JLabel(imagef1);
        label1.setBounds(5, 0, 1525, 670); // Centering the image in panel2
        panel2.add(label1);

        // Buttons configuration in panel1
        b1 = new JButton("Add New Patient");
        b1.setBounds(30, 15, 200, 30);
        b1.setBackground(new Color(246, 215, 118));
        b1.addActionListener(this);
        panel1.add(b1);

        b2 = new JButton("Room");
        b2.setBounds(30, 55, 200, 30);
        b2.setBackground(new Color(246, 215, 118));
        b2.addActionListener(this);
        panel1.add(b2);

        b3 = new JButton("Department");
        b3.setBounds(30, 95, 200, 30);
        b3.setBackground(new Color(246, 215, 118));
        b3.addActionListener(this);
        panel1.add(b3);

        b4 = new JButton("All Employee Info");
        b4.setBounds(250, 15, 200, 30);
        b4.setBackground(new Color(246, 215, 118));
        b4.addActionListener(this);
        panel1.add(b4);

        b5 = new JButton("Patient Info");
        b5.setBounds(250, 55, 200, 30);
        b5.setBackground(new Color(246, 215, 118));
        b5.addActionListener(this);
        panel1.add(b5);

        b6 = new JButton("Patient Discharge");
        b6.setBounds(250, 95, 200, 30);
        b6.setBackground(new Color(246, 215, 118));
        b6.addActionListener(this);
        panel1.add(b6);

        b7 = new JButton("Update Patient Details");
        b7.setBounds(470, 15, 200, 30);
        b7.setBackground(new Color(246, 215, 118));
        b7.addActionListener(this);
        panel1.add(b7);

        b8 = new JButton("Hospital Ambulance");
        b8.setBounds(470, 55, 200, 30);
        b8.setBackground(new Color(246, 215, 118));
        b8.addActionListener(this);
        panel1.add(b8);

        b9 = new JButton("Search Rooms");
        b9.setBounds(470, 95, 200, 30);
        b9.setBackground(new Color(246, 215, 118));
        b9.addActionListener(this);
        panel1.add(b9);

        b10 = new JButton("Logout");
        b10.setBounds(690, 15, 200, 30);
        b10.setBackground(new Color(246, 215, 118));
        b10.addActionListener(this);
        panel1.add(b10);

        setUndecorated(true);
        setLayout(null);
        setSize(1950, 1090);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            new NewPatient();
        }
        if (e.getSource() == b2) {
            new Room();
        }
        if (e.getSource() == b3) {
            new Department();
        }
        if (e.getSource() == b4) {
            new Employee_Info();
        }
        if (e.getSource() == b5) {
            new All_Patient_Info();
        }
        if (e.getSource() == b6) {
            new patient_Discharge();
        }
        if (e.getSource() == b7) {
            new Patient_Update();
        }
        if (e.getSource() == b8) {
            new Ambulance();
        }
        if (e.getSource() == b9) {
            new SearchRoom();
        }
        if (e.getSource() == b10) {
            dispose();
            new Login();
        }
    }
}
