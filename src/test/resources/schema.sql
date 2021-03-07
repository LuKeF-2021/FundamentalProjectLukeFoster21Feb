DROP TABLE IF EXISTS champion;
CREATE TABLE IF NOT EXISTS champion (
			champID LONG AUTO_INCREMENT,
			champ_name VARCHAR(20),
			champ_cost INT,
			champ_class VARCHAR(20),
			champ_roles VARCHAR(50),
			champ_release_year VARCHAR(10),
			champ_owned VARCHAR(10),
			champ_on_sale VARCHAR(10),
			PRIMARY KEY (champID)
	);