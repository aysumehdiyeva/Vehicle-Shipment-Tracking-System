import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

    private final UserSession session;

    // GUI components (required)
    private final JComboBox<String> typeCombo = new JComboBox<>(new String[]{"OpenCarrierShipment", "EnclosedShipment"});
    private final JTextField originField = new JTextField(10);
    private final JTextField destinationField = new JTextField(10);
    private final JTextField dateField = new JTextField(10);
    private final JTextField runningField = new JTextField(5); // true/false

    private final JTextField custIdField = new JTextField(5);
    private final JTextField custNameField = new JTextField(10);
    private final JTextField custPhoneField = new JTextField(10);
    private final JTextField custEmailField = new JTextField(10);

    // OpenCarrier specific
    private final JTextField carCountField = new JTextField(5);

    // Enclosed specific
    private final JCheckBox luxuryCheck = new JCheckBox("Luxury?");
    private final JTextField insuranceField = new JTextField(6);

    // search/delete
    private final JTextField shipmentIdField = new JTextField(8);

    private final JTextArea outputArea = new JTextArea(14, 55);

    public MainFrame(UserSession session) {
        this.session = session;

        setTitle("Shipping System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 520);
        setLocationRelativeTo(null);

        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        // Buttons (required)
        JButton addBtn = new JButton("Add");
        JButton displayBtn = new JButton("Display");
        JButton searchBtn = new JButton("Search");
        JButton deleteBtn = new JButton("Delete");
        JButton revenueBtn = new JButton("Total Revenue");
        JButton trackBtn = new JButton("Track");

        // Top panel inputs
        JPanel top = new JPanel(new GridLayout(4, 1));

        top.add(buildShipmentPanel());
        top.add(buildCustomerPanel());
        top.add(buildTypePanel());
        top.add(buildActionsPanel(addBtn, displayBtn, searchBtn, deleteBtn, revenueBtn, trackBtn));

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // ---------- Button actions (must call SystemClass methods) ----------
        addBtn.addActionListener(e -> doAdd());
        displayBtn.addActionListener(e -> outputArea.setText(session.getShippingSystem().displayShipments()));
        searchBtn.addActionListener(e -> doSearch());
        deleteBtn.addActionListener(e -> doDelete());
        revenueBtn.addActionListener(e -> outputArea.setText("Total Revenue = " + session.getShippingSystem().calculateTotalRevenue()));
        trackBtn.addActionListener(e -> doTrack());

        // ---------- KEY EVENT (required) ----------
        // Press ENTER in shipmentIdField => search
        shipmentIdField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    doSearch();
                }
            }
        });

        // ---------- MOUSE CLICK EVENT (required) ----------
        // Double click outputArea => show a small popup
        outputArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Mouse event detected ✅ (double-click on text area)",
                            "Mouse Event", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // enable/disable fields based on combo selection
        typeCombo.addActionListener(e -> updateTypeFields());
        updateTypeFields();
    }

    private JPanel buildShipmentPanel() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.setBorder(BorderFactory.createTitledBorder("Shipment Info"));
        p.add(new JLabel("Type:"));
        p.add(typeCombo);
        p.add(new JLabel("Origin:"));
        p.add(originField);
        p.add(new JLabel("Destination:"));
        p.add(destinationField);
        p.add(new JLabel("Date:"));
        p.add(dateField);
        p.add(new JLabel("Running(true/false):"));
        p.add(runningField);
        return p;
    }

    private JPanel buildCustomerPanel() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.setBorder(BorderFactory.createTitledBorder("Customer Info"));
        p.add(new JLabel("ID:"));
        p.add(custIdField);
        p.add(new JLabel("Name:"));
        p.add(custNameField);
        p.add(new JLabel("Phone:"));
        p.add(custPhoneField);
        p.add(new JLabel("Email:"));
        p.add(custEmailField);
        return p;
    }

    private JPanel buildTypePanel() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.setBorder(BorderFactory.createTitledBorder("Type Specific"));

        p.add(new JLabel("carCount (OpenCarrier):"));
        p.add(carCountField);

        p.add(luxuryCheck);
        p.add(new JLabel("insuranceFee (Enclosed):"));
        p.add(insuranceField);

        return p;
    }

    private JPanel buildActionsPanel(JButton addBtn, JButton displayBtn, JButton searchBtn,
                                     JButton deleteBtn, JButton revenueBtn, JButton trackBtn) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.setBorder(BorderFactory.createTitledBorder("Actions"));

        p.add(addBtn);
        p.add(displayBtn);

        p.add(new JLabel("ShipmentId:"));
        p.add(shipmentIdField);
        p.add(searchBtn);
        p.add(deleteBtn);
        p.add(trackBtn);

        p.add(revenueBtn);
        return p;
    }

    private void updateTypeFields() {
        String type = (String) typeCombo.getSelectedItem();
        boolean open = "OpenCarrierShipment".equals(type);

        carCountField.setEnabled(open);

        luxuryCheck.setEnabled(!open);
        insuranceField.setEnabled(!open);
    }

    private void doAdd() {
        try {
            String origin = originField.getText().trim();
            String dest = destinationField.getText().trim();
            String date = dateField.getText().trim();
            boolean running = Boolean.parseBoolean(runningField.getText().trim());

            int cid = Integer.parseInt(custIdField.getText().trim());
            String cname = custNameField.getText().trim();
            String cphone = custPhoneField.getText().trim();
            String cemail = custEmailField.getText().trim();
            Customer customer = new Customer(cid, cname, cphone, cemail);

            String type = (String) typeCombo.getSelectedItem();
            Shipment s;

            if ("OpenCarrierShipment".equals(type)) {
                int carCount = Integer.parseInt(carCountField.getText().trim());
                s = new OpenCarrierShipment(origin, dest, date, running, customer, carCount);
            } else {
                boolean luxury = luxuryCheck.isSelected();
                double insurance = Double.parseDouble(insuranceField.getText().trim());
                s = new EnclosedShipment(origin, dest, date, running, customer, luxury, insurance);
            }

            session.getShippingSystem().addShipment(s);
            outputArea.setText("Added ✅\n" + s + "\n\nTip: New shipmentId = " + s.getShipmentId());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Add failed. Check inputs.\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void doSearch() {
        try {
            int id = Integer.parseInt(shipmentIdField.getText().trim());
            Shipment s = session.getShippingSystem().searchShipment(id);
            outputArea.setText((s == null) ? "Not found ❌" : ("Found ✅\n" + s));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid shipmentId.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void doDelete() {
        try {
            int id = Integer.parseInt(shipmentIdField.getText().trim());
            boolean ok = session.getShippingSystem().deleteShipment(id);
            outputArea.setText(ok ? ("Deleted ✅ shipmentId=" + id) : ("Not found ❌ shipmentId=" + id));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid shipmentId.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void doTrack() {
        try {
            int id = Integer.parseInt(shipmentIdField.getText().trim());
            outputArea.setText(session.trackShipment(id));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid shipmentId.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
