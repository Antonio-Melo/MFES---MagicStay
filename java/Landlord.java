package MagicStay;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Landlord extends Account {
  private Object gender;
  private Object language;
  private String address;
  private String city;
  private String postalCode;
  private String country;
  private String website;
  private Object type;
  private VDMSet houses = SetUtil.set();

  public void cg_init_Landlord_1(
      final String fName,
      final String name,
      final Object gend,
      final String phoneNum,
      final String em,
      final String pw,
      final Object lang,
      final String adr,
      final String ct,
      final String pc,
      final String ctr,
      final String web,
      final Object typ,
      final Number initWallet) {

    firstName = fName;
    fullName = name;
    gender = gend;
    phoneNumber = phoneNum;
    email = em;
    password = pw;
    language = lang;
    address = adr;
    city = ct;
    postalCode = pc;
    country = ctr;
    website = web;
    type = typ;
    wallet = initWallet;
  }

  public Landlord(
      final String fName,
      final String name,
      final Object gend,
      final String phoneNum,
      final String em,
      final String pw,
      final Object lang,
      final String adr,
      final String ct,
      final String pc,
      final String ctr,
      final String web,
      final Object typ,
      final Number initWallet) {

    cg_init_Landlord_1(
        fName, name, gend, phoneNum, em, pw, lang, adr, ct, pc, ctr, web, typ, initWallet);
  }

  public Object getGender() {

    return gender;
  }

  public Object getLanguage() {

    return language;
  }

  public String getAddress() {

    return address;
  }

  public String getCity() {

    return city;
  }

  public String getPostalCode() {

    return postalCode;
  }

  public String getCountry() {

    return country;
  }

  public String getWebsite() {

    return website;
  }

  public Object getType() {

    return type;
  }

  public VDMSet getHouses() {

    return Utils.copy(houses);
  }

  public void addHouse(final Accomodation house) {

    houses = SetUtil.union(Utils.copy(houses), SetUtil.set(house));
  }

  public String getUserType() {

    return "Landlord";
  }

  public Landlord() {}

  public String toString() {

    return "Landlord{"
        + "gender := "
        + Utils.toString(gender)
        + ", language := "
        + Utils.toString(language)
        + ", address := "
        + Utils.toString(address)
        + ", city := "
        + Utils.toString(city)
        + ", postalCode := "
        + Utils.toString(postalCode)
        + ", country := "
        + Utils.toString(country)
        + ", website := "
        + Utils.toString(website)
        + ", type := "
        + Utils.toString(type)
        + ", houses := "
        + Utils.toString(houses)
        + "}";
  }
}
