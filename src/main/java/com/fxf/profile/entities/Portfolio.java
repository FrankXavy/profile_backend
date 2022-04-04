package com.fxf.profile.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="portfolio")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Portfolio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idportfolio")
  private Long id;

  @Column(name = "description")
  private String description;

  @Column(name = "experience_summary")
  private String experienceSummary;

  @Column(name = "image_url")
  private String imageUrl;

  @Column(name = "names")
  private String names;

  @Column(name = "phone")
  private String phone;

  @Column(name = "twitter_user_name")
  private String twitterUser;

  @Column(name = "twitter_user_id")
  private String twitterUserId;

  @Column(name = "title")
  private String title;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "address")
  private String address;

  @Column(name = "email")
  private String email;

  @Column(name = "experience")
  private String experience;

  @Column(name = "image_path")
  private String imagePath;

  @Column(name = "name")
  private String name;

  @Column(name = "zip_code")
  private String zipCode;

  //contructor with parameters


  public Portfolio(String description, String experienceSummary, String imageUrl, String name, String phone, String twitterUser,
                   String twitterUserId, String title) {
    this.description = description;
    this.experienceSummary = experienceSummary;
    this.imageUrl = imageUrl;
    this.name = name;
    this.phone = phone;
    this.twitterUser = twitterUser;
    this.twitterUserId = twitterUserId;
    this.title = title;
  }
}
