package MagicStay;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class MagicStayTest {
  public static void main() {

    IO.println("Starting MagicStay Tests");
    IO.print("Testing User...");
    new UserTest().test();
    IO.println("successfully!");
    IO.print("Testing Landlord...");
    new LandlordTest().test();
    IO.println("successfully!");
    IO.print("Testing Accomodation...");
    new AccomodationTest().test();
    IO.println("successfully!");
    IO.print("Testing Reservation...");
    new ReservationTest().test();
    IO.println("successfully!");
    IO.print("Testing Review...");
    new ReviewTest().test();
    IO.println("successfully!");
    IO.print("Testing Search...");
    new SearchTest().test();
    IO.println("successfully!");
    IO.print("Testing Message...");
    new MessageTest().test();
    IO.println("successfully!");
    IO.print("Testing a real case use of Magic Stay...");
    new RealCaseTest().test();
    IO.println("successfully!");
  }

  public MagicStayTest() {}

  public String toString() {

    return "MagicStayTest{}";
  }
}
