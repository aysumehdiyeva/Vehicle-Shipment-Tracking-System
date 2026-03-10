
public class ShipmentMain {
    public static void main(String[] args) {

        Admin admin = new Admin("admin", "1234");
        ShippingSystem system = new ShippingSystem(admin);

        RoleSelectionFrame frame = new RoleSelectionFrame(system);
        frame.setVisible(true);
    }
}
