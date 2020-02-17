package com.javalanguagezone.interviewtwitter.facade.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

import static lombok.AccessLevel.PRIVATE;


@Getter
@NoArgsConstructor(access = PRIVATE)
public class UserProfileDTO {
  private static final String NUMBER_OF_TWEETS = "numberOfTweets";
  private static final String FOLLOWERS = "followers";
  private static final String FOLLOWING = "following";

  private Integer numberOfTweets;
  private Integer followers;
  private Integer following;

  public UserProfileDTO(Map<String, Integer> profileData) {
    this.numberOfTweets = profileData.get(NUMBER_OF_TWEETS);
    this.followers = profileData.get(FOLLOWERS);
    this.following = profileData.get(FOLLOWING);
  }
}
