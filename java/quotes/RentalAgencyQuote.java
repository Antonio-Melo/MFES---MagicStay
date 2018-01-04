package MagicStay.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class RentalAgencyQuote {
  private static int hc = 0;
  private static RentalAgencyQuote instance = null;

  public RentalAgencyQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static RentalAgencyQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new RentalAgencyQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof RentalAgencyQuote;
  }

  public String toString() {

    return "<RentalAgency>";
  }
}
