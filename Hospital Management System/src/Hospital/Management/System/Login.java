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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
    JTextField textField;
    JPasswordField passwordField;
    JButton b1, b2;

    Login() {
        JLabel nameLabel = new JLabel("UserName");
        nameLabel.setBounds(40, 20, 100, 30);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(40, 70, 100, 30);
        passLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(nameLabel);
        add(passLabel);

        textField = new JTextField();
        textField.setBounds(150, 20, 150, 30);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setBackground(new Color(255, 179, 0));
        add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 30);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        passwordField.setBackground(new Color(255, 179, 0));
        add(passwordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(320, 0, 400, 200);
        add(label);

        JLabel login = new JLabel("Login For The Access");
        login.setBounds(430, 200, 250, 30);
        login.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 22));
        login.setForeground(Color.WHITE);
        add(login);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("Serif", Font.BOLD, 15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("Serif", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(109, 164, 170));
        setSize(750, 300);
        setLocation(400, 270);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            try {
                conn c = new conn();
                String user = textField.getText();
                @SuppressWarnings("deprecation")
                String pass = passwordField.getText();
                String q = "select * from Login where ID = '" + user + "' and Pass = '" + pass + "'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if (resultSet.next()) {
                    new Reception();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid");
                }

            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            System.exit(10);
        }
    }
}
