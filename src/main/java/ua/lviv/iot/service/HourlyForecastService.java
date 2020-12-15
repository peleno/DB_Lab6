package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.HourlyForecast;
import ua.lviv.iot.repository.HourlyForecastRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HourlyForecastService {

  @Autowired
  HourlyForecastRepository hourlyForecastRepository;

  public List<HourlyForecast> getAll() {
    return hourlyForecastRepository.findAll();
  }

  public HourlyForecast getById(Integer id) {
    return hourlyForecastRepository.findById(id).orElse(null);
  }

  @Transactional
  public void create(HourlyForecast hourlyForecast) {
    hourlyForecastRepository.save(hourlyForecast);
  }

  @Transactional
  public void update(HourlyForecast hourlyForecast) {
    HourlyForecast hourlyForecastInDB = getById(hourlyForecast.getId());
    if (hourlyForecastInDB == null) {
      throw new RuntimeException("This hourly forecast is not found");
    }
    hourlyForecastRepository.save(hourlyForecast);
  }

  @Transactional
  public void delete(Integer id) {
    HourlyForecast hourlyForecast = getById(id);
    if (hourlyForecast == null) {
      throw new RuntimeException("This hourly forecast is not found");
    }
    hourlyForecastRepository.delete(hourlyForecast);
  }
}
