package com.javalanguagezone.interviewtwitter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javalanguagezone.interviewtwitter.facade.dto.UserProfileDTO;
import com.javalanguagezone.interviewtwitter.service.dto.TweetDTO;
import com.javalanguagezone.interviewtwitter.service.dto.UserDTO;
import net.minidev.json.JSONObject;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class UserProfileControllerIntegrationTest extends RestIntegrationTest {

  @Test
  public void profileRequested_userProfileReturned() throws IOException {
    ResponseEntity<String> response = withAuthTestRestTemplate().getForEntity("/profile", String.class);
    assertThat(response.getStatusCode().is2xxSuccessful(), is(true));
    String userProfile = response.getBody();
    ObjectMapper objectMapper = new ObjectMapper();
    UserProfileDTO userProfileDTO = objectMapper.readValue(userProfile, UserProfileDTO.class);
    Integer numberOfTweets = userProfileDTO.getNumberOfTweets();
    Integer followers = userProfileDTO.getFollowers();
    Integer following = userProfileDTO.getFollowing();
    assertEquals((int) numberOfTweets, 3);
    assertEquals((int) followers, 1);
    assertEquals((int) following, 4);
  }


}
