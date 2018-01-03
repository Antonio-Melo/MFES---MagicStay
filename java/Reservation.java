package MagicStay;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Reservation {
  private User user;
  private Accomodation house;
  private Types.DateTime checkIn;
  private Types.DateTime checkOut;
  private Number price;

  public void cg_init_Reservation_1(
      final User u, final Accomodation h, final Types.DateTime cI, final Types.DateTime cO) {

    user = u;
    house = h;
    checkIn = Utils.copy(cI);
    checkOut = Utils.copy(cO);
    house.addReservation(this);
  }

  public Reservation(
      final User u, final Accomodation h, final Types.DateTime cI, final Types.DateTime cO) {

    cg_init_Reservation_1(u, h, Utils.copy(cI), Utils.copy(cO));
  }

  public User getUser() {

    return user;
  }

  public Accomodation getAccomodation() {

    return house;
  }

  public Types.DateTime getCheckIn() {

    return Utils.copy(checkIn);
  }

  public Types.DateTime getCheckOut() {

    return Utils.copy(checkOut);
  }

  public Number getPrice() {

    return price;
  }

  public void setPrice(final Number p) {

    price = p;
  }

  public Reservation() {}

  public String toString() {

    return "Reservation{"
        + "user := "
        + Utils.toString(user)
        + ", house := "
        + Utils.toString(house)
        + ", checkIn := "
        + Utils.toString(checkIn)
        + ", checkOut := "
        + Utils.toString(checkOut)
        + ", price := "
        + Utils.toString(price)
        + "}";
  }
}
