
import javax.swing.*;
import java.awt.*;

public class RoleSelectionFrame extends JFrame {

    public RoleSelectionFrame(ShippingSystem system) {
        setTitle("Shipping System - Select Role");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JButton adminBtn = new JButton("Admin");
        JButton userBtn = new JButton("User");

        JPanel panel = new JPanel();
        panel.add(adminBtn);
        panel.add(userBtn);

        add(panel, BorderLayout.CENTER);

        // ADMIN BUTTON → Login
        adminBtn.addActionListener(e -> {
            new LoginFrame(system).setVisible(true);
            dispose();
        });

        // USER BUTTON → Tracking only
        userBtn.addActionListener(e -> {
            new UserTrackingFrame(new UserSession(system)).setVisible(true);
            dispose();
        });
    }
}
