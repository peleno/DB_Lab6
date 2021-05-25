CREATE DATABASE IF NOT EXISTS AccuWeather;
USE AccuWeather;

DROP TABLE IF EXISTS hourly_forecast_for_city;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS region;
DROP TABLE IF EXISTS country;
DROP TABLE IF EXISTS world_part;
DROP TABLE IF EXISTS hourly_forecast;
DROP TABLE IF EXISTS daily_forecast;
DROP TABLE IF EXISTS monthly_forecast;
DROP TABLE IF EXISTS weather;
DROP TABLE IF EXISTS weather_condition;
DROP TABLE IF EXISTS precipitation;

CREATE TABLE precipitation (
    id	int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    rain decimal(4, 1) NOT NULL,
    snow decimal(4, 1) NOT NULL,
    ice decimal(4, 1) NOT NULL
);

CREATE TABLE weather_condition (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description varchar(50) NOT NULL,
    icon blob,
    day bool NOT NULL,
    night bool NOT NULL
);

CREATE TABLE weather (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    temperature int NOT NULL,
    real_feel_temperature int NOT NULL,
    water_temperature int NULL,
    humidity int NOT NULL,
    indoor_humidity int NOT NULL,
    pressure int NOT NULL,
    wind_speed int NOT NULL,
    wind_direction varchar(3) NOT NULL,
    wind_gusts int NOT NULL,
    dew_point int NOT NULL,
    cloud_ceiling int NOT NULL,
    precipitation_probability int NOT NULL,
    precipitation_id int NOT NULL,
    weather_condition_id int NOT NULL,
    thunderstorm_probability int NOT NULL
);

CREATE TABLE monthly_forecast (
    year int NOT NULL AUTO_INCREMENT,
    month varchar(10) NOT NULL,
    CONSTRAINT monthly_forecast_pk PRIMARY KEY (year,month)
);

CREATE TABLE daily_forecast (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    day int NOT NULL,
    sunrise time NOT NULL,
    sunset time NOT NULL,
    moonrise time NOT NULL,
    moonset time NOT NULL,
    monthly_forecast_year int NOT NULL,
    monthly_forecast_month varchar(10) NOT NULL
);

CREATE TABLE hourly_forecast (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    hour int NOT NULL,
    daily_forecast_id int NOT NULL,
    weather_id int NOT NULL
);

CREATE TABLE world_part (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(20) NOT NULL
);

CREATE TABLE country (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    world_part_id int NOT NULL
);

CREATE TABLE region (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    country_id int NOT NULL
);

CREATE TABLE city (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    region_id int NOT NULL
);

CREATE TABLE hourly_forecast_for_city (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    city_id int NOT NULL,
    hourly_forecast_id int NOT NULL
);

ALTER TABLE weather ADD (
    CONSTRAINT weather_condition_fk FOREIGN KEY (weather_condition_id) REFERENCES weather_condition(id),
    CONSTRAINT precipitation_fk FOREIGN KEY (precipitation_id) REFERENCES precipitation(id)
);

ALTER TABLE daily_forecast ADD 
    CONSTRAINT monthly_forecast_fk 
        FOREIGN KEY (monthly_forecast_year, monthly_forecast_month) REFERENCES monthly_forecast(year, month);
        
ALTER TABLE hourly_forecast ADD (
    CONSTRAINT daily_forecast_fk FOREIGN KEY (daily_forecast_id) REFERENCES daily_forecast(id),
    CONSTRAINT weather_fk FOREIGN KEY (weather_id) REFERENCES weather(id)
);

ALTER TABLE hourly_forecast_for_city ADD (
    CONSTRAINT hourly_forecast_fk FOREIGN KEY (hourly_forecast_id) REFERENCES hourly_forecast(id),
    CONSTRAINT city_fk FOREIGN KEY (city_id) REFERENCES city(id)
);

ALTER TABLE city ADD 
    CONSTRAINT region_fk FOREIGN KEY (region_id) REFERENCES region(id);

ALTER TABLE region ADD 
    CONSTRAINT country_fk FOREIGN KEY (country_id) REFERENCES country(id);

ALTER TABLE country ADD
    CONSTRAINT world_part_fk FOREIGN KEY (world_part_id) REFERENCES world_part(id);

CREATE INDEX city_index ON city(name);
CREATE INDEX year_month_index ON monthly_forecast(year, month);

INSERT INTO world_part(name) VALUES
('Europe'), 
('North America'),
('Africa'),
('Antarctica'),
('Arctic'),
('Asia'),
('Central America'),
('Middle East'),
('Oceania'),
('South America');

INSERT INTO country(name, world_part_id) VALUES
('Austria', 1),
('Finland', 1),
('France', 1),
('Germany', 1),
('Norway', 1),
('Poland', 1),
('Spain', 1),
('Turkey', 1),
('Ukraine', 1),
('United Kingdom', 1);

INSERT INTO region(name, country_id) VALUES
('Chernivtsi', 9),
('Crimea', 9),
('Kharkiv', 9),
('Kherson', 9),
('Kyiv', 9),
('Lviv', 9),
('Poltava', 9),
('Ternopil', 9),
('Volyn', 9),
('Zaporizhzhya', 9);

