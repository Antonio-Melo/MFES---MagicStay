package MagicStay;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ReviewTest extends Test {
  public Review createReview(
      final User user, final Accomodation house, final String review, final Number rating) {

    return new Review(user, house, review, rating);
  }

  public void testCreateReview() {

    User user =
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
            50000L);
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
    Accomodation accomodation =
        new Accomodation(
            "Porto", 4L, 2L, 1L, landlord, MagicStay.quotes.HouseQuote.getInstance(), 120L);
    Review review = new Review(user, accomodation, "Very good!", 4L);
    assert_(Utils.equals(review.getContent(), "Very good!"));
    assert_(Utils.equals(review.getUser(), user));
    assert_(SetUtil.inSet(review, MapUtil.rng(accomodation.getReviews())));
    accomodation.removeReview(review);
    assert_(!(SetUtil.inSet(review, MapUtil.rng(accomodation.getReviews()))));
  }

  public void test() {

    testCreateReview();
  }

  public ReviewTest() {}

  public String toString() {

    return "ReviewTest{}";
  }
}
