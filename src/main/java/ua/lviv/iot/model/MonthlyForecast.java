package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "monthly_forecast", schema = "AccuWeather")
@IdClass(MonthlyForecastPK.class)
public class MonthlyForecast {
  private Integer year;
  private String month;

  public MonthlyForecast() {
  }

  public MonthlyForecast(Integer year, String month) {
    this.year = year;
    this.month = month;
  }

  @Id
  @Column(name = "year")
  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  @Id
  @Column(name = "month")
  public String getMonth() {
    return month;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    MonthlyForecast that = (MonthlyForecast) o;

    if (year != null ? !year.equals(that.year) : that.year != null) {
      return false;
    }
    if (month != null ? !month.equals(that.month) : that.month != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = year != null ? year.hashCode() : 0;
    result = 31 * result + (month != null ? month.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return String.format("%-5d %s", year, month);
  }
}
