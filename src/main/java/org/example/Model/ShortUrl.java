package org.example.Model;

import java.util.Date;

public class ShortUrl {
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLongUrl() {
    return longUrl;
  }

  public void setLongUrl(String longUrl) {
    this.longUrl = longUrl;
  }

  public String getHashCode() {
    return hashCode;
  }

  public void setHashCode(String hashCode) {
    this.hashCode = hashCode;
  }

  public String getManualName() {
    return manualName;
  }

  public void setManualName(String manualName) {
    this.manualName = manualName;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Date getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(Date expiryDate) {
    this.expiryDate = expiryDate;
  }

  /*
      Table urls:-
    - id
    - longUrl (mainUrl)
    - hashcode
    - manualUrlName
    - createdAt
    - updatedAt
    - expiryDate
     */
  private Integer id;
  private String longUrl;
  private String hashCode;
  private String manualName;
  private Date createdAt;
  private Date updatedAt;
  private Date expiryDate;
}
