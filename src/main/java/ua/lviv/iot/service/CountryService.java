package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Country;
import ua.lviv.iot.model.WorldPart;
import ua.lviv.iot.repository.CountryRepository;
import ua.lviv.iot.repository.WorldPartRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class CountryService {
  @Autowired
  CountryRepository countryRepository;
  @Autowired
  WorldPartRepository worldPartRepository;

  public List<Country> getAll() {
    return countryRepository.findAll();
  }

  public Country getById(Integer id) {
    return countryRepository.findById(id).orElse(null);
  }

  public Set<Country> getByWorldPartId(Integer worldPartId) {
    WorldPart worldPart = worldPartRepository.findById(worldPartId).orElse(null);
    if (worldPart == null) {
      throw new RuntimeException("This world part is not found");
    }
    return worldPart.getCountries();
  }

  @Transactional
  public void create(Country country) {
    countryRepository.save(country);
  }

  @Transactional
  public void update(Country country) {
    Country countryInDB = getById(country.getId());
    System.out.println(countryInDB);
    if (countryInDB == null) {
      throw new RuntimeException("This country not found");
    }
    countryRepository.save(country);
  }

  @Transactional
  public void delete(Integer id) {
    Country country = getById(id);
    if (country == null) {
      throw new RuntimeException("This country not found");
    }
    countryRepository.delete(country);
  }
}
