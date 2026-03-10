import javax.swing.*;
import java.awt.*;

public class UserTrackingFrame extends JFrame {

    private JTextField shipmentIdField = new JTextField(10);
    private JTextArea outputArea = new JTextArea(8, 30);

    public UserTrackingFrame(UserSession session) {
        setTitle("User Shipment Tracking");
        setSize(420, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton trackBtn = new JButton("Track Shipment");

        JPanel top = new JPanel();
        top.add(new JLabel("Shipment ID:"));
        top.add(shipmentIdField);
        top.add(trackBtn);

        outputArea.setEditable(false);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        trackBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(shipmentIdField.getText().trim());
                outputArea.setText(session.trackShipment(id));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter a valid shipment ID.");
            }
        });
    }
}
