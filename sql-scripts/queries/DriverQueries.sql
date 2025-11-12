-- get available driver
SELECT 			DRIVER_ID, DRIVER_FIRSTNAME, DRIVER_LASTNAME, SHIFT 
FROM 			Drivers 
WHERE STATUS =  'Available' 
AND 			SHIFT = ?;

-- update driver to busy
UPDATE 			Drivers 
SET STATUS =    'Busy' 
WHERE 			DRIVER_ID = ?;

-- update driver to available
UPDATE 			Drivers 
SET STATUS = 	'Available' 
WHERE	 		DRIVER_ID = ?;

-- check if driver shift is within timeframe of delivery 
SELECT 			DRIVER_ID 
FROM 			Drivers 
WHERE STATUS =  'Available' 
AND SHIFT BETWEEN ? AND ?;