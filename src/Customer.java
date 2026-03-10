
public class Customer {
    private int customerId;
    private String name;
    private String phoneNumber;
    private String email;

    public Customer(int customerId, String name, String phoneNumber, String email) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getCustomerInfo() {
        return "Customer id=" + customerId 
        		+ "\nName=" + name 
        		+ "\nPhone=" + phoneNumber 
        		+ "\nEmail=" + email + "\n";
    }

    public void updateCustomerInfo(String name, String phoneNumber, String email) {
        if (name != null && !name.isBlank()) 
        	this.name = name;
        if (phoneNumber != null && !phoneNumber.isBlank()) 
        	this.phoneNumber = phoneNumber;
        if (email != null && !email.isBlank()) 
        	this.email = email;
    }

    public int getCustomerId() { 
    	return customerId; 
    }
    public String getName() { 
    	return name; 
    }
    public String getPhoneNumber() { 
    	return phoneNumber; 
    }
    public String getEmail() { 
    	return email; 
    }
}

