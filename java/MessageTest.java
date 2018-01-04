package MagicStay;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class MessageTest extends Test {
  public User createUser() {

    return new User(
        "Antonio",
        "Antonio Melo",
        "antonio@gmail.com",
        "12345",
        "Portugal",
        "911111111",
        "Empresa",
        123L,
        123L,
        50000L);
  }

  public Landlord createLandlord() {

    return new Landlord(
        "Bruno",
        "Bruno Santos",
        MagicStay.quotes.MaleQuote.getInstance(),
        "922222222",
        "bruno@gmail.com",
        "1234",
        MagicStay.quotes.EnglishQuote.getInstance(),
        "Rua das Flores",
        "Porto",
        "4400-458",
        "Portugal",
        "www.casas.com",
        MagicStay.quotes.OwnerQuote.getInstance(),
        0L);
  }

  public void testCreateMessage() {

    User u1 = createUser();
    User u2 = createUser();
    Landlord l1 = createLandlord();
    Landlord l2 = createLandlord();
    Message m1 = new Message(u1, u2, "Hello", null);
    Message m2 = new Message(u1, l1, "Hello", null);
    Message m3 = new Message(l1, u1, "Hello", null);
    Message m4 = new Message(l1, l2, "Hello", null);
    assert_(SetUtil.inSet(m1, u2.getMessages()));
    assert_(SetUtil.inSet(m2, l1.getMessages()));
    assert_(SetUtil.inSet(m3, u1.getMessages()));
    assert_(SetUtil.inSet(m4, l2.getMessages()));
  }

  public void testConversation() {

    User u1 = createUser();
    User u2 = createUser();
    Message m1 = new Message(u1, u2, "Hello", null);
    Message m2 = new Message(u2, u1, "Hello", m1);
    Message m3 = new Message(u1, u2, "How are you?", m2);
    Message m4 = new Message(u2, u1, "Good", m3);
    VDMSeq c = m4.getConversation();
    assert_(Utils.equals(SeqUtil.seq(m1, m2, m3, m4), c));
  }

  public void test() {

    testCreateMessage();
  }

  public MessageTest() {}

  public String toString() {

    return "MessageTest{}";
  }
}
