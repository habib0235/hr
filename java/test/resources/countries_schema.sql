CREATE SCHEMA IF NOT EXISTS main_schema;

DROP TABLE IF EXISTS main_schema.countries;
DROP TABLE IF EXISTS main_schema.regions;
CREATE TABLE main_schema.regions
(
    region_id int primary key auto_increment,
    region_name varchar(25)
);

CREATE TABLE main_schema.countries
(
    country_id character(2),
    country_name varchar(25),
    region_id integer,
    FOREIGN KEY (region_id)
        REFERENCES main_schema.regions (region_id)
);