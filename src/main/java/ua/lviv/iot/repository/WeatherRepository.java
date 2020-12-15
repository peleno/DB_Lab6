package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {
}
