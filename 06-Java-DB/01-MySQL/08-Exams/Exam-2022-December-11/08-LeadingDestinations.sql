SELECT c.name, c.currency, COUNT(*) AS booked_tickets
FROM flights_passengers fp
JOIN flights AS f 
    ON f.id = fp.flight_id
JOIN passengers p 
	ON p.id = fp.passenger_id
JOIN countries c 
	ON c.id = f.destination_country
GROUP by c.name
HAVING booked_tickets >= 20
ORDER BY booked_tickets DESC;