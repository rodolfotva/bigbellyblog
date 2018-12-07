package com.tva.bigbellyblog.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Address {

  @Field("number")
  private String number;
  @Field("street")
  private String street;
  @Field("nbh")
  private String neighborhood;
  @Field("city")
  private String city;
  @Field("province")
  private String province;
  @Field("open")
  private String open;
  @Field("coord")
  private String coordinates;

  public Address() {
    super();
  }

  public Address(String number, String street, String neighborhood, String city, String province, String open, String coordinates) {
    super();
    this.number = number;
    this.street = street;
    this.neighborhood = neighborhood;
    this.city = city;
    this.province = province;
    this.open = open;
    this.coordinates = coordinates;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getNeighborhood() {
    return neighborhood;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getOpen() {
    return open;
  }

  public void setOpen(String open) {
    this.open = open;
  }

  public String getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(String coordinates) {
    this.coordinates = coordinates;
  }

}
