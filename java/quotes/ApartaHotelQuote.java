package MagicStay.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ApartaHotelQuote {
  private static int hc = 0;
  private static ApartaHotelQuote instance = null;

  public ApartaHotelQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ApartaHotelQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ApartaHotelQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ApartaHotelQuote;
  }

  public String toString() {

    return "<ApartaHotel>";
  }
}
