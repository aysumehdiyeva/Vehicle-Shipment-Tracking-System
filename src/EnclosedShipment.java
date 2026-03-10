
public class EnclosedShipment extends Shipment {
    private boolean luxuryVehicle;
    private double insuranceFee;

    public EnclosedShipment(String origin, String destination, String date, boolean isRunning, Customer customer, 
    		boolean luxuryVehicle, double insuranceFee) {
    	
        super(origin, destination, date, isRunning, customer);   
        this.luxuryVehicle = luxuryVehicle;
        this.insuranceFee = insuranceFee;
        this.price = calculatePrice();
    }

    @Override
    public double calculatePrice() {
        double base = 80.0;
        double luxuryExtra = 0.0;

        if (luxuryVehicle) {
            luxuryExtra = 60.0;
        }

        double insurance = Math.max(0, insuranceFee);
        return base + luxuryExtra + insurance;
    }

    public boolean isLuxuryVehicle() { 
    	return luxuryVehicle; 
    }
    public double getInsuranceFee() { 
    	return insuranceFee; 
    }

    public void setLuxuryVehicle(boolean luxuryVehicle) {   	
    	this.luxuryVehicle = luxuryVehicle; 
    	this.price = calculatePrice(); 
    }
    
    public void setInsuranceFee(double insuranceFee) { 
    	this.insuranceFee = insuranceFee; 
    	this.price = calculatePrice();	
    }

    @Override
    public String toString() {
        return "Enclosed" + super.toString() 
        + "\nLuxury= " + luxuryVehicle 
        + "\nInsurance Fee= " + insuranceFee;
    }
}

