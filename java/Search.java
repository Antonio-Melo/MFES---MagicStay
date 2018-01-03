package MagicStay;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Search {
  private String area;
  private Types.Date checkIn;
  private Types.Date checkOut;
  private Number numBedrooms;
  private Object typeOfAccomodation;
  private Number numOfStars;
  private Number numOfBeds;
  private Number numOfBathrooms;
  private Number lowRangePrice;
  private Number highRangePrice;
  private VDMSet results = SetUtil.set();

  public void cg_init_Search_1(
      final String a,
      final Types.Date cIn,
      final Types.Date cOut,
      final Number nBedrooms,
      final Object typeOfAcco,
      final Number nOfStars,
      final Number nOfBeds,
      final Number nOfBathrooms,
      final Number lowPrice,
      final Number highPrice) {

    area = a;
    checkIn = Utils.copy(cIn);
    checkOut = Utils.copy(cOut);
    numBedrooms = nBedrooms;
    typeOfAccomodation = typeOfAcco;
    numOfStars = nOfStars;
    numOfBeds = nOfBeds;
    numOfBathrooms = nOfBathrooms;
    lowRangePrice = lowPrice;
    highRangePrice = highPrice;
  }

  public Search(
      final String a,
      final Types.Date cIn,
      final Types.Date cOut,
      final Number nBedrooms,
      final Object typeOfAcco,
      final Number nOfStars,
      final Number nOfBeds,
      final Number nOfBathrooms,
      final Number lowPrice,
      final Number highPrice) {

    cg_init_Search_1(
        a,
        Utils.copy(cIn),
        Utils.copy(cOut),
        nBedrooms,
        typeOfAcco,
        nOfStars,
        nOfBeds,
        nOfBathrooms,
        lowPrice,
        highPrice);
  }

  public VDMSet searchResults(final VDMSet accomodations) {

    results = SetUtil.set();
    for (Iterator iterator_3 = accomodations.iterator(); iterator_3.hasNext(); ) {
      Accomodation a = (Accomodation) iterator_3.next();
      Boolean andResult_22 = false;

      if (Utils.equals(a.getArea(), area)) {
        Boolean andResult_23 = false;

        if (Utils.equals(a.getNumBedrooms(), numBedrooms)) {
          Boolean andResult_24 = false;

          if (Utils.equals(a.getType(), typeOfAccomodation)) {
            Boolean andResult_25 = false;

            if (Utils.equals(a.getNumStars(), numOfStars)) {
              Boolean andResult_26 = false;

              if (Utils.equals(a.getNumBeds(), numOfBeds)) {
                Boolean andResult_27 = false;

                if (Utils.equals(a.getNumOfBathrooms(), numOfBathrooms)) {
                  Boolean andResult_28 = false;

                  if (a.getPrice().doubleValue() >= lowRangePrice.doubleValue()) {
                    if (a.getPrice().doubleValue() <= highRangePrice.doubleValue()) {
                      andResult_28 = true;
                    }
                  }

                  if (andResult_28) {
                    andResult_27 = true;
                  }
                }

                if (andResult_27) {
                  andResult_26 = true;
                }
              }

              if (andResult_26) {
                andResult_25 = true;
              }
            }

            if (andResult_25) {
              andResult_24 = true;
            }
          }

          if (andResult_24) {
            andResult_23 = true;
          }
        }

        if (andResult_23) {
          andResult_22 = true;
        }
      }

      if (andResult_22) {
        results = SetUtil.union(Utils.copy(results), SetUtil.set(a));
      }
    }
    return Utils.copy(results);
  }

  public String getArea() {

    return area;
  }

  public Types.Date getCheckIn() {

    return Utils.copy(checkIn);
  }

  public Types.Date getCheckOut() {

    return Utils.copy(checkOut);
  }

  public Number getNumBedrooms() {

    return numBedrooms;
  }

  public Object getTypeOfAccomodation() {

    return typeOfAccomodation;
  }

  public Number getNumOfStars() {

    return numOfStars;
  }

  public Number getNumOfBeds() {

    return numOfBeds;
  }

  public Number getNumOfBathrooms() {

    return numOfBathrooms;
  }

  public Number getLowRangePrice() {

    return lowRangePrice;
  }

  public Number getHighRangePrice() {

    return highRangePrice;
  }

  public Search() {}

  public String toString() {

    return "Search{"
        + "area := "
        + Utils.toString(area)
        + ", checkIn := "
        + Utils.toString(checkIn)
        + ", checkOut := "
        + Utils.toString(checkOut)
        + ", numBedrooms := "
        + Utils.toString(numBedrooms)
        + ", typeOfAccomodation := "
        + Utils.toString(typeOfAccomodation)
        + ", numOfStars := "
        + Utils.toString(numOfStars)
        + ", numOfBeds := "
        + Utils.toString(numOfBeds)
        + ", numOfBathrooms := "
        + Utils.toString(numOfBathrooms)
        + ", lowRangePrice := "
        + Utils.toString(lowRangePrice)
        + ", highRangePrice := "
        + Utils.toString(highRangePrice)
        + ", results := "
        + Utils.toString(results)
        + "}";
  }
}
