package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.WorldPartDTO;
import ua.lviv.iot.model.WorldPart;
import ua.lviv.iot.service.WorldPartService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WorldPartController {

  @Autowired
  WorldPartService worldPartService;

  @GetMapping(value = "/api/worldPart")
  public ResponseEntity<List<WorldPartDTO>> getAllWorldParts() {
    List<WorldPart> worldParts = worldPartService.getAllWorldParts();
    List<WorldPartDTO> worldPartsDTO = new ArrayList<>();
    for (WorldPart worldPart : worldParts) {
      worldPartsDTO.add(new WorldPartDTO(worldPart));
    }
    return new ResponseEntity<>(worldPartsDTO, HttpStatus.OK);
  }

  @GetMapping(value = "/api/worldPart/{id}")
  public ResponseEntity<WorldPartDTO> getWorldPart(@PathVariable Integer id) {
    WorldPart worldPart = worldPartService.getWorldPart(id);
    if (worldPart == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    WorldPartDTO worldPartDTO = new WorldPartDTO(worldPart);
    return new ResponseEntity<>(worldPartDTO, HttpStatus.OK);
  }

  @PostMapping(value = "/api/worldPart")
  public ResponseEntity<WorldPartDTO> createWorldPart(@RequestBody WorldPart worldPart) {
    worldPartService.createWorldPart(worldPart);
    WorldPartDTO worldPartDTO = new WorldPartDTO(worldPart);
    return new ResponseEntity<>(worldPartDTO, HttpStatus.CREATED);
  }

  @PutMapping(value = "/api/worldPart/{id}")
  public ResponseEntity<WorldPartDTO> updateWorldPart(@PathVariable Integer id, @RequestBody WorldPart worldPart) {
    worldPart.setId(id);
    try {
      worldPartService.updateWorldPart(worldPart);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    WorldPartDTO worldPartDTO = new WorldPartDTO(worldPart);
    return new ResponseEntity<>(worldPartDTO, HttpStatus.OK);
  }

  @DeleteMapping(value = "/api/worldPart/{id}")
  public ResponseEntity deleteWorldPart(@PathVariable Integer id) {
    try {
      worldPartService.deleteWorldPart(id);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
