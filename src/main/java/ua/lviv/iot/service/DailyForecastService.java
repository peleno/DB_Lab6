package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.DailyForecast;
import ua.lviv.iot.repository.DailyForecastRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DailyForecastService {

  @Autowired
  DailyForecastRepository dailyForecastRepository;

  public List<DailyForecast> getAll() {
    return dailyForecastRepository.findAll();
  }

  public DailyForecast getById(Integer id) {
    return dailyForecastRepository.findById(id).orElse(null);
  }

  @Transactional
  public void create(DailyForecast dailyForecast) {
    dailyForecastRepository.save(dailyForecast);
  }

  @Transactional
  public void update(DailyForecast dailyForecast) {
    DailyForecast dailyForecastInDB = getById(dailyForecast.getId());
    if (dailyForecastInDB == null) {
      throw new RuntimeException("This daily forecast is not found");
    }
    dailyForecastRepository.save(dailyForecast);
  }

  @Transactional
  public void delete(Integer id) {
    DailyForecast dailyForecast = getById(id);
    if (dailyForecast == null) {
      throw new RuntimeException("This daily forecast is not found");
    }
    dailyForecastRepository.delete(dailyForecast);
  }
}
