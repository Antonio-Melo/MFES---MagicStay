package MagicStay.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ItalianQuote {
  private static int hc = 0;
  private static ItalianQuote instance = null;

  public ItalianQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ItalianQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ItalianQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ItalianQuote;
  }

  public String toString() {

    return "<Italian>";
  }
}
