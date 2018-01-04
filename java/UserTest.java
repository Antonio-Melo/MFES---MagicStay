package MagicStay;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class UserTest extends Test {
  public User createUser() {

    return new User(
        "Antonio",
        "Antonio Melo",
        "antonio@gmail.com",
        "12345",
        "Portugal",
        "911111111",
        "Empresa",
        123L,
        123L,
        50000L);
  }

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

  public void testCreateUser() {

    User u = createUser();
    assert_(Utils.equals(u.getFirstName(), "Antonio"));
    assert_(Utils.equals(u.getFullName(), "Antonio Melo"));
    assert_(Utils.equals(u.getEmail(), "antonio@gmail.com"));
    assert_(Utils.equals(u.getPassword(), "12345"));
    assert_(Utils.equals(u.getCountry(), "Portugal"));
    assert_(Utils.equals(u.getPhoneNumber(), "911111111"));
    assert_(Utils.equals(u.getCompany(), "Empresa"));
    assert_(Utils.equals(u.getCompanyRegNum(), 123L));
    assert_(Utils.equals(u.getVat(), 123L));
  }

  public void testFavorites() {

    Landlord landlord = createLandlord();
    User u1 = createUser();
    Accomodation h1 =
        new Accomodation(
            "Porto", 4L, 2L, 1L, landlord, MagicStay.quotes.HouseQuote.getInstance(), 120L);
    Accomodation h2 =
        new Accomodation(
            "Porto", 4L, 2L, 1L, landlord, MagicStay.quotes.HouseQuote.getInstance(), 80L);
    Accomodation h3 =
        new Accomodation(
            "Porto", 4L, 2L, 1L, landlord, MagicStay.quotes.HouseQuote.getInstance(), 90L);
    u1.addFavorite(h1);
    u1.addFavorite(h2);
    assert_(SetUtil.inSet(h2, u1.getFavorites()));
    u1.addFavorite(h3);
    u1.removeFavorite(h2);
    assert_(SetUtil.inSet(h1, u1.getFavorites()));
    assert_(!(SetUtil.inSet(h2, u1.getFavorites())));
    assert_(SetUtil.inSet(h3, u1.getFavorites()));
  }

  public void test() {

    testCreateUser();
    testFavorites();
  }

  public UserTest() {}

  public String toString() {

    return "UserTest{}";
  }
}
