CREATE SCHEMA IF NOT EXISTS main_schema;

DROP TABLE IF EXISTS main_schema.regions;
CREATE TABLE main_schema.regions
(
    region_id int primary key auto_increment,
    region_name varchar(25)
);