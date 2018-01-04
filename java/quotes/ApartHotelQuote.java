package MagicStay.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ApartHotelQuote {
  private static int hc = 0;
  private static ApartHotelQuote instance = null;

  public ApartHotelQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ApartHotelQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ApartHotelQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ApartHotelQuote;
  }

  public String toString() {

    return "<ApartHotel>";
  }
}
