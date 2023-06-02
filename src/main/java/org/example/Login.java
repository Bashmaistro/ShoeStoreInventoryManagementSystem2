package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Login extends JFrame {
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton logInButton;
    private JPanel Login;

    public Login() {
        add(Login);
        setSize(400, 200);
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                String password = passwordField1.getText();

                if (username.equals("admin") && password.equals("admin")) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            DatabaseViewer dtb = new DatabaseViewer();
                            dtb.setVisible(true);
                            JFrame loginPage = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
                            loginPage.dispose();
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Password or Username", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
