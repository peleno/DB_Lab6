package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "hourly_forecast", schema = "AccuWeather")
public class HourlyForecast {
  private Integer id;
  private Integer hour;
  private DailyForecast dailyForecastByDailyForecastId;
  private Weather weatherByWeatherId;
  private Set<City> cities;


  public HourlyForecast() {
  }

  public HourlyForecast(Integer id, Integer hour, DailyForecast dailyForecastByDailyForecastId, Weather weatherByWeatherId) {
    this.id = id;
    this.hour = hour;
    this.dailyForecastByDailyForecastId = dailyForecastByDailyForecastId;
    this.weatherByWeatherId = weatherByWeatherId;
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
  @Column(name = "hour")
  public Integer getHour() {
    return hour;
  }

  public void setHour(Integer hour) {
    this.hour = hour;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    HourlyForecast that = (HourlyForecast) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (hour != null ? !hour.equals(that.hour) : that.hour != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (hour != null ? hour.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return String.format("%-5d %-5d %-20d %d", id, hour, dailyForecastByDailyForecastId.getId(), weatherByWeatherId.getId());
  }

  @ManyToOne
  @JoinColumn(name = "daily_forecast_id", referencedColumnName = "id", nullable = false)
  public DailyForecast getDailyForecastByDailyForecastId() {
    return dailyForecastByDailyForecastId;
  }

  public void setDailyForecastByDailyForecastId(DailyForecast dailyForecastByDailyForecastId) {
    this.dailyForecastByDailyForecastId = dailyForecastByDailyForecastId;
  }

  @ManyToOne
  @JoinColumn(name = "weather_id", referencedColumnName = "id", nullable = false)
  public Weather getWeatherByWeatherId() {
    return weatherByWeatherId;
  }

  public void setWeatherByWeatherId(Weather weatherByWeatherId) {
    this.weatherByWeatherId = weatherByWeatherId;
  }

  @ManyToMany
  @JoinTable(name = "hourly_forecast_for_city", schema = "AccuWeather",
      joinColumns = @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false),
      inverseJoinColumns = @JoinColumn(name = "hourly_forecast_id", referencedColumnName = "id", nullable = false))
  public Set<City> getCities() {
    return cities;
  }

  public void setCities(Set<City> cities) {
    this.cities = cities;
  }
}
