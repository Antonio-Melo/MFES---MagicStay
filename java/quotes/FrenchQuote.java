package MagicStay.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class FrenchQuote {
  private static int hc = 0;
  private static FrenchQuote instance = null;

  public FrenchQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static FrenchQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new FrenchQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof FrenchQuote;
  }

  public String toString() {

    return "<French>";
  }
}
