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
