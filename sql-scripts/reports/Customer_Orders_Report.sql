-- customer orders report

SELECT		c.customer_id
			CONCAT(c.customer_lastname, ', ', c.customer_firstname) AS CustomerName,
            COUNT(DISTINCT d.delivery_id) AS Deliveries,
            COUNT(DISTINCT p.order_id) AS Pickups,
            SUM(
				CASE
					WHEN d.payment IS NOT NULL
                    THEN CAST (d.payment AS DECIMAL(10,2)) + d.delivery_fee
                    ELSE 0
				END
			) AS TotalTransactionAmount
FROM customers c
LEFT JOIN deliveries d
ON c.customer_id = d.driver_id
AND YEAR(d.delivery_date) = @year
AND MONTH(d.delivery_date) = @month
LEFT JOIN pickups p
ON c.customer_id = p.customer_id
AND YEAR(d.delivery_date) = @year
AND MONTH(d.delivery_date) = @month
GROUP BY c.customer_id, c.customer_lastname
ORDER BY
CustomerName ASC;