package com.fxf.profile.entities.dto;

import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PortfolioDto {

  private Long id;
  private String description;
  private String experienceSummary;
  private String imageUrl;
  private String names;
  private String phone;
  private String twitterUser;
  private String twitterUserId;
  private String title;
  private String userId;
  private String address;
  private String email;
  private String experience;
  private String imagePath;
  private String name;
  private String zipCode;

}
