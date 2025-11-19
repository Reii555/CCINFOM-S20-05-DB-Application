USE pickups;

CREATE TABLE Customers (
    customer_id DECIMAL(10,0) PRIMARY KEY,
    customer_lastname VARCHAR(20) NOT NULL,
    customer_firstname VARCHAR(20) NOT NULL,
    customer_address VARCHAR(50) NOT NULL
);
