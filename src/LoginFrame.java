
import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private final JTextField userField = new JTextField(15);
    private final JPasswordField passField = new JPasswordField(15);

    public LoginFrame(ShippingSystem system) {
        setTitle("Admin Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(360, 180);
        setLocationRelativeTo(null);

        JButton loginBtn = new JButton("Login");

        JPanel p = new JPanel(new GridLayout(3, 2, 8, 8));
        p.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        p.add(new JLabel("Username:"));
        p.add(userField);
        p.add(new JLabel("Password:"));
        p.add(passField);
        p.add(new JLabel());
        p.add(loginBtn);

        add(p);

        loginBtn.addActionListener(e -> {
            String u = userField.getText().trim();
            String pw = new String(passField.getPassword());

            if (system.getAdmin().login(u, pw)) {
                // open second frame
                new MainFrame(new UserSession(system)).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Wrong username/password!", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
