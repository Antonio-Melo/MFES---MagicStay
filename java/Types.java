package MagicStay;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Types {
  public static Number compare(final Date d1, final Date d2) {

    if (d1.year.longValue() > d2.year.longValue()) {
      return -1L;

    } else {
      if (d1.year.longValue() < d2.year.longValue()) {
        return 1L;

      } else {
        if (d1.month.longValue() > d2.month.longValue()) {
          return -1L;

        } else {
          if (d1.month.longValue() < d2.month.longValue()) {
            return 1L;

          } else {
            if (d1.day.longValue() > d2.day.longValue()) {
              return -1L;

            } else {
              if (d1.day.longValue() < d2.day.longValue()) {
                return 1L;

              } else {
                return 0L;
              }
            }
          }
        }
      }
    }
  }

  public Types() {}

  public String toString() {

    return "Types{}";
  }

  public static class Date implements Record {
    public Number year;
    public Number month;
    public Number day;

    public Date(final Number _year, final Number _month, final Number _day) {

      year = _year;
      month = _month;
      day = _day;
    }

    public boolean equals(final Object obj) {

      if (!(obj instanceof Date)) {
        return false;
      }

      Date other = ((Date) obj);

      return (Utils.equals(year, other.year))
          && (Utils.equals(month, other.month))
          && (Utils.equals(day, other.day));
    }

    public int hashCode() {

      return Utils.hashCode(year, month, day);
    }

    public Date copy() {

      return new Date(year, month, day);
    }

    public String toString() {

      return "mk_Types`Date" + Utils.formatFields(year, month, day);
    }
  }

  public static Boolean inv_Date(final Date date) {

    Boolean andResult_3 = false;

    if (date.year.longValue() >= 0L) {
      Boolean andResult_4 = false;

      if (date.month.longValue() > 0L) {
        Boolean andResult_5 = false;

        if (date.month.longValue() <= 12L) {
          Boolean andResult_6 = false;

          if (date.day.longValue() > 0L) {
            if (date.day.longValue() <= 31L) {
              andResult_6 = true;
            }
          }

          if (andResult_6) {
            andResult_5 = true;
          }
        }

        if (andResult_5) {
          andResult_4 = true;
        }
      }

      if (andResult_4) {
        andResult_3 = true;
      }
    }

    return andResult_3;
  }

  public static class Time implements Record {
    public Number hour;
    public Number minute;
    public Number second;

    public Time(final Number _hour, final Number _minute, final Number _second) {

      hour = _hour;
      minute = _minute;
      second = _second;
    }

    public boolean equals(final Object obj) {

      if (!(obj instanceof Time)) {
        return false;
      }

      Time other = ((Time) obj);

      return (Utils.equals(hour, other.hour))
          && (Utils.equals(minute, other.minute))
          && (Utils.equals(second, other.second));
    }

    public int hashCode() {

      return Utils.hashCode(hour, minute, second);
    }

    public Time copy() {

      return new Time(hour, minute, second);
    }

    public String toString() {

      return "mk_Types`Time" + Utils.formatFields(hour, minute, second);
    }
  }

  public static Boolean inv_Time(final Time time) {

    Boolean andResult_11 = false;

    if (time.hour.longValue() >= 0L) {
      Boolean andResult_12 = false;

      if (time.hour.longValue() < 24L) {
        Boolean andResult_13 = false;

        if (time.minute.longValue() >= 0L) {
          Boolean andResult_14 = false;

          if (time.minute.longValue() < 60L) {
            Boolean andResult_15 = false;

            if (time.second.longValue() >= 0L) {
              if (time.second.longValue() < 60L) {
                andResult_15 = true;
              }
            }

            if (andResult_15) {
              andResult_14 = true;
            }
          }

          if (andResult_14) {
            andResult_13 = true;
          }
        }

        if (andResult_13) {
          andResult_12 = true;
        }
      }

      if (andResult_12) {
        andResult_11 = true;
      }
    }

    return andResult_11;
  }

  public static class DateTime implements Record {
    public Date date;
    public Time time;

    public DateTime(final Date _date, final Time _time) {

      date = _date != null ? Utils.copy(_date) : null;
      time = _time != null ? Utils.copy(_time) : null;
    }

    public boolean equals(final Object obj) {

      if (!(obj instanceof DateTime)) {
        return false;
      }

      DateTime other = ((DateTime) obj);

      return (Utils.equals(date, other.date)) && (Utils.equals(time, other.time));
    }

    public int hashCode() {

      return Utils.hashCode(date, time);
    }

    public DateTime copy() {

      return new DateTime(date, time);
    }

    public String toString() {

      return "mk_Types`DateTime" + Utils.formatFields(date, time);
    }
  }
}
