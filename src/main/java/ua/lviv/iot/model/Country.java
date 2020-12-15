package ua.lviv.iot.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "country", schema = "AccuWeather")
public class Country {
  private Integer id;
  private String name;
  @JsonIgnore
  private WorldPart worldPart;
  @JsonIgnore
  private Set<Region> regions;

  public Country() {
  }

  public Country(Integer id, String name, WorldPart worldPart) {
    this.id = id;
    this.name = name;
    this.worldPart = worldPart;
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

    Country country = (Country) o;

    if (id != null ? !id.equals(country.id) : country.id != null) return false;
    if (name != null ? !name.equals(country.name) : country.name != null) return false;

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
    return String.format("%-5d %-20s %d", id, name, worldPart.getId());
  }

  @ManyToOne
  @JoinColumn(name = "world_part_id", referencedColumnName = "id", nullable = false)
  @JsonIgnore
  public WorldPart getWorldPart() {
    return worldPart;
  }

  @JsonProperty
  public void setWorldPart(WorldPart worldPartByWorldPartId) {
    this.worldPart = worldPartByWorldPartId;
  }

  @OneToMany(mappedBy = "country")
  public Set<Region> getRegions() {
    return regions;
  }

  public void setRegions(Set<Region> regions) {
    this.regions = regions;
  }
}
