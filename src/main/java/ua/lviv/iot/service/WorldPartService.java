package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.WorldPart;
import ua.lviv.iot.repository.WorldPartRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WorldPartService {
  @Autowired
  WorldPartRepository worldPartRepository;

  public List<WorldPart> getAllWorldParts() {
    return worldPartRepository.findAll();
  }

  public WorldPart getWorldPart(Integer id) {
    return worldPartRepository.findById(id).orElse(null);
  }

  @Transactional
  public void createWorldPart(WorldPart worldPart) {
    worldPartRepository.save(worldPart);
  }

  @Transactional
  public void updateWorldPart(WorldPart worldPart) {
    Integer id = worldPart.getId();
    WorldPart worldPartInDB = worldPartRepository.findById(id).orElse(null);
    if (worldPartInDB == null) {
      throw new RuntimeException("Such world part is not found");
    }
    worldPartRepository.save(worldPart);
  }

  @Transactional
  public void deleteWorldPart(Integer id) {
    WorldPart worldPart = worldPartRepository.findById(id).orElse(null);
    if (worldPart == null) {
      throw new RuntimeException("Such world part is not found");
    }
    worldPartRepository.delete(worldPart);
  }
}
