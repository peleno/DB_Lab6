package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "city", schema = "AccuWeather")
public class City {
  private Integer id;
  private String name;
  private Region regionByRegionId;
  private Set<HourlyForecast> hourlyForecasts;

  public City() {
  }

  public City(Integer id, String name, Region regionByRegionId) {
    this.id = id;
    this.name = name;
    this.regionByRegionId = regionByRegionId;
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

    City city = (City) o;

    if (id != null ? !id.equals(city.id) : city.id != null) return false;
    if (name != null ? !name.equals(city.name) : city.name != null) return false;

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
    return String.format("%-5d %-20s %d", id, name, getRegionByRegionId().getId());
  }

  @ManyToOne
  @JoinColumn(name = "region_id", referencedColumnName = "id", nullable = false)
  public Region getRegionByRegionId() {
    return regionByRegionId;
  }

  public void setRegionByRegionId(Region regionByRegionId) {
    this.regionByRegionId = regionByRegionId;
  }

  @ManyToMany(mappedBy = "cities")
  public Set<HourlyForecast> getHourlyForecasts() {
    return hourlyForecasts;
  }

  public void setHourlyForecasts(Set<HourlyForecast> hourlyForecasts) {
    this.hourlyForecasts = hourlyForecasts;
  }
}
