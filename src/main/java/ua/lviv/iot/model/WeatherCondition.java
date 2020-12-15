package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "weather_condition", schema = "AccuWeather")
public class WeatherCondition {
  private Integer id;
  private String description;
  private byte[] icon;
  private Byte day;
  private Byte night;

  public WeatherCondition() {
  }

  public WeatherCondition(Integer id, String description, byte[] icon, Byte day, Byte night) {
    this.id = id;
    this.description = description;
    this.icon = icon;
    this.day = day;
    this.night = night;
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
  @Column(name = "description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Basic
  @Column(name = "icon", columnDefinition = "BLOB")
  public byte[] getIcon() {
    return icon;
  }

  public void setIcon(byte[] icon) {
    this.icon = icon;
  }

  @Basic
  @Column(name = "day", columnDefinition = "BIT")
  public Byte getDay() {
    return day;
  }

  public void setDay(Byte day) {
    this.day = day;
  }

  @Basic
  @Column(name = "night", columnDefinition = "BIT")
  public Byte getNight() {
    return night;
  }

  public void setNight(Byte night) {
    this.night = night;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    WeatherCondition that = (WeatherCondition) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (description != null ? !description.equals(that.description) : that.description != null) return false;
    if (!Arrays.equals(icon, that.icon)) return false;
    if (day != null ? !day.equals(that.day) : that.day != null) return false;
    if (night != null ? !night.equals(that.night) : that.night != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (description != null ? description.hashCode() : 0);
    result = 31 * result + Arrays.hashCode(icon);
    result = 31 * result + (day != null ? day.hashCode() : 0);
    result = 31 * result + (night != null ? night.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return String.format("%-5d %-15s %-5s %-7s %s", id, description, day.toString(), night.toString(), Arrays.toString(icon));
  }
}
