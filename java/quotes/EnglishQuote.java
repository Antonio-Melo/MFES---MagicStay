package MagicStay.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class EnglishQuote {
  private static int hc = 0;
  private static EnglishQuote instance = null;

  public EnglishQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static EnglishQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new EnglishQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof EnglishQuote;
  }

  public String toString() {

    return "<English>";
  }
}
