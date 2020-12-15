package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.DailyForecast;

@Repository
public interface DailyForecastRepository extends JpaRepository<DailyForecast, Integer> {
}
