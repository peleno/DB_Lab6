package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import ua.lviv.iot.controller.CountryController;
import ua.lviv.iot.controller.RegionController;
import ua.lviv.iot.controller.WorldPartController;
import ua.lviv.iot.model.Country;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class CountryDTO extends RepresentationModel<CountryDTO> {
  Country country;

  public CountryDTO(Country country)  {
    this.country = country;
    Integer id = country.getId();
    Link regionsLink = linkTo(methodOn(RegionController.class).getByCountryId(id)).withRel("regions").expand(id);
    add(linkTo(methodOn(CountryController.class).getById(id)).withSelfRel());
    add(linkTo(methodOn(WorldPartController.class).getWorldPart(country.getWorldPart().getId())).withRel("worldPart"));
    add(regionsLink);
  }

  public Country getCountry() {
    return country;
  }
}