INSERT INTO city(name, region_id) VALUES
('Bibrka', 6),
('Brody', 6),
('Busk', 6),
('Chervonohrad', 6),
('Davydiv', 6),
('Drohobych', 6),
('Lviv', 6),
('Peremyshliany', 6),
('Vynnyky', 6),
('Yavoriv', 6);

INSERT INTO precipitation(rain, snow, ice) VALUES
(0.0, 0.0, 0.0),
(2.0, 0.0, 0.0),
(5.0, 0.0, 0.0),
(3.0, 6.0, 0.0),
(0.0, 3.0, 6.0),
(10.0, 4.0, 5.0),
(0.0, 0.0, 3.0),
(3.1, 0.0, 0.0),
(4.0, 6.0, 0.0),
(3.0, 0.0, 0.0);

INSERT INTO weather_condition(description, icon, day, night) VALUES
('Sunny', NULL, 1, 0),
('Partly Sunny', NULL, 1, 0),
('Mostly Cloudy', NULL, 1, 0),
('Cloudy', NULL, 1, 1),
('Dreary', NULL, 1, 1),
('Fog', NULL, 1, 1),
('Showers', NULL, 1, 1),
('Rain', NULL, 1, 1),
('Snow', NULL, 1, 1),
('Windy', NULL, 1, 1);

INSERT INTO weather(temperature, real_feel_temperature, water_temperature, humidity, indoor_humidity, pressure, wind_speed,
wind_direction, wind_gusts, dew_point, cloud_ceiling, precipitation_probability, precipitation_id, weather_condition_id,
thunderstorm_probability) VALUES
(20, 19, NULL, 35, 35, 760, 13, 'S', 15, 8, 0, 0, 1, 1, 0),
(16, 15, NULL, 33, 33, 733, 13, 'E', 16, 9, 33, 0, 1, 1, 0),
(15, 15, NULL, 29, 28, 732, 11, 'NNE', 13, 7, 9, 0, 1, 1, 0),
(17, 16, NULL, 41, 41, 733, 11, 'NE', 14, 10, 0, 0, 1, 1, 0),
(20, 20, NULL, 52, 51, 731, 15, 'SSW', 16, 9, 0, 39, 2, 4, 0),
(14, 14, NULL, 66, 65, 729, 16, 'ESE', 16, 9, 0, 56, 2, 8, 0),
(15, 14, NULL, 74, 56, 734, 13, 'E', 15, 9, 0, 33, 2, 4, 0),
(13, 13, NULL, 77, 45, 729, 12, 'W', 18, 8, 20, 22, 3, 4, 0),
(16, 15, NULL, 50, 50, 733, 7, 'N', 11, 7, 50, 67, 3, 8, 5),
(8, 8, NULL, 45, 34, 740, 16, 'WNW', 20, 6, 70, 14, 3, 8, 0);

INSERT INTO monthly_forecast(year, month) VALUES
(2020, 'December'),
(2020, 'November'),
(2020, 'October'),
(2020, 'September'),
(2021, 'April'),
(2021, 'February'),
(2021, 'January'),
(2021, 'June'),
(2021, 'March'),
(2021, 'May');

INSERT INTO daily_forecast(day, sunrise, sunset, moonrise, moonset, monthly_forecast_year, monthly_forecast_month) VALUES
(10, '07:43:00', '18:36:00', '02:35:00', '17:39:00', 2020, 'October'),
(11, '07:45:00', '18:34:00', '03:58:00', '18:02:00', 2020, 'October'),
(12, '07:46:00', '18:32:00', '05:22:00', '18:24:00', 2020, 'October'),
(13, '07:48:00', '18:30:00', '06:46:00', '18:46:00', 2020, 'October'),
(14, '07:49:00', '18:28:00', '08:14:00', '19:09:00', 2020, 'October'),
(15, '07:51:00', '18:26:00', '09:42:00', '19:36:00', 2020, 'October'),
(16, '07:53:00', '18:24:00', '11:09:00', '20:08:00', 2020, 'October'),
(17, '07:54:00', '18:22:00', '12:31:00', '20:48:00', 2020, 'October'),
(18, '07:56:00', '18:20:00', '13:44:00', '21:39:00', 2020, 'October'),
(19, '07:58:00', '18:18:00', '14:44:00', '22:39:00', 2020, 'October');

INSERT INTO hourly_forecast(hour, daily_forecast_id, weather_id) VALUES
(6, 5, 1),
(7, 5, 2),
(8, 5, 2),
(9, 5, 3),
(10, 5, 2),
(11, 5, 1),
(12, 5, 4),
(13, 5, 1),
(14, 5, 2),
(15, 5, 3);

INSERT INTO hourly_forecast_for_city(city_id, hourly_forecast_id) VALUES
(7, 1),
(7, 2),
(7, 3),
(7, 4),
(7, 5),
(7, 6),
(7, 7),
(7, 8),
(7, 9),
(7, 10);

