package MagicStay.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class HotelQuote {
  private static int hc = 0;
  private static HotelQuote instance = null;

  public HotelQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static HotelQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new HotelQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof HotelQuote;
  }

  public String toString() {

    return "<Hotel>";
  }
}
