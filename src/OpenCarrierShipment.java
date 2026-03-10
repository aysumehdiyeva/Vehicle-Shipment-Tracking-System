
public class OpenCarrierShipment extends Shipment {
    private int carCount;

    public OpenCarrierShipment(String origin, String destination, String date, boolean isRunning,
                               Customer customer, int carCount) {
        super(origin, destination, date, isRunning, customer);
        this.carCount = carCount;
        this.price = calculatePrice();
    }

    @Override
    public double calculatePrice() {
    	double base = 50.0;
        double perCar = 25.0;
        
        return base + (Math.max(0, carCount) * perCar);
    }

    public int getCarCount() { 
    	return carCount; 
    }
    public void setCarCount(int carCount) { 
    	this.carCount = carCount; 
    	this.price = calculatePrice(); 
    }

    @Override
    public String toString() {
        return "OpenCarrier" + super.toString() + "\nCar Count= " + carCount;
    }
}

