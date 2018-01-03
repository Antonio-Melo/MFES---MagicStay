package MagicStay.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ApartmentQuote {
  private static int hc = 0;
  private static ApartmentQuote instance = null;

  public ApartmentQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ApartmentQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ApartmentQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ApartmentQuote;
  }

  public String toString() {

    return "<Apartment>";
  }
}
