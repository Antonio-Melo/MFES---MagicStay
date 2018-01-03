package MagicStay;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
abstract public class Account {
  protected String firstName;
  protected String fullName;
  protected String email;
  protected String password;
  protected String phoneNumber;
  protected Number wallet;
  protected VDMSet inbox = SetUtil.set();

  public String getFirstName() {

    return firstName;
  }

  public String getFullName() {

    return fullName;
  }

  public String getEmail() {

    return email;
  }

  public String getPassword() {

    return password;
  }

  public String getPhoneNumber() {

    return phoneNumber;
  }

  public Number getWallet() {

    return wallet;
  }

  public VDMSet getMessages() {

    return Utils.copy(inbox);
  }

  public void transaction(final Number value) {

    wallet = wallet.doubleValue() + value.doubleValue();
  }

  public void addMessage(final Message message) {

    inbox = SetUtil.union(Utils.copy(inbox), SetUtil.set(message));
  }

  public abstract String getUserType();

  public Account() {}

  public String toString() {

    return "Account{"
        + "firstName := "
        + Utils.toString(firstName)
        + ", fullName := "
        + Utils.toString(fullName)
        + ", email := "
        + Utils.toString(email)
        + ", password := "
        + Utils.toString(password)
        + ", phoneNumber := "
        + Utils.toString(phoneNumber)
        + ", wallet := "
        + Utils.toString(wallet)
        + ", inbox := "
        + Utils.toString(inbox)
        + "}";
  }
}
