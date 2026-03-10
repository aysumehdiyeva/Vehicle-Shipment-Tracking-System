
import java.util.*;

public class ShippingSystem {
    private ArrayList<Shipment> shipments = new ArrayList<>();   
    private Set<Integer> shipmentIds = new HashSet<>();     
    private Admin admin;

    public ShippingSystem(Admin admin) {
        this.admin = admin;
    }

    public void addShipment(Shipment s) {
        if (s == null) 
        	return;
        if (shipmentIds.contains(s.getShipmentId())) 
        	return; // no duplicates
        
        shipments.add(s);
        shipmentIds.add(s.getShipmentId());
    }

    public String displayShipments() {
        if (shipments.isEmpty()) 
        	return "No shipments.\n";
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shipments.size(); i++) {
            sb.append(shipments.get(i)).append("\n");
        }
        
        return sb.toString();
    }

    public Shipment searchShipment(int shipmentId) {
            for (int i = 0; i < shipments.size(); i++) {
                Shipment s = shipments.get(i);
                
	            if (s.getShipmentId() == shipmentId) {
	                return s;
	            }
            }
        return null;
    }

    public boolean deleteShipment(int shipmentId) {
        Iterator<Shipment> it = shipments.iterator();
        while (it.hasNext()) {
            Shipment s = it.next();
            if (s.getShipmentId() == shipmentId) {
                it.remove();
                shipmentIds.remove(shipmentId);
                return true;
            }
        }
        return false;
    }

    public boolean updateShipmentRunning(int shipmentId, boolean running) {
        Shipment s = searchShipment(shipmentId);
        if (s == null) 
        	return false;
        
        s.setRunning(running);
        return true;
    }

    public double calculateTotalRevenue() {
        double sum = 0.0;

        for (int i = 0; i < shipments.size(); i++) {
            sum += shipments.get(i).getPrice();
        }   
        return sum;
    }

	public String getTrackingInfo(int shipmentId) {
	    Shipment s = searchShipment(shipmentId);
	
	    if (s == null) {
	        return "Shipment not found.";
	    }
	
	    return s.getTrackingInfo() + "\nPrice=" + s.getPrice();
	}


    public Admin getAdmin() { 
    	return admin; 
    }
}
