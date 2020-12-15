package ua.lviv.iot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "world_part", schema = "AccuWeather")
public class WorldPart {
  private Integer id;
  private String name;
  @JsonIgnore
  private Set<Country> countries;

  public WorldPart() {
  }

  public WorldPart(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    WorldPart worldPart = (WorldPart) o;

    if (id != null ? !id.equals(worldPart.id) : worldPart.id != null) return false;
    if (name != null ? !name.equals(worldPart.name) : worldPart.name != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return String.format("%-5d %-5s", id, name);
  }

  @OneToMany(mappedBy = "worldPart")
  public Set<Country> getCountries() {
    return countries;
  }

  public void setCountries(Set<Country> countries) {
    this.countries = countries;
  }
}
