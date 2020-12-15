package ua.lviv.iot.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "precipitation", schema = "AccuWeather")
public class Precipitation {
  private Integer id;
  private BigDecimal rain;
  private BigDecimal snow;
  private BigDecimal ice;

  public Precipitation() {
  }

  public Precipitation(Integer id, BigDecimal rain, BigDecimal snow, BigDecimal ice) {
    this.id = id;
    this.rain = rain;
    this.snow = snow;
    this.ice = ice;
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
  @Column(name = "rain")
  public BigDecimal getRain() {
    return rain;
  }

  public void setRain(BigDecimal rain) {
    this.rain = rain;
  }

  @Basic
  @Column(name = "snow")
  public BigDecimal getSnow() {
    return snow;
  }

  public void setSnow(BigDecimal snow) {
    this.snow = snow;
  }

  @Basic
  @Column(name = "ice")
  public BigDecimal getIce() {
    return ice;
  }

  public void setIce(BigDecimal ice) {
    this.ice = ice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Precipitation that = (Precipitation) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (rain != null ? !rain.equals(that.rain) : that.rain != null) return false;
    if (snow != null ? !snow.equals(that.snow) : that.snow != null) return false;
    if (ice != null ? !ice.equals(that.ice) : that.ice != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (rain != null ? rain.hashCode() : 0);
    result = 31 * result + (snow != null ? snow.hashCode() : 0);
    result = 31 * result + (ice != null ? ice.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return String.format("%-5d %-8.2f %-8.2f %-8.2f", id, rain, snow, ice);
  }
}
