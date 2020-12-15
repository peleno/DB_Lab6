package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "region", schema = "AccuWeather")
public class Region {
  private Integer id;
  private String name;
  private Country country;

  public Region() {
  }

  public Region(Integer id, String name, Country country) {
    this.id = id;
    this.name = name;
    this.country = country;
  }

  @Id
  @Column(name = "id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Basic
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

    Region region = (Region) o;

    if (id != null ? !id.equals(region.id) : region.id != null) return false;
    if (name != null ? !name.equals(region.name) : region.name != null) return false;

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
    return String.format("%-5d %-20s %d", id, name, country.getId());
  }

  @ManyToOne
  @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
  public Country getCountry() {
    return country;
  }

  public void setCountry(Country countryByCountryId) {
    this.country = countryByCountryId;
  }
}
