INSERT INTO customers(customer_id, customer_lastname, customer_firstname, customer_address) VALUES
(1000000001, 'Dela Cruz', 'Juan', '123 Rizal Street, Sta. Ana, Manila'),
(1000000002, 'Santos', 'Maria', '456 Mabini Avenue, Malate, Manila'),
(1000000003, 'Reyes', 'Pedro', '789 Roxas Boulevard, Pasay City'),
(1000000004, 'Garcia', 'Ana', '321 Sumulong Highway, Antipolo, Rizal'),
(1000000005, 'Bautista', 'Jose', '654 Governor\'s Drive, Gen. Trias, Cavite');

INSERT INTO Pickups(ORDER_ID, ORDER_TYPE, STATUS, PICKUP_LOCATION, PICKUP_DATE, PICKUP_SERVICE, PAYMENT_METHOD) values
(1000000001, 'Meal A', 'Pending', 'Sta. Ana branch', '2024-01-20', 'Express', 'Cash'),
(1000000002, 'Combo meal C', 'Ready', 'Malate branch', '2024-01-21', 'Standard', 'Credit'),
(1000000003, 'Combo meal D', 'Completed', 'Pasay branch', '2024-01-19', 'Express', 'Cash'),
(1000000004, 'Meal B', 'Pending', 'Antipolo branch', '2024-01-22', 'Standard', 'Debit'),
(1000000005, 'Meal A', 'Ready', 'Gen. Trias branch', '2024-01-21', 'Express', 'Credit');

INSERT INTO Drivers (DRIVER_ID, DRIVER_LASTNAME, DRIVER_FIRSTNAME, DRIVER_CONTACT, DRIVER_LICENCE, STATUS, SHIFT) VALUES 
(1001, 'Bee', 'Jolli', 09171234567, 'DL123456789SU', 'Available', '08:00:00'),
(1002, 'Barbeque', 'Reyes', 09179876543, 'DL987654321SU', 'Available', '12:00:00'),
(1003, 'Inasal', 'Mang', 09171122334, 'DL555666777SU', 'Busy', '08:00:00'),
(1004, 'Fung', 'Din Tai', 09173334455, 'DL444333222SU', 'Available', '16:00:00'),
(1005, 'Robertson', 'Robert', 09176667788, 'DL888999000SU', 'Available', '12:00:00');

INSERT INTO Deliveries (DELIVERY_ID, ORDER_ID, DELIVERY_TYPE, DELIVERY_STATUS, DRIVER_ID, PAYMENT, EST_DELIVERY_TIME, ACT_DELIVERY_TIME, DELIVERY_FEE, DELIVERY_DATE) values
(2025000001, 1000000001, "Regular", "Pending", 1002, "Cash", 09:30:00, 09:31:00, 150, 2025-11-10),
(2025000002, 1000000002, "Regular", "Pending", 1004, "Cash", 14:03:00, 14:02:0, 150, 2025-08-15),
(2025000003, 1000000003, "Rush", "Pending", 1004, "Online", 18:44:00, 18:46:00, 250, 2025-10-10),
(2025000004, 1000000004, "Regular", "Pending", 1005, "Cash", 07:23:00, 07:23:00, 150, 2025-06-12),
(2025000005, 1000000005, "Rush", "Pending", 1001, "Online", 10:45:00, 10:50:00, 250, 2025-05-17);
