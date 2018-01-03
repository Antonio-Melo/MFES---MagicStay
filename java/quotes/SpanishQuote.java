package MagicStay.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SpanishQuote {
  private static int hc = 0;
  private static SpanishQuote instance = null;

  public SpanishQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static SpanishQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new SpanishQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof SpanishQuote;
  }

  public String toString() {

    return "<Spanish>";
  }
}
