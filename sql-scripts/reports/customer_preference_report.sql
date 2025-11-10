SELECT
	c.CUSTOMER_ID,
    c.CUSTOMER_FIRSTNAME,
    c.CUSTOMER_LASTNAME,
    (SELECT COUNT(*) FROM Delivery d WHERE d.CUSTOMER_ID =c.CUSTOMER_ID) as Delivery_Count,
    (SELECT COUNT(*) FROM Pickups p WHERE p.CUSTOMER_ID = c>CUSTOMER_ID) as Pickcup_Count,
CASE
	WHEN (SELECT COUNT(*) FROM Delivery d WHERE d.CUSTOMER_ID = c.CUSTOMER_ID) > 
		 (SELECT COUNT(*) FROM Pickups p WHERE p.CUSTOMER_ID = c.CUSTOMER_ID) THEN 'Delivery'
         ELSE 'Pickup'
         END as Preferred_Method
	FROM Customers c
    ORDER BY c.CUSTOMER_ID;