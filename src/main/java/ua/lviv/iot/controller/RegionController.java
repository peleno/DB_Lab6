package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.DTO.RegionDTO;
import ua.lviv.iot.model.Region;
import ua.lviv.iot.service.RegionService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class RegionController {

  @Autowired
  RegionService regionService;

  @GetMapping(value = "/api/region")
  public ResponseEntity<List<RegionDTO>> getAll() {
    List<Region> regions = regionService.getAll();
    List<RegionDTO> regionsDTO = new ArrayList<>();
    for (Region region : regions) {
      regionsDTO.add(new RegionDTO(region));
    }
    return new ResponseEntity<>(regionsDTO, HttpStatus.OK);
  }

  @GetMapping(value = "/api/region/{id}")
  public ResponseEntity<RegionDTO> getById(@PathVariable Integer id){
    Region region = regionService.getById(id);
    if (region == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    RegionDTO regionDTO = new RegionDTO(region);
    return new ResponseEntity<>(regionDTO, HttpStatus.OK);
  }

  @GetMapping(value = "/api/region/{countryId}")
  public ResponseEntity<Set<RegionDTO>> getByCountryId(@PathVariable Integer countryId) {
    Set<Region> regions;
    try {
      regions = regionService.getByCountryId(countryId);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    Set<RegionDTO> regionsDTO = new HashSet<>();
    for (Region region : regions) {
      regionsDTO.add(new RegionDTO(region));
    }
    return new ResponseEntity<>(regionsDTO, HttpStatus.OK);
  }
}
