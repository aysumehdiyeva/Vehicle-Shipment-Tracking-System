# 🚚 Shipping Management System (Java OOP Project)

A **Java desktop application** developed for the **CTIS221 – Object Oriented Programming** course.  
The system allows administrators to manage shipments and users to track shipment information through a graphical interface built with **Java Swing**.

The project demonstrates key **Object-Oriented Programming concepts** such as inheritance, abstraction, interfaces, encapsulation, and collections.

---

# 📌 Project Overview

The Shipping Management System simulates a logistics platform where shipments can be created, tracked, searched, deleted, and displayed.

The system supports two shipment types:

- Open Carrier Shipment
- Enclosed Shipment

Users can track shipments, while administrators can manage the shipment database through a graphical user interface.

---

# 🎯 Features

### Administrator Functions

- Login authentication
- Add new shipments
- Display all shipments
- Search shipment by ID
- Delete shipment
- Track shipment status
- Calculate total revenue from shipments

### User Functions

- Track shipment using shipment ID

---

# 🖥 GUI

The application uses **Java Swing** and includes multiple frames:

- **RoleSelectionFrame** – allows the user to choose Admin or User
- **LoginFrame** – admin authentication interface
- **MainFrame** – shipment management interface
- **UserTrackingFrame** – shipment tracking interface

The GUI includes:

- Buttons
- Text fields
- Combo boxes
- Text areas
- Key events
- Mouse click events

These GUI components interact with the system class to perform operations.

---

# 🧱 Object-Oriented Design

The project demonstrates the following OOP concepts.

## Abstract Class

`Shipment`

This class represents the base shipment and includes common attributes:

- shipmentId
- origin
- destination
- date
- running status
- price
- customer

It defines the abstract method:
calculatePrice()

Each subclass calculates the shipment price differently.

---

## Inheritance

Two subclasses extend the Shipment class:
```
Shipment
│
├── OpenCarrierShipment
└── EnclosedShipment
```

### OpenCarrierShipment
Price depends on the number of cars transported.

### EnclosedShipment
Price depends on:
- luxury vehicle option
- insurance fee

---

## Interface
TrackableInterface

Defines the method:
trackShipment(int shipmentId)

Implemented by:
UserSession

---

## System Class

---

## System Class
ShippingSystem

Responsible for managing shipments using collections.

Uses:

- `ArrayList<Shipment>` to store shipments
- `HashSet<Integer>` to prevent duplicate shipment IDs

Main system methods:

- addShipment()
- displayShipments()
- searchShipment()
- deleteShipment()
- calculateTotalRevenue()
- getTrackingInfo()

---

# 📦 Data Classes

## Customer

Stores customer information:

- customerId
- name
- phone number
- email

Provides methods for retrieving and updating customer details.

---

## Admin

Handles authentication for administrators.

Login method:
login(username, password) 

---

# 📂 Project Structure
```
src/
│
├── ShipmentMain.java
├── ShippingSystem.java
├── Shipment.java
├── OpenCarrierShipment.java
├── EnclosedShipment.java
├── Customer.java
├── Admin.java
├── UserSession.java
├── TrackableInterface.java
│
├── RoleSelectionFrame.java
├── LoginFrame.java
├── MainFrame.java
└── UserTrackingFrame.java
```

---

# ▶️ Running the Project

### 1. Clone the repository
git clone https://github.com/aysumehdiyeva/vehicle-shipment-tracking-system.git

### 2. Open the project in Eclipse
File → Import → Existing Projects into Workspace

### 3. Run the application

Run the main class:
ShipmentMain.java

---

# 🧪 Example Workflow

1️⃣ Start the application  

2️⃣ Select **Admin** or **User**

### Admin

- Login with credentials  
- Add shipments  
- Display shipments  
- Search shipments  
- Delete shipments  
- Track shipment status  
- View total revenue  

### User

- Enter shipment ID  
- View shipment tracking information  

---

# 🛠 Technologies Used

- Java
- Java Swing
- Eclipse IDE
- Object-Oriented Programming
- Java Collections Framework (ArrayList, HashSet)

---

# The project demonstrates the use of:

- Abstract classes
- Interfaces
- Inheritance
- Encapsulation
- Collections
- GUI programming
- Event handling
