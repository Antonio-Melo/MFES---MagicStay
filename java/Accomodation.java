package MagicStay;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Accomodation {
  private String area;
  private Number numBedrooms;
  private Number numBeds;
  private Number numStars;
  private Number numOfBathrooms;
  private Landlord host;
  private Object type;
  private Number price;
  private VDMSet reservations = SetUtil.set();
  private VDMMap reviews = MapUtil.map();

  public void cg_init_Accomodation_1(
      final String a,
      final Number nBedrooms,
      final Number nBeds,
      final Number nBathrooms,
      final Landlord user,
      final Object typeOf,
      final Number p) {

    area = a;
    numBedrooms = nBedrooms;
    numBeds = nBeds;
    numStars = 0L;
    numOfBathrooms = nBathrooms;
    host = user;
    type = typeOf;
    price = p;
    host.addHouse(this);
  }

  public Accomodation(
      final String a,
      final Number nBedrooms,
      final Number nBeds,
      final Number nBathrooms,
      final Landlord user,
      final Object typeOf,
      final Number p) {

    cg_init_Accomodation_1(a, nBedrooms, nBeds, nBathrooms, user, typeOf, p);
  }

  public String getArea() {

    return area;
  }

  public Number getNumBedrooms() {

    return numBedrooms;
  }

  public Number getNumStars() {

    return numStars;
  }

  public Number getNumBeds() {

    return numBeds;
  }

  public Number getNumOfBathrooms() {

    return numOfBathrooms;
  }

  public Landlord getHost() {

    return host;
  }

  public Object getType() {

    return type;
  }

  public Number getPrice() {

    return price;
  }

  public VDMSet getReservations() {

    return Utils.copy(reservations);
  }

  private void updateNumStars() {

    Number sum = 0L;
    Number n = MapUtil.dom(Utils.copy(reviews)).size();
    for (Iterator iterator_2 = MapUtil.rng(Utils.copy(reviews)).iterator();
        iterator_2.hasNext();
        ) {
      Review r = (Review) iterator_2.next();
      sum = sum.longValue() + r.getRating().longValue();
    }
    if (Utils.equals(n, 0L)) {
      n = 1L;
    }

    numStars = Utils.divide((1.0 * sum.longValue()), n.longValue());
  }

  public void addReview(final Review rev) {

    reviews = MapUtil.override(Utils.copy(reviews), MapUtil.map(new Maplet(rev.getUser(), rev)));
    updateNumStars();
  }

  public void removeReview(final Review rev) {

    reviews = MapUtil.domResBy(SetUtil.set(rev.getUser()), Utils.copy(reviews));
    updateNumStars();
  }

  public VDMMap getReviews() {

    return Utils.copy(reviews);
  }

  public void addReservation(final Reservation res) {

    res.setPrice(price);
    res.getUser().transaction(-price.doubleValue());
    host.transaction(price);
    reservations = SetUtil.union(Utils.copy(reservations), SetUtil.set(res));
  }

  public void cancelReservation(final Reservation res) {

    Number p = res.getPrice();
    res.getUser().transaction(p);
    host.transaction(-p.doubleValue());
    reservations = SetUtil.diff(Utils.copy(reservations), SetUtil.set(res));
  }

  private Boolean overlaps(final Reservation res1, final Reservation res2) {

    Boolean orResult_1 = false;

    if (Types.compare(Utils.copy(res1.getCheckIn().date), Utils.copy(res2.getCheckOut().date))
            .longValue()
        <= 0L) {
      orResult_1 = true;
    } else {
      orResult_1 =
          Types.compare(Utils.copy(res2.getCheckIn().date), Utils.copy(res1.getCheckOut().date))
                  .longValue()
              <= 0L;
    }

    if (orResult_1) {
      return false;

    } else {
      return true;
    }
  }

  public Accomodation() {}

  public String toString() {

    return "Accomodation{"
        + "area := "
        + Utils.toString(area)
        + ", numBedrooms := "
        + Utils.toString(numBedrooms)
        + ", numBeds := "
        + Utils.toString(numBeds)
        + ", numStars := "
        + Utils.toString(numStars)
        + ", numOfBathrooms := "
        + Utils.toString(numOfBathrooms)
        + ", host := "
        + Utils.toString(host)
        + ", type := "
        + Utils.toString(type)
        + ", price := "
        + Utils.toString(price)
        + ", reservations := "
        + Utils.toString(reservations)
        + ", reviews := "
        + Utils.toString(reviews)
        + "}";
  }
}
