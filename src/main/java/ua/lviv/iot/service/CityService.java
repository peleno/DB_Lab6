package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.City;
import ua.lviv.iot.repository.CityRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CityService {

  @Autowired
  CityRepository cityRepository;

  public List<City> getAll() {
    return cityRepository.findAll();
  }

  public City getById(Integer id) {
    return cityRepository.findById(id).orElse(null);
  }

  @Transactional
  public void create(City city) {
    cityRepository.save(city);
  }

  @Transactional
  public void update(City city) {
    City cityInDB = getById(city.getId());
    if (cityInDB == null) {
      throw new RuntimeException("This city is not found");
    }
    cityRepository.save(city);
  }

  @Transactional
  public void delete(Integer id) {
    City city = getById(id);
    if (city == null) {
      throw new RuntimeException("This city is not found");
    }
    cityRepository.delete(city);
  }
}
