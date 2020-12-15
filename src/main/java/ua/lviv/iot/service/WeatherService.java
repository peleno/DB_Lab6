package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Weather;
import ua.lviv.iot.repository.WeatherRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WeatherService {

  @Autowired
  WeatherRepository weatherRepository;

  public List<Weather> getAll() {
    return weatherRepository.findAll();
  }

  public Weather getById(Integer id) {
    return weatherRepository.findById(id).orElse(null);
  }

  @Transactional
  public void create(Weather weather) {
    weatherRepository.save(weather);
  }

  @Transactional
  public void update(Weather weather) {
    Weather weatherInDB = getById(weather.getId());
    if (weatherInDB == null) {
      throw new RuntimeException("This weather is not found");
    }
    weatherRepository.save(weather);
  }

  @Transactional
  public void delete(Integer id) {
    Weather weather = getById(id);
    if (weather == null) {
      throw new RuntimeException("This weather is not found");
    }
    weatherRepository.delete(weather);
  }
}
