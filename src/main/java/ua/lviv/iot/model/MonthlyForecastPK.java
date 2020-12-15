package ua.lviv.iot.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class MonthlyForecastPK implements Serializable {
  private Integer year;
  private String month;

  public MonthlyForecastPK() {
  }

  public MonthlyForecastPK(Integer year, String month) {
    this.year = year;
    this.month = month;
  }

  @Column(name = "year")
  @Id
  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  @Column(name = "month")
  @Id
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

    MonthlyForecastPK that = (MonthlyForecastPK) o;

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
}
