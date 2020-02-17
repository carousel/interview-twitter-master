package com.javalanguagezone.interviewtwitter.facade;

import com.javalanguagezone.interviewtwitter.facade.dto.UserProfileDTO;
import com.javalanguagezone.interviewtwitter.service.TweetService;
import com.javalanguagezone.interviewtwitter.service.UserService;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingByConcurrent;
import static java.util.stream.Collectors.toList;

@Service
public class UserProfileFacade {

  private static final String NUMBER_OF_TWEETS = "numberOfTweets";
  private static final String FOLLOWERS = "followers";
  private static final String FOLLOWING = "following";

  private TweetService tweetService;
  private UserService userService;

  public UserProfileFacade(TweetService tweetService, UserService userService) {
    this.tweetService = tweetService;
    this.userService = userService;
  }

  public UserProfileDTO getUserProfile(Principal principal) {
    return collectProfileData(principal);
  }

  private UserProfileDTO collectProfileData(Principal principal) {
    String username = principal.getName();
    Integer numberOfTweets = tweetService.tweetsFromUser(username).size();
    Integer followers = userService.getUsersFollowers(principal).size();
    Integer following = userService.getUsersFollowing(principal).size();
    return mapProfileToDTO(numberOfTweets, followers, following);
  }

  private UserProfileDTO mapProfileToDTO(Integer numberOfTweets, Integer followers, Integer following) {
    Map<String, Integer> profileData = new HashMap<>();
    profileData.put(NUMBER_OF_TWEETS, numberOfTweets);
    profileData.put(FOLLOWERS, followers);
    profileData.put(FOLLOWING, following);
    return new UserProfileDTO(profileData);
  }

  public static class UnknownUsernameException extends RuntimeException {
    @Getter
    private String username;

    private UnknownUsernameException(String username) {
      super(username);
      this.username = username;
    }
  }

}
