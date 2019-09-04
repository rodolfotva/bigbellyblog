package com.tva.bigbellyblog.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "post")
public class Post implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private ObjectId objectId;
  @Field("postId")
  private String postId;
  @Field("title")
  private String title;
  @Field("resName")
  private String restaurantName;
  @Field("contentEn")
  private String contentEn;
  @Field("contentFr")
  private String contentFr;
  @Field("contentPt")
  private String contentPt;
  @Field("website")
  private String website;
  @Field("tripadvisor")
  private String tripadvisor;
  @Field("facebook")
  private String facebook;
  @Field("foodtype")
  private String foodType;

  @Field("number")
  private String addressNumber;
  @Field("street")
  private String addressStreet;
  @Field("nbh")
  private String addressNeighbor;
  @Field("city")
  private String addressCity;
  @Field("province")
  private String addressProvince;
  @Field("open")
  private String addressOpen;
  @Field("coord")
  private String addressCoordinates;

  @Field("postDate")
  private Date postDate;

  @Field("rate")
  private Double rate;
  @Field("like")
  private Integer like;
  @Field("dislike")
  private Integer dislike;
  @Field("visitors")
  private Integer visitors;

  @Field("pics")
  private List<String> pics;

  @Field("comments")
  private List<Comment> comments;

  public Post() {
    super();
  }

  public ObjectId getObjectId() {
    return objectId;
  }

  public void setObjectId(ObjectId objectId) {
    this.objectId = objectId;
  }

  public String getPostId() {
    return postId;
  }

  public void setPostId(String postId) {
    this.postId = postId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getRestaurantName() {
    return restaurantName;
  }

  public void setRestaurantName(String restaurantName) {
    this.restaurantName = restaurantName;
  }

  public String getContentEn() {
    return contentEn;
  }

  public void setContentEn(String contentEn) {
    this.contentEn = contentEn;
  }

  public String getContentFr() {
    return contentFr;
  }

  public void setContentFr(String contentFr) {
    this.contentFr = contentFr;
  }

  public String getContentPt() {
    return contentPt;
  }

  public void setContentPt(String contentPt) {
    this.contentPt = contentPt;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public String getTripadvisor() {
    return tripadvisor;
  }

  public void setTripadvisor(String tripadvisor) {
    this.tripadvisor = tripadvisor;
  }

  public String getFacebook() {
    return facebook;
  }

  public void setFacebook(String facebook) {
    this.facebook = facebook;
  }

  public Date getPostDate() {
    return postDate;
  }

  public void setPostDate(Date postDate) {
    this.postDate = postDate;
  }

  public Double getRate() {
    return rate;
  }

  public void setRate(Double rate) {
    this.rate = rate;
  }

  public Integer getLike() {
    return like;
  }

  public void setLike(Integer like) {
    this.like = like;
  }

  public Integer getDislike() {
    return dislike;
  }

  public void setDislike(Integer dislike) {
    this.dislike = dislike;
  }

  public Integer getVisitors() {
    return visitors;
  }

  public void setVisitors(Integer visitors) {
    this.visitors = visitors;
  }

  public List<String> getPics() {
    return pics;
  }

  public void setPics(List<String> pics) {
    this.pics = pics;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  public String getAddressNumber() {
    return addressNumber;
  }

  public void setAddressNumber(String addressNumber) {
    this.addressNumber = addressNumber;
  }

  public String getAddressStreet() {
    return addressStreet;
  }

  public void setAddressStreet(String addressStreet) {
    this.addressStreet = addressStreet;
  }

  public String getAddressNeighbor() {
    return addressNeighbor;
  }

  public void setAddressNeighbor(String addressNeighbor) {
    this.addressNeighbor = addressNeighbor;
  }

  public String getAddressCity() {
    return addressCity;
  }

  public void setAddressCity(String addressCity) {
    this.addressCity = addressCity;
  }

  public String getAddressProvince() {
    return addressProvince;
  }

  public void setAddressProvince(String addressProvince) {
    this.addressProvince = addressProvince;
  }

  public String getAddressOpen() {
    return addressOpen;
  }

  public void setAddressOpen(String addressOpen) {
    this.addressOpen = addressOpen;
  }

  public String getAddressCoordinates() {
    return addressCoordinates;
  }

  public void setAddressCoordinates(String addressCoordinates) {
    this.addressCoordinates = addressCoordinates;
  }

  public String getFoodType() {
    return foodType;
  }

  public void setFoodType(String foodType) {
    this.foodType = foodType;
  }

}
