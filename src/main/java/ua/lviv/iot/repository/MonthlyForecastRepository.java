package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.MonthlyForecast;
import ua.lviv.iot.model.MonthlyForecastPK;

@Repository
public interface MonthlyForecastRepository extends JpaRepository<MonthlyForecast, MonthlyForecastPK> {
}
