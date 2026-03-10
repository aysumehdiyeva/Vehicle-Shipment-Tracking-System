
public abstract class Shipment {
    protected int shipmentId;
    protected String origin;
    protected String destination;
    protected double price;
    protected String date;
    protected boolean isRunning;
    protected Customer customer;

    // static variable
    private static int nextShipmentId = 1;

    // constructor
    public Shipment(String origin, String destination, String date, boolean isRunning, Customer customer) {
        this.shipmentId = getNextShipmentId(); // using static member
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.isRunning = isRunning;
        this.customer = customer;
        this.price = calculatePrice();
    }

    // static method
    public static int getNextShipmentId() {
        return nextShipmentId++;
    }

    public String getRouteInfo() {
        return origin + " -> " + destination + " (" + date + ")";
    }

    public String getTrackingInfo() {
        return "Shipment#" + shipmentId 
        		+ "\n" + getRouteInfo() 
        		+ "\nRunning=" + isRunning;
    }

    
    public abstract double calculatePrice();

    public int getShipmentId() { 
    	return shipmentId; 
    }
    
    public String getOrigin() { 
    	return origin; 
    }
    public String getDestination() { 
    	return destination; 
    }
    
    public double getPrice() { 
    	return price; 
    }
    
    public String getDate() { 
    	return date; 
    }
    
    public boolean isRunning() { 
    	return isRunning; 
    }
    
    public Customer getCustomer() { 
    	return customer; 
    }

    public void setOrigin(String origin) { 
    	this.origin = origin; 
    	this.price = calculatePrice(); 
    }
    
    public void setDestination(String destination) { 
    	this.destination = destination; 
    	this.price = calculatePrice(); 
    }
    
    public void setDate(String date) { 
    	this.date = date; 
    }
    
    public void setRunning(boolean running) { 
    	isRunning = running; 
    }
    
    public void setCustomer(Customer customer) { 
    	this.customer = customer; 
    }

    @Override
    public String toString() {
        String info = getTrackingInfo() + "\nPrice=" + price;

        if (customer == null) {
            info += "\nNoCustomer";
        } else {
            info += "\n" + customer.getCustomerInfo();
        }

    return info;
    }

}

