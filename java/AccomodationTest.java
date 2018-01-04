package MagicStay;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class AccomodationTest extends Test {
  public Accomodation createAccomodation(final Landlord landlord) {

    return new Accomodation(
        "Porto", 2L, 2L, 1L, landlord, MagicStay.quotes.HouseQuote.getInstance(), 120L);
  }

  public void testCreateAccomodation() {

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
    Accomodation a = createAccomodation(l);
    assert_(Utils.equals(a.getArea(), "Porto"));
    assert_(Utils.equals(a.getNumBedrooms(), 2L));
    assert_(Utils.equals(a.getNumBeds(), 2L));
    assert_(Utils.equals(a.getNumOfBathrooms(), 1L));
    assert_(Utils.equals(a.getHost(), l));
    assert_(Utils.equals(a.getType(), MagicStay.quotes.HouseQuote.getInstance()));
    assert_(SetUtil.inSet(a, l.getHouses()));
  }

  public void test() {

    testCreateAccomodation();
  }

  public AccomodationTest() {}

  public String toString() {

    return "AccomodationTest{}";
  }
}
