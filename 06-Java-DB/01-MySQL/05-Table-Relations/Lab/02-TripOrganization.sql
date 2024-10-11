SELECT vehicles.driver_id, vehicles.vehicle_type, 
CONCAT_WS(' ', campers.first_name, campers.last_name) AS driver_name
FROM vehicles
JOIN campers WHERE vehicles.driver_id = campers.id;