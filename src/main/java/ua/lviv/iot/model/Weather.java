package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "weather", schema = "AccuWeather")
public class Weather {
  private Integer id;
  private Integer temperature;
  private Integer realFeelTemperature;
  private Integer waterTemperature;
  private Integer humidity;
  private Integer indoorHumidity;
  private Integer pressure;
  private Integer windSpeed;
  private String windDirection;
  private Integer windGusts;
  private Integer dewPoint;
  private Integer cloudCeiling;
  private Integer precipitationProbability;
  private Integer thunderstormProbability;
  private Precipitation precipitationByPrecipitationId;
  private WeatherCondition weatherConditionByWeatherConditionId;

  public Weather() {
  }

  public Weather(Integer id, Integer temperature, Integer realFeelTemperature, Integer waterTemperature, Integer humidity, Integer indoorHumidity, Integer pressure, Integer windSpeed, String windDirection, Integer windGusts, Integer dewPoint, Integer cloudCeiling, Integer precipitationProbability, Integer thunderstormProbability, Precipitation precipitationByPrecipitationId, WeatherCondition weatherConditionByWeatherConditionId) {
    this.id = id;
    this.temperature = temperature;
    this.realFeelTemperature = realFeelTemperature;
    this.waterTemperature = waterTemperature;
    this.humidity = humidity;
    this.indoorHumidity = indoorHumidity;
    this.pressure = pressure;
    this.windSpeed = windSpeed;
    this.windDirection = windDirection;
    this.windGusts = windGusts;
    this.dewPoint = dewPoint;
    this.cloudCeiling = cloudCeiling;
    this.precipitationProbability = precipitationProbability;
    this.thunderstormProbability = thunderstormProbability;
    this.precipitationByPrecipitationId = precipitationByPrecipitationId;
    this.weatherConditionByWeatherConditionId = weatherConditionByWeatherConditionId;
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
  @Column(name = "temperature")
  public Integer getTemperature() {
    return temperature;
  }

  public void setTemperature(Integer temperature) {
    this.temperature = temperature;
  }

  @Basic
  @Column(name = "real_feel_temperature")
  public Integer getRealFeelTemperature() {
    return realFeelTemperature;
  }

  public void setRealFeelTemperature(Integer realFeelTemperature) {
    this.realFeelTemperature = realFeelTemperature;
  }

  @Basic
  @Column(name = "water_temperature")
  public Integer getWaterTemperature() {
    return waterTemperature;
  }

  public void setWaterTemperature(Integer waterTemperature) {
    this.waterTemperature = waterTemperature;
  }

  @Basic
  @Column(name = "humidity")
  public Integer getHumidity() {
    return humidity;
  }

  public void setHumidity(Integer humidity) {
    this.humidity = humidity;
  }

  @Basic
  @Column(name = "indoor_humidity")
  public Integer getIndoorHumidity() {
    return indoorHumidity;
  }

  public void setIndoorHumidity(Integer indoorHumidity) {
    this.indoorHumidity = indoorHumidity;
  }

  @Basic
  @Column(name = "pressure")
  public Integer getPressure() {
    return pressure;
  }

  public void setPressure(Integer pressure) {
    this.pressure = pressure;
  }

  @Basic
  @Column(name = "wind_speed")
  public Integer getWindSpeed() {
    return windSpeed;
  }

  public void setWindSpeed(Integer windSpeed) {
    this.windSpeed = windSpeed;
  }

  @Basic
  @Column(name = "wind_direction")
  public String getWindDirection() {
    return windDirection;
  }

  public void setWindDirection(String windDirection) {
    this.windDirection = windDirection;
  }

  @Basic
  @Column(name = "wind_gusts")
  public Integer getWindGusts() {
    return windGusts;
  }

  public void setWindGusts(Integer windGusts) {
    this.windGusts = windGusts;
  }

  @Basic
  @Column(name = "dew_point")
  public Integer getDewPoint() {
    return dewPoint;
  }

  public void setDewPoint(Integer dewPoint) {
    this.dewPoint = dewPoint;
  }

  @Basic
  @Column(name = "cloud_ceiling")
  public Integer getCloudCeiling() {
    return cloudCeiling;
  }

  public void setCloudCeiling(Integer cloudCeiling) {
    this.cloudCeiling = cloudCeiling;
  }

  @Basic
  @Column(name = "precipitation_probability")
  public Integer getPrecipitationProbability() {
    return precipitationProbability;
  }

  public void setPrecipitationProbability(Integer precipitationProbability) {
    this.precipitationProbability = precipitationProbability;
  }

  @Basic
  @Column(name = "thunderstorm_probability")
  public Integer getThunderstormProbability() {
    return thunderstormProbability;
  }

  public void setThunderstormProbability(Integer thunderstormProbability) {
    this.thunderstormProbability = thunderstormProbability;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Weather weather = (Weather) o;

    if (id != null ? !id.equals(weather.id) : weather.id != null) return false;
    if (temperature != null ? !temperature.equals(weather.temperature) : weather.temperature != null) return false;
    if (realFeelTemperature != null ? !realFeelTemperature.equals(weather.realFeelTemperature) : weather.realFeelTemperature != null)
      return false;
    if (waterTemperature != null ? !waterTemperature.equals(weather.waterTemperature) : weather.waterTemperature != null)
      return false;
    if (humidity != null ? !humidity.equals(weather.humidity) : weather.humidity != null) return false;
    if (indoorHumidity != null ? !indoorHumidity.equals(weather.indoorHumidity) : weather.indoorHumidity != null)
      return false;
    if (pressure != null ? !pressure.equals(weather.pressure) : weather.pressure != null) return false;
    if (windSpeed != null ? !windSpeed.equals(weather.windSpeed) : weather.windSpeed != null) return false;
    if (windDirection != null ? !windDirection.equals(weather.windDirection) : weather.windDirection != null)
      return false;
    if (windGusts != null ? !windGusts.equals(weather.windGusts) : weather.windGusts != null) return false;
    if (dewPoint != null ? !dewPoint.equals(weather.dewPoint) : weather.dewPoint != null) return false;
    if (cloudCeiling != null ? !cloudCeiling.equals(weather.cloudCeiling) : weather.cloudCeiling != null)
      return false;
    if (precipitationProbability != null ? !precipitationProbability.equals(weather.precipitationProbability) : weather.precipitationProbability != null)
      return false;
    if (thunderstormProbability != null ? !thunderstormProbability.equals(weather.thunderstormProbability) : weather.thunderstormProbability != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (temperature != null ? temperature.hashCode() : 0);
    result = 31 * result + (realFeelTemperature != null ? realFeelTemperature.hashCode() : 0);
    result = 31 * result + (waterTemperature != null ? waterTemperature.hashCode() : 0);
    result = 31 * result + (humidity != null ? humidity.hashCode() : 0);
    result = 31 * result + (indoorHumidity != null ? indoorHumidity.hashCode() : 0);
    result = 31 * result + (pressure != null ? pressure.hashCode() : 0);
    result = 31 * result + (windSpeed != null ? windSpeed.hashCode() : 0);
    result = 31 * result + (windDirection != null ? windDirection.hashCode() : 0);
    result = 31 * result + (windGusts != null ? windGusts.hashCode() : 0);
    result = 31 * result + (dewPoint != null ? dewPoint.hashCode() : 0);
    result = 31 * result + (cloudCeiling != null ? cloudCeiling.hashCode() : 0);
    result = 31 * result + (precipitationProbability != null ? precipitationProbability.hashCode() : 0);
    result = 31 * result + (thunderstormProbability != null ? thunderstormProbability.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return String.format("%-5d %-15d %-25d %-20d %-10d %-20d %-10d %-11d %-15s %-11d %-10d %-15d %-27d %-20d %-25d %s",
        id, temperature, realFeelTemperature, waterTemperature, humidity, indoorHumidity, pressure, windSpeed,
        windDirection, windGusts, dewPoint, cloudCeiling, precipitationProbability,
        precipitationByPrecipitationId.getId(), weatherConditionByWeatherConditionId.getId(), thunderstormProbability);
  }

  @ManyToOne
  @JoinColumn(name = "precipitation_id", referencedColumnName = "id", nullable = false)
  public Precipitation getPrecipitationByPrecipitationId() {
    return precipitationByPrecipitationId;
  }

  public void setPrecipitationByPrecipitationId(Precipitation precipitationByPrecipitationId) {
    this.precipitationByPrecipitationId = precipitationByPrecipitationId;
  }

  @ManyToOne
  @JoinColumn(name = "weather_condition_id", referencedColumnName = "id", nullable = false)
  public WeatherCondition getWeatherConditionByWeatherConditionId() {
    return weatherConditionByWeatherConditionId;
  }

  public void setWeatherConditionByWeatherConditionId(WeatherCondition weatherConditionByWeatherConditionId) {
    this.weatherConditionByWeatherConditionId = weatherConditionByWeatherConditionId;
  }
}
