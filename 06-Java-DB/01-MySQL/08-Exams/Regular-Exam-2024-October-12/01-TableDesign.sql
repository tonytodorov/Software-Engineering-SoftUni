CREATE DATABASE summer_olympics;
USE summer_olympics;

CREATE TABLE sports (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE countries (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE medals (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE disciplines (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE,
    sport_id INT NOT NULL,
    
    CONSTRAINT fk_disciplines_sports
    FOREIGN KEY (sport_id)
    REFERENCES sports(id)
);


CREATE TABLE athletes (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(40) NOT NULL,
	last_name VARCHAR(40) NOT NULL,
    age INT,
    country_id INT NOT NULL,
        
    CONSTRAINT fk_athletes_countries
    FOREIGN KEY (country_id)
    REFERENCES countries(id)
);

CREATE TABLE disciplines_athletes_medals (
	discipline_id INT NOT NULL,
    athlete_id INT NOT NULL,
    medal_id INT NOT NULL,
    
    PRIMARY KEY(discipline_id, athlete_id),
    
    CONSTRAINT fk_disciplines_athletes_medals_disciplines
    FOREIGN KEY (discipline_id)
    REFERENCES disciplines(id),
    
	CONSTRAINT fk_disciplines_athletes_medals_athletes
    FOREIGN KEY (athlete_id)
    REFERENCES athletes(id),
	
    CONSTRAINT fk_disciplines_athletes_medals_medals
    FOREIGN KEY (medal_id)
    REFERENCES medals(id)
);