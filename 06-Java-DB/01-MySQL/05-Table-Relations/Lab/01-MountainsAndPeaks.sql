CREATE TABLE mountains (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE peaks (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    mountain_id INT NOT NULL,
	
    CONSTRAINT fk_peaks_mountains
    FOREIGN KEY (mountain_id)
    REFERENCES mountains (id)
);