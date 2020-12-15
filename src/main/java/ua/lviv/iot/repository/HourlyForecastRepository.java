package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.HourlyForecast;

@Repository
public interface HourlyForecastRepository extends JpaRepository<HourlyForecast, Integer> {
}
