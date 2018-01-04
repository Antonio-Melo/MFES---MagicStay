package MagicStay;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class LandlordTest extends Test {
  public Landlord createLandlord() {

    return new Landlord(
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
  }

  public void testCreateLandlord() {

    Landlord l = createLandlord();
    assert_(Utils.equals(l.getFirstName(), "Bruno"));
    assert_(Utils.equals(l.getFullName(), "Bruno Santos"));
    assert_(Utils.equals(l.getGender(), MagicStay.quotes.MaleQuote.getInstance()));
    assert_(Utils.equals(l.getPhoneNumber(), "922222222"));
    assert_(Utils.equals(l.getEmail(), "bruno@gmail.com"));
    assert_(Utils.equals(l.getPassword(), "1234"));
    assert_(Utils.equals(l.getLanguage(), MagicStay.quotes.EnglishQuote.getInstance()));
    assert_(Utils.equals(l.getAddress(), "Rua das Flores"));
    assert_(Utils.equals(l.getCity(), "Porto"));
    assert_(Utils.equals(l.getPostalCode(), "4400-458"));
    assert_(Utils.equals(l.getCountry(), "Portugal"));
    assert_(Utils.equals(l.getWebsite(), "www.casas.com"));
    assert_(Utils.equals(l.getType(), MagicStay.quotes.OwnerQuote.getInstance()));
  }

  public void test() {

    testCreateLandlord();
  }

  public LandlordTest() {}

  public String toString() {

    return "LandlordTest{}";
  }
}
