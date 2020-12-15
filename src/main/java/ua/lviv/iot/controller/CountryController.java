package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.CountryDTO;
import ua.lviv.iot.model.Country;
import ua.lviv.iot.service.CountryService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class CountryController {
  @Autowired
  CountryService countryService;

  @GetMapping(value = "/api/country")
  public ResponseEntity<List<CountryDTO>> getAll() {
    List<Country> countries = countryService.getAll();
    List<CountryDTO> countriesDTO = new ArrayList<>();
    for (Country country : countries) {
      countriesDTO.add(new CountryDTO(country));
    }
    return new ResponseEntity<>(countriesDTO, HttpStatus.OK);
  }

  @GetMapping(value = "/api/country/{id}")
  public ResponseEntity<CountryDTO> getById(@PathVariable Integer id) {
    Country country = countryService.getById(id);
    if (country == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    CountryDTO countryDTO = new CountryDTO(country);
    return new ResponseEntity<>(countryDTO, HttpStatus.OK);
  }

  @GetMapping(value = "/api/country/worldPart/{worldPartId}")
  public ResponseEntity<Set<CountryDTO>> getByWorldPartId(@PathVariable Integer worldPartId) {
    Set<Country> countries;
    try {
      countries = countryService.getByWorldPartId(worldPartId);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    Set<CountryDTO> countriesDTO = new HashSet<>();
    for (Country country : countries) {
      countriesDTO.add(new CountryDTO(country));
    }
    return new ResponseEntity<>(countriesDTO, HttpStatus.OK);
  }

  @PostMapping(value = "/api/country")
  public ResponseEntity<CountryDTO> create(@RequestBody Country country) {
    countryService.create(country);
    CountryDTO countryDTO = new CountryDTO(country);
    System.out.println(country);
    return new ResponseEntity<>(countryDTO, HttpStatus.CREATED);
  }

  @PutMapping(value = "/api/country/{id}")
  public ResponseEntity<CountryDTO> update(@PathVariable Integer id, @RequestBody Country country) {
    country.setId(id);
    try {
      countryService.update(country);
    } catch (RuntimeException e) {
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    CountryDTO countryDTO = new CountryDTO(country);
    return new ResponseEntity<>(countryDTO, HttpStatus.OK);
  }

  @DeleteMapping(value = "/api/country/{id}")
  public ResponseEntity delete(@PathVariable Integer id) {
    try {
      countryService.delete(id);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
