package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Precipitation;
import ua.lviv.iot.repository.PrecipitationRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PrecipitationService {

  @Autowired
  PrecipitationRepository precipitationRepository;

  public List<Precipitation> getAll() {
    return precipitationRepository.findAll();
  }

  public Precipitation getById(Integer id) {
    return precipitationRepository.findById(id).orElse(null);
  }

  @Transactional
  public void create(Precipitation precipitation) {
    precipitationRepository.save(precipitation);
  }

  @Transactional
  public void update(Precipitation precipitation) {
    Precipitation precipitationInDB = getById(precipitation.getId());
    if (precipitationInDB == null) {
      throw new RuntimeException("This precipitation is not found");
    }
    precipitationRepository.save(precipitation);
  }

  @Transactional
  public void delete(Integer id) {
    Precipitation precipitation = getById(id);
    if (precipitation == null) {
      throw new RuntimeException("This precipitation is not found");
    }
    precipitationRepository.delete(precipitation);
  }
}
