package MagicStay;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class RealCaseTest extends Test {
  private User user;
  private VDMSeq landlords = SeqUtil.seq();
  private VDMSet accomodations = SetUtil.set();
  private VDMSet results = SetUtil.set();
  private Accomodation accReserve;
  private Reservation reservation;

  public void testSignUpLandlords() {

    Landlord landlord =
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
            0L);
    Landlord landlord1 =
        new Landlord(
            "Lourenço",
            "Lourenço Aires",
            MagicStay.quotes.MaleQuote.getInstance(),
            "933333333",
            "lourenço@gmail.com",
            "gg",
            MagicStay.quotes.SpanishQuote.getInstance(),
            "Jardim das Rodas",
            "Madrid",
            "4400-478",
            "Spain",
            "www.casasbonitas.com",
            MagicStay.quotes.OwnerQuote.getInstance(),
            0L);
    assert_(Utils.equals(landlord.getFirstName(), "Bruno"));
    assert_(Utils.equals(landlord.getGender(), MagicStay.quotes.MaleQuote.getInstance()));
    assert_(Utils.equals(landlord.getEmail(), "bruno@gmail.com"));
    assert_(Utils.equals(landlord.getLanguage(), MagicStay.quotes.EnglishQuote.getInstance()));
    assert_(Utils.equals(landlord.getCity(), "Porto"));
    assert_(Utils.equals(landlord.getCountry(), "Portugal"));
    assert_(Utils.equals(landlord.getType(), MagicStay.quotes.OwnerQuote.getInstance()));
    assert_(Utils.equals(landlord1.getFullName(), "Lourenço Aires"));
    assert_(Utils.equals(landlord1.getPhoneNumber(), "933333333"));
    assert_(Utils.equals(landlord1.getPassword(), "gg"));
    assert_(Utils.equals(landlord1.getAddress(), "Jardim das Rodas"));
    assert_(Utils.equals(landlord1.getPostalCode(), "4400-478"));
    assert_(Utils.equals(landlord1.getWebsite(), "www.casasbonitas.com"));
    assert_(Utils.equals(landlord1.getWallet(), 0L));
    landlords = SeqUtil.conc(Utils.copy(landlords), SeqUtil.seq(landlord, landlord1));
    assert_(Utils.equals(((Landlord) Utils.get(landlords, 1L)), landlord));
  }

  public void testCreateAccomodations() {

    Accomodation acc =
        new Accomodation(
            "Porto",
            2L,
            1L,
            1L,
            ((Landlord) Utils.get(landlords, 1L)),
            MagicStay.quotes.ApartmentQuote.getInstance(),
            120L);
    Accomodation acc1 =
        new Accomodation(
            "Lisboa",
            1L,
            2L,
            1L,
            ((Landlord) Utils.get(landlords, 1L)),
            MagicStay.quotes.ApartaHotelQuote.getInstance(),
            70L);
    Accomodation acc2 =
        new Accomodation(
            "Algarve",
            3L,
            5L,
            2L,
            ((Landlord) Utils.get(landlords, 1L)),
            MagicStay.quotes.HouseQuote.getInstance(),
            320L);
    Accomodation acc3 =
        new Accomodation(
            "Porto",
            4L,
            6L,
            3L,
            ((Landlord) Utils.get(landlords, 1L)),
            MagicStay.quotes.HouseQuote.getInstance(),
            440L);
    Accomodation acc4 =
        new Accomodation(
            "Madrid",
            2L,
            2L,
            1L,
            ((Landlord) Utils.get(landlords, 2L)),
            MagicStay.quotes.HouseQuote.getInstance(),
            250L);
    Accomodation acc5 =
        new Accomodation(
            "Barcelona",
            3L,
            4L,
            2L,
            ((Landlord) Utils.get(landlords, 2L)),
            MagicStay.quotes.HouseQuote.getInstance(),
            350L);
    Accomodation acc6 =
        new Accomodation(
            "Porto",
            4L,
            6L,
            3L,
            ((Landlord) Utils.get(landlords, 2L)),
            MagicStay.quotes.HouseQuote.getInstance(),
            590L);
    Accomodation acc7 =
        new Accomodation(
            "Madrid",
            2L,
            2L,
            2L,
            ((Landlord) Utils.get(landlords, 2L)),
            MagicStay.quotes.HotelQuote.getInstance(),
            275L);
    assert_(Utils.equals(acc.getArea(), "Porto"));
    assert_(Utils.equals(acc1.getNumBedrooms(), 1L));
    assert_(Utils.equals(acc2.getNumBeds(), 5L));
    assert_(Utils.equals(acc3.getNumOfBathrooms(), 3L));
    assert_(Utils.equals(((Landlord) Utils.get(landlords, 1L)).getFirstName(), "Bruno"));
    assert_(Utils.equals(acc4.getHost(), ((Landlord) Utils.get(landlords, 2L))));
    assert_(Utils.equals(acc5.getType(), MagicStay.quotes.HouseQuote.getInstance()));
    assert_(Utils.equals(acc6.getPrice(), 590L));
    accomodations =
        SetUtil.union(
            Utils.copy(accomodations), SetUtil.set(acc, acc1, acc2, acc3, acc4, acc5, acc6, acc7));
    results = SetUtil.union(Utils.copy(results), SetUtil.set(acc3, acc6));
    accReserve = acc3;
  }

  public void testSignUpUser() {

    user =
        new User(
            "António",
            "António Teixeira de Melo",
            "antonio@gmail.com",
            "12345",
            "Portugal",
            "911111111",
            "Empresa",
            123L,
            123L,
            50000L);
    assert_(Utils.equals(user.getFirstName(), "António"));
    assert_(Utils.equals(user.getFullName(), "António Teixeira de Melo"));
    assert_(Utils.equals(user.getEmail(), "antonio@gmail.com"));
    assert_(Utils.equals(user.getPassword(), "12345"));
    assert_(Utils.equals(user.getCountry(), "Portugal"));
    assert_(Utils.equals(user.getPhoneNumber(), "911111111"));
    assert_(Utils.equals(user.getCompany(), "Empresa"));
    assert_(Utils.equals(user.getCompanyRegNum(), 123L));
    assert_(Utils.equals(user.getVat(), 123L));
    assert_(Utils.equals(user.getWallet(), 50000L));
  }

  public void testSearchAccomodationsAndAddFavorites() {

    Search search =
        new Search(
            "Porto",
            new Types.Date(2018L, 1L, 19L),
            new Types.Date(2018L, 1L, 30L),
            MagicStay.quotes.HouseQuote.getInstance(),
            4L,
            0L,
            6L,
            3L,
            500L,
            1000L);
    assert_(SetUtil.subset(search.searchResults(Utils.copy(accomodations)), results));
    user.addFavorites(Utils.copy(results));
    assert_(Utils.equals(user.getFavorites(), results));
  }

  public void testMakeConversationWithLandlord() {

    Message msg =
        new Message(user, ((Landlord) Utils.get(landlords, 1L)), "Does it have car park?", null);
    Message msg1 = new Message(((Landlord) Utils.get(landlords, 1L)), user, "Yes!!", msg);
    assert_(Utils.equals(msg.getSender(), user));
    assert_(Utils.equals(msg1.getContent(), "Yes!!"));
  }

  public void testReserve() {

    reservation =
        new Reservation(
            user,
            accReserve,
            new Types.DateTime(new Types.Date(2018L, 1L, 19L), new Types.Time(14L, 0L, 0L)),
            new Types.DateTime(new Types.Date(2018L, 1L, 30L), new Types.Time(11L, 0L, 0L)));
    assert_(Utils.equals(reservation.getPrice(), 440L));
  }

  public void testReviewReserve() {

    Review review = new Review(user, accReserve, "Awesome", 4L);
    assert_(Utils.equals(review.getUser(), user));
    assert_(Utils.equals(review.getContent(), "Awesome"));
    assert_(Utils.equals(accReserve.getNumStars(), 4L));
  }

  public void test() {

    testSignUpLandlords();
    testCreateAccomodations();
    testSignUpUser();
    testSearchAccomodationsAndAddFavorites();
    testMakeConversationWithLandlord();
    testReserve();
    testReviewReserve();
  }

  public RealCaseTest() {}

  public String toString() {

    return "RealCaseTest{"
        + "user := "
        + Utils.toString(user)
        + ", landlords := "
        + Utils.toString(landlords)
        + ", accomodations := "
        + Utils.toString(accomodations)
        + ", results := "
        + Utils.toString(results)
        + ", accReserve := "
        + Utils.toString(accReserve)
        + ", reservation := "
        + Utils.toString(reservation)
        + "}";
  }
}
