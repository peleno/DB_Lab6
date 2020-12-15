package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.WeatherCondition;
import ua.lviv.iot.repository.WeatherConditionRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WeatherConditionService {

  @Autowired
  WeatherConditionRepository weatherConditionRepository;

  public List<WeatherCondition> getAll() {
    return weatherConditionRepository.findAll();
  }

  public WeatherCondition getById(Integer id) {
    return weatherConditionRepository.findById(id).orElse(null);
  }

  @Transactional
  public void create(WeatherCondition weatherCondition) {
    weatherConditionRepository.save(weatherCondition);
  }

  @Transactional
  public void update(WeatherCondition weatherCondition) {
    WeatherCondition weatherConditionInDB = getById(weatherCondition.getId());
    if (weatherConditionInDB == null) {
      throw new RuntimeException("This weather condition is not found");
    }
    weatherConditionRepository.save(weatherCondition);
  }

  @Transactional
  public void delete(Integer id) {
    WeatherCondition weatherCondition = getById(id);
    if (weatherCondition == null) {
      throw new RuntimeException("This weather condition is not found");
    }
    weatherConditionRepository.delete(weatherCondition);
  }
}
