
public class UserSession implements TrackableInterface {
    private ShippingSystem shippingSystem;

    public UserSession(ShippingSystem shippingSystem) {
        this.shippingSystem = shippingSystem;
    }

    @Override
    public String trackShipment(int shipmentId) {
        return shippingSystem.getTrackingInfo(shipmentId);
    }

    public ShippingSystem getShippingSystem() {
        return shippingSystem;
    }
}

