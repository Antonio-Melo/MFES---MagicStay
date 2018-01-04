package MagicStay;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ReservationTest extends Test {
  public Reservation createReservation(
      final User u, final Accomodation a, final Types.DateTime cI, final Types.DateTime cO) {

    return new Reservation(u, a, Utils.copy(cI), Utils.copy(cO));
  }

  public void testCreateReservation() {

    Number price = 120L;
    Number userWallet = 50000L;
    Number hostWallet = 0L;
    Types.DateTime cI =
        new Types.DateTime(new Types.Date(2018L, 1L, 19L), new Types.Time(14L, 0L, 0L));
    Types.DateTime cO =
        new Types.DateTime(new Types.Date(2018L, 1L, 30L), new Types.Time(11L, 0L, 0L));
    User u =
        new User(
            "Antonio",
            "Antonio Melo",
            "antonio@gmail.com",
            "12345",
            "Portugal",
            "911111111",
            "Empresa",
            123L,
            123L,
            userWallet);
    Landlord l =
        new Landlord(
            "Bruno",
            "Bruno Santos",
            MagicStay.quotes.MaleQuote.getInstance(),
            "922222222",
            "bruno@gmail.com",
            "1234",
            MagicStay.quotes.EnglishQuote.getInstance(),
            "Rua das Flores",
            "Porto",
            "4400-458",
            "Portugal",
            "www.casas.com",
            MagicStay.quotes.OwnerQuote.getInstance(),
            hostWallet);
    Accomodation a =
        new Accomodation("Porto", 4L, 2L, 1L, l, MagicStay.quotes.HouseQuote.getInstance(), price);
    Reservation r = createReservation(u, a, Utils.copy(cI), Utils.copy(cO));
    assert_(Utils.equals(r.getAccomodation(), a));
    assert_(Utils.equals(r.getCheckIn(), cI));
    assert_(Utils.equals(r.getCheckOut(), cO));
    assert_(Utils.equals(r.getPrice(), price));
    assert_(SetUtil.inSet(r, a.getReservations()));
    assert_(Utils.equals(r.getUser().getWallet(), userWallet.doubleValue() - price.doubleValue()));
    assert_(
        Utils.equals(
            r.getAccomodation().getHost().getWallet(),
            hostWallet.doubleValue() + price.doubleValue()));
  }

  public void testOverlappingReservations() {

    Number price = 120L;
    Number userWallet = 50000L;
    Number hostWallet = 0L;
    User u =
        new User(
            "Antonio",
            "Antonio Melo",
            "antonio@gmail.com",
            "12345",
            "Portugal",
            "911111111",
            "Empresa",
            123L,
            123L,
            userWallet);
    Landlord l =
        new Landlord(
            "Bruno",
            "Bruno Santos",
            MagicStay.quotes.MaleQuote.getInstance(),
            "922222222",
            "bruno@gmail.com",
            "1234",
            MagicStay.quotes.EnglishQuote.getInstance(),
            "Rua das Flores",
            "Porto",
            "4400-458",
            "Portugal",
            "www.casas.com",
            MagicStay.quotes.OwnerQuote.getInstance(),
            hostWallet);
    Accomodation a =
        new Accomodation("Porto", 4L, 2L, 1L, l, MagicStay.quotes.HouseQuote.getInstance(), price);
    Types.DateTime cI1 =
        new Types.DateTime(new Types.Date(2018L, 1L, 19L), new Types.Time(14L, 0L, 0L));
    Types.DateTime cO1 =
        new Types.DateTime(new Types.Date(2018L, 1L, 30L), new Types.Time(11L, 0L, 0L));
    Reservation r1 = createReservation(u, a, Utils.copy(cI1), Utils.copy(cO1));
    Types.DateTime cI2 =
        new Types.DateTime(new Types.Date(2018L, 1L, 8L), new Types.Time(14L, 0L, 0L));
    Types.DateTime cO2 =
        new Types.DateTime(new Types.Date(2018L, 1L, 19L), new Types.Time(11L, 0L, 0L));
    Reservation r2 = createReservation(u, a, Utils.copy(cI2), Utils.copy(cO2));
    Types.DateTime cI3 =
        new Types.DateTime(new Types.Date(2017L, 10L, 6L), new Types.Time(14L, 0L, 0L));
    Types.DateTime cO3 =
        new Types.DateTime(new Types.Date(2017L, 11L, 5L), new Types.Time(11L, 0L, 0L));
    Reservation r3 = createReservation(u, a, Utils.copy(cI3), Utils.copy(cO3));
    Types.DateTime cI4 =
        new Types.DateTime(new Types.Date(2017L, 12L, 26L), new Types.Time(14L, 0L, 0L));
    Types.DateTime cO4 =
        new Types.DateTime(new Types.Date(2018L, 1L, 4L), new Types.Time(11L, 0L, 0L));
    Reservation r4 = createReservation(u, a, Utils.copy(cI4), Utils.copy(cO4));
    Types.DateTime cI5 =
        new Types.DateTime(new Types.Date(2018L, 3L, 4L), new Types.Time(14L, 0L, 0L));
    Types.DateTime cO5 =
        new Types.DateTime(new Types.Date(2018L, 3L, 9L), new Types.Time(11L, 0L, 0L));
    Reservation r5 = createReservation(u, a, Utils.copy(cI5), Utils.copy(cO5));
    Types.DateTime cI6 =
        new Types.DateTime(new Types.Date(2018L, 1L, 3L), new Types.Time(14L, 0L, 0L));
    Types.DateTime cO6 =
        new Types.DateTime(new Types.Date(2018L, 1L, 8L), new Types.Time(11L, 0L, 0L));
    Reservation r6 = null;
    a.cancelReservation(r4);
    r6 = createReservation(u, a, Utils.copy(cI6), Utils.copy(cO6));
    assert_(SetUtil.inSet(r1, a.getReservations()));
    assert_(SetUtil.inSet(r2, a.getReservations()));
    assert_(SetUtil.inSet(r3, a.getReservations()));
    assert_(!(SetUtil.inSet(r4, a.getReservations())));
    assert_(SetUtil.inSet(r5, a.getReservations()));
    assert_(SetUtil.inSet(r6, a.getReservations()));
    assert_(
        Utils.equals(
            r1.getUser().getWallet(), userWallet.doubleValue() - price.doubleValue() * 5L));
    assert_(
        Utils.equals(
            r1.getAccomodation().getHost().getWallet(),
            hostWallet.doubleValue() + price.doubleValue() * 5L));
  }

  public void test() {

    testCreateReservation();
    testOverlappingReservations();
  }

  public ReservationTest() {}

  public String toString() {

    return "ReservationTest{}";
  }
}
