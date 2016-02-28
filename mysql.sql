CREATE TABLE search (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(50) NOT NULL, location VARCHAR(5), address VARCHAR(50), lat FLOAT, lon FLOAT, 
	created DATE, updated DATE, PRIMARY KEY (id));
CREATE TABLE tags(id INT NOT NULL AUTO_INCREMENT, search_id INT, tag VARCHAR(25) NOT NULL, PRIMARY KEY (id)
, FOREIGN KEY (search_id) REFERENCES search(id));