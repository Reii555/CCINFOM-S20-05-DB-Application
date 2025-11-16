USE pickups;

CREATE TABLE Pickups (
ORDER_ID DECIMAL (10, 0) PRIMARY KEY,
ORDER_TYPE CHAR (15),
STATUS CHAR (10),
PICKUP_LOCATION VARCHAR (50),
PICKUP_DATE DATE,
PICKUP_SERVICE VARCHAR (20),
PAYMENT_METHOD CHAR (15) /*,
FOREIGN KEY (CUSTOMER_ID) REFERENCES Customers(CUSTOMER_ID) // Add when Customer table is ready !
 */
);

insert into Pickups(ORDER_ID, ORDER_TYPE, STATUS, PICKUP_LOCATION, PICKUP_DATE, PICKUP_SERVICE, PAYMENT_METHOD) values
(1000000001, 'Meal A', 'Pending', 'Sta. Ana branch', '2024-01-20', 'Express', 'Cash'),
(1000000002, 'Combo meal C', 'Ready', 'Malate branch', '2024-01-21', 'Standard', 'Credit'),
(1000000003, 'Combo meal D', 'Completed', 'Pasay branch', '2024-01-19', 'Express', 'Cash'),
(1000000004, 'Meal B', 'Pending', 'Antipolo branch', '2024-01-22', 'Standard', 'Debit'),
(1000000005, 'Meal A', 'Ready', 'Gen. Trias branch', '2024-01-21', 'Express', 'Credit');
