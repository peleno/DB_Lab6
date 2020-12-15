package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.MonthlyForecast;
import ua.lviv.iot.model.MonthlyForecastPK;
import ua.lviv.iot.repository.MonthlyForecastRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MonthlyForecastService {

  @Autowired
  MonthlyForecastRepository monthlyForecastRepository;

  public List<MonthlyForecast> getAll() {
    return monthlyForecastRepository.findAll();
  }

  @Transactional
  public void create(MonthlyForecast monthlyForecast) {
    monthlyForecastRepository.save(monthlyForecast);
  }

  @Transactional
  public void delete(MonthlyForecastPK monthlyForecastPK) {
    MonthlyForecast monthlyForecast = monthlyForecastRepository.findById(monthlyForecastPK).orElse(null);
    if (monthlyForecast == null) {
      throw new RuntimeException("This monthly forecast is not found");
    }
    monthlyForecastRepository.delete(monthlyForecast);
  }
}
