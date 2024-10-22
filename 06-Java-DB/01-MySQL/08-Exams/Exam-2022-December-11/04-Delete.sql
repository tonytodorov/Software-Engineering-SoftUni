DELETE f
FROM flights f
LEFT JOIN flights_passengers fp 
	ON f.id = fp.flight_id
WHERE fp.passenger_id IS NULL;