package com.fxf.profile.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {

  private Long id;
  private String description;
  private String experienceSummary;
  private String experience;
  private String imageUrl;
  private String name;
  private String names;
  private String title;
  private String twitterUser;
  private String twitterUserId;
}
