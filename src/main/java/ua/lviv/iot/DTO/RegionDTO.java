package ua.lviv.iot.DTO;

import org.springframework.hateoas.RepresentationModel;
import ua.lviv.iot.controller.RegionController;
import ua.lviv.iot.model.Region;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class RegionDTO extends RepresentationModel<RegionDTO> {
  Region region;

  public RegionDTO(Region region) {
    this.region = region;
    Integer id = region.getId();
    add(linkTo(methodOn(RegionController.class).getById(id)).withSelfRel());
  }

  public Region getRegion() {
    return this.region;
  }
}
