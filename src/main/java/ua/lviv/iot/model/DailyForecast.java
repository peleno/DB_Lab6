package ua.lviv.iot.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "daily_forecast", schema = "AccuWeather")
public class DailyForecast {
  private Integer id;
  private Integer day;
  private Time sunrise;
  private Time sunset;
  private Time moonrise;
  private Time moonset;
  private MonthlyForecast monthlyForecast;

  public DailyForecast() {
  }

  public DailyForecast(Integer id, Integer day, Time sunrise, Time sunset, Time moonrise, Time moonset, MonthlyForecast monthlyForecast) {
    this.id = id;
    this.day = day;
    this.sunrise = sunrise;
    this.sunset = sunset;
    this.moonrise = moonrise;
    this.moonset = moonset;
    this.monthlyForecast = monthlyForecast;
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
  @Column(name = "day")
  public Integer getDay() {
    return day;
  }

  public void setDay(Integer day) {
    this.day = day;
  }

  @Basic
  @Column(name = "sunrise")
  public Time getSunrise() {
    return sunrise;
  }

  public void setSunrise(Time sunrise) {
    this.sunrise = sunrise;
  }

  @Basic
  @Column(name = "sunset")
  public Time getSunset() {
    return sunset;
  }

  public void setSunset(Time sunset) {
    this.sunset = sunset;
  }

  @Basic
  @Column(name = "moonrise")
  public Time getMoonrise() {
    return moonrise;
  }

  public void setMoonrise(Time moonrise) {
    this.moonrise = moonrise;
  }

  @Basic
  @Column(name = "moonset")
  public Time getMoonset() {
    return moonset;
  }

  public void setMoonset(Time moonset) {
    this.moonset = moonset;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    DailyForecast that = (DailyForecast) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (day != null ? !day.equals(that.day) : that.day != null) return false;
    if (sunrise != null ? !sunrise.equals(that.sunrise) : that.sunrise != null) return false;
    if (sunset != null ? !sunset.equals(that.sunset) : that.sunset != null) return false;
    if (moonrise != null ? !moonrise.equals(that.moonrise) : that.moonrise != null) return false;
    if (moonset != null ? !moonset.equals(that.moonset) : that.moonset != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (day != null ? day.hashCode() : 0);
    result = 31 * result + (sunrise != null ? sunrise.hashCode() : 0);
    result = 31 * result + (sunset != null ? sunset.hashCode() : 0);
    result = 31 * result + (moonrise != null ? moonrise.hashCode() : 0);
    result = 31 * result + (moonset != null ? moonset.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return String.format("%-5d %-5d %-10s %-10s %-10s %-10s %-25s %s", id, day, sunrise, sunset, moonrise, moonset, monthlyForecast.getYear(), monthlyForecast.getMonth());
  }

  @ManyToOne
  @JoinColumns({@JoinColumn(name = "monthly_forecast_year", referencedColumnName = "year", nullable = false), @JoinColumn(name = "monthly_forecast_month", referencedColumnName = "month", nullable = false)})
  public MonthlyForecast getMonthlyForecast() {
    return monthlyForecast;
  }

  public void setMonthlyForecast(MonthlyForecast monthlyForecast) {
    this.monthlyForecast = monthlyForecast;
  }
}
