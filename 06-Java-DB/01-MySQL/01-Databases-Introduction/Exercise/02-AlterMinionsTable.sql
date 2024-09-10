ALTER TABLE minions
ADD COLUMN town_id INT;

ALTER TABLE towns
RENAME COLUMN town_id to id;

ALTER TABLE minions
ADD CONSTRAINT fk_town_id
FOREIGN KEY(town_id) REFERENCES towns(id)