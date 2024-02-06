#we create this based on a uml, where produce is a super class, frozen is sub class
#and there is an attribute in produce class called harvestDate is an attribute you caculate in the constrcutor
CREATE TABLE produce(
	produce_id INT AUTO_INCREMENT,
    veg_type VARCHAR(50) NOT NULL,
    variety VARCHAR(50) NOT NULL,
    sow_date DATE NOT NULL,
    grow_day INT NOT NULL,
    lot_number VARCHAR(50) NOT NULL,
    PRIMARY KEY (produce_id)
);

CREATE TABLE frozen_produce(
	frozen_produce_id INT AUTO_INCREMENT,
    freeze_date DATE NOT NULL,
    best_before DATE NOT NULL,
    produce_id INT NOT NULL,
    PRIMARY KEY (frozen_produce_id),
    FOREIGN KEY (produce_id) REFERENCES produce(produce_id)
);

INSERT INTO produce (veg_type, variety, sow_date, grow_day, lot_number)
	VALUES ('Beans', 'Fandango', '2023-05-28', 55, 'lotc1992');
INSERT INTO produce (veg_type, variety, sow_date, grow_day, lot_number)
	VALUES ('Carrot', 'Autum King', '2023-05-28', 70, 'lotc1993');
INSERT INTO produce (veg_type, variety, sow_date, grow_day, lot_number)
	VALUES ('Onion', 'Nebula', '2023-05-28', 175, 'lotc1994');
INSERT INTO produce (veg_type, variety, sow_date, grow_day, lot_number)
	VALUES ('Kale', 'Squire', '2023-05-28', 60, 'lotc1995');
INSERT INTO produce (veg_type, variety, sow_date, grow_day, lot_number)
	VALUES ('Potato', 'Yukon Gem', '2023-05-28', 112, 'lotc1996');
	
SELECT *,
	DATE_ADD(sow_date,INTERVAL grow_day DAY) AS harvest_date #new
 FROM produce;

INSERT INTO produce (veg_type, variety, sow_date, grow_day, lot_number)
	VALUES ('Basil', 'Genovese', '2023-05-28', 10, 'lotc1997');

SELECT * FROM produce;
INSERT INTO frozen_produce (produce_id, freeze_date, best_before)
	VALUES (1, '2023-08-31', '2023-12-29');
SELECT * FROM frozen_produce;

CREATE VIEW v_produce AS
SELECT *,
	DATE_ADD(sow_date,INTERVAL grow_day DAY) AS harvest_date
 FROM produce;
 
SELECT * FROM v_produce;