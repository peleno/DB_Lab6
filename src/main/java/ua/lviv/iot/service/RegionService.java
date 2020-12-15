package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Country;
import ua.lviv.iot.model.Region;
import ua.lviv.iot.repository.CountryRepository;
import ua.lviv.iot.repository.RegionRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class RegionService {

  @Autowired
  CountryRepository countryRepository;

  @Autowired
  RegionRepository regionRepository;

  public List<Region> getAll() {
    return regionRepository.findAll();
  }

  public Region getById(Integer id) {
    return regionRepository.findById(id).orElse(null);
  }

  public Set<Region> getByCountryId(Integer countryId) {
    Country country = countryRepository.findById(countryId).orElse(null);
    if (country == null) {
      throw new RuntimeException("This country is not found");
    }
    return country.getRegions();
  }

  @Transactional
  public void create(Region region) {
    regionRepository.save(region);
  }

  @Transactional
  public void update(Region region) {
    Region regionInDB = getById(region.getId());
    if (regionInDB == null) {
      throw new RuntimeException("This region is not found");
    }
    regionRepository.save(region);
  }

  @Transactional
  public void delete(Integer id) {
    Region region = getById(id);
    if (region == null) {
      throw new RuntimeException("This region is not found");
    }
    regionRepository.delete(region);
  }
}
