package MagicStay;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SearchTest extends Test {
  public Search createSearch(
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

    return new Search(
        a,
        Utils.copy(cIn),
        Utils.copy(cOut),
        nBedrooms,
        ((Object) typeOfAcco),
        nOfStars,
        nOfBeds,
        nOfBathrooms,
        lowPrice,
        highPrice);
  }

  public void testCreateSearch() {

    Search s =
        createSearch(
            "Porto",
            new Types.Date(2018L, 1L, 19L),
            new Types.Date(2018L, 1L, 30L),
            1L,
            MagicStay.quotes.HouseQuote.getInstance(),
            4L,
            2L,
            1L,
            500L,
            1000L);
    assert_(Utils.equals(s.getArea(), "Porto"));
    assert_(Utils.equals(s.getCheckIn(), new Types.Date(2018L, 1L, 19L)));
    assert_(Utils.equals(s.getCheckOut(), new Types.Date(2018L, 1L, 30L)));
    assert_(Utils.equals(s.getNumBedrooms(), 1L));
    assert_(Utils.equals(s.getTypeOfAccomodation(), MagicStay.quotes.HouseQuote.getInstance()));
    assert_(Utils.equals(s.getNumOfStars(), 4L));
    assert_(Utils.equals(s.getNumOfBeds(), 2L));
    assert_(Utils.equals(s.getNumOfBathrooms(), 1L));
    assert_(Utils.equals(s.getLowRangePrice(), 500L));
    assert_(Utils.equals(s.getHighRangePrice(), 1000L));
  }

  public void testSearchResults() {

    Search s =
        createSearch(
            "Porto",
            new Types.Date(2018L, 1L, 19L),
            new Types.Date(2018L, 1L, 30L),
            1L,
            MagicStay.quotes.HouseQuote.getInstance(),
            0L,
            2L,
            1L,
            500L,
            1000L);
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
            0L);
    Accomodation ac =
        new Accomodation("Porto", 1L, 2L, 1L, l, MagicStay.quotes.HouseQuote.getInstance(), 600L);
    Accomodation al =
        new Accomodation("Porto", 1L, 2L, 1L, l, MagicStay.quotes.HouseQuote.getInstance(), 120L);
    VDMSet a = s.searchResults(SetUtil.set(ac, al));
    assert_(Utils.equals(a, SetUtil.set(ac)));
  }

  public void test() {

    testCreateSearch();
  }

  public SearchTest() {}

  public String toString() {

    return "SearchTest{}";
  }
}
