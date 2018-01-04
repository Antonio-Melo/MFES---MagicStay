package MagicStay;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class User extends Account {
  private String country;
  private String company;
  private Number companyRegNum;
  private Number vat;
  private VDMSet favorites = SetUtil.set();

  public void cg_init_User_1(
      final String fName,
      final String name,
      final String em,
      final String pw,
      final String count,
      final String phNum,
      final String cp,
      final Number cpRegNum,
      final Number v,
      final Number initWallet) {

    firstName = fName;
    fullName = name;
    email = em;
    password = pw;
    country = count;
    phoneNumber = phNum;
    company = cp;
    companyRegNum = cpRegNum;
    vat = v;
    wallet = initWallet;
  }

  public User(
      final String fName,
      final String name,
      final String em,
      final String pw,
      final String count,
      final String phNum,
      final String cp,
      final Number cpRegNum,
      final Number v,
      final Number initWallet) {

    cg_init_User_1(fName, name, em, pw, count, phNum, cp, cpRegNum, v, initWallet);
  }

  public String getCountry() {

    return country;
  }

  public String getCompany() {

    return company;
  }

  public Number getCompanyRegNum() {

    return companyRegNum;
  }

  public Number getVat() {

    return vat;
  }

  public VDMSet getFavorites() {

    return Utils.copy(favorites);
  }

  public void addFavorite(final Accomodation h) {

    favorites = SetUtil.union(Utils.copy(favorites), SetUtil.set(h));
  }

  public void addFavorites(final VDMSet acc) {

    for (Iterator iterator_3 = acc.iterator(); iterator_3.hasNext(); ) {
      Accomodation a = (Accomodation) iterator_3.next();
      favorites = SetUtil.union(Utils.copy(favorites), SetUtil.set(a));
    }
  }

  public void removeFavorite(final Accomodation h) {

    favorites = SetUtil.diff(Utils.copy(favorites), SetUtil.set(h));
  }

  public String getUserType() {

    return "User";
  }

  public User() {}

  public String toString() {

    return "User{"
        + "country := "
        + Utils.toString(country)
        + ", company := "
        + Utils.toString(company)
        + ", companyRegNum := "
        + Utils.toString(companyRegNum)
        + ", vat := "
        + Utils.toString(vat)
        + ", favorites := "
        + Utils.toString(favorites)
        + "}";
  }
}
