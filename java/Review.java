package MagicStay;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Review {
  private User user;
  private Accomodation house;
  private String content;
  private Number rating;

  public void cg_init_Review_1(
      final User u, final Accomodation h, final String c, final Number star) {

    user = u;
    house = h;
    content = c;
    rating = star;
    house.addReview(this);
  }

  public Review(final User u, final Accomodation h, final String c, final Number star) {

    cg_init_Review_1(u, h, c, star);
  }

  public User getUser() {

    return user;
  }

  public String getContent() {

    return content;
  }

  public Number getRating() {

    return rating;
  }

  public Review() {}

  public String toString() {

    return "Review{"
        + "user := "
        + Utils.toString(user)
        + ", house := "
        + Utils.toString(house)
        + ", content := "
        + Utils.toString(content)
        + ", rating := "
        + Utils.toString(rating)
        + "}";
  }
}
