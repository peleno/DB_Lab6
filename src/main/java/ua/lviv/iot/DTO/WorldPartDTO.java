package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import ua.lviv.iot.controller.CountryController;
import ua.lviv.iot.controller.WorldPartController;
import ua.lviv.iot.model.WorldPart;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class WorldPartDTO extends RepresentationModel<WorldPartDTO> {
  private final WorldPart worldPart;

  public WorldPartDTO(WorldPart worldPart) {
    this.worldPart = worldPart;
    Integer id = worldPart.getId();
    Link countriesLink = linkTo(methodOn(CountryController.class).getByWorldPartId(id)).withRel("countries").expand(id);
    add(linkTo(methodOn(WorldPartController.class).getWorldPart(id)).withSelfRel());
    add(countriesLink);
  }

  public WorldPart getWorldPart() {
    return this.worldPart;
  }
}
