package com.javalanguagezone.interviewtwitter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javalanguagezone.interviewtwitter.controller.dto.ErrorMessage;
import com.javalanguagezone.interviewtwitter.domain.Tweet;
import com.javalanguagezone.interviewtwitter.domain.User;
import com.javalanguagezone.interviewtwitter.repository.TweetRepository;
import com.javalanguagezone.interviewtwitter.repository.UserRepository;
import com.javalanguagezone.interviewtwitter.service.dto.TweetDTO;
import com.javalanguagezone.interviewtwitter.service.dto.UserDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class AuthControllerIntegrationTest extends RestIntegrationTest {

  @Autowired
  UserRepository userRepository;

  @Test
  public void registerUser_userIsRegistered() throws JsonProcessingException {
    String firstName = "Jimi";
    String lastName = "Hendrix";
    String username = "jimi";
    String password = "password";
    User user = new User(firstName, lastName, username, password);
    ResponseEntity<User> response = withAuthTestRestTemplate().postForEntity("/register", user, User.class);
    assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
    User responseUser = response.getBody();
    User fromDb = userRepository.findOne(responseUser.getId());
    assertThat(fromDb, notNullValue());
    assertThat(fromDb.getUsername(), equalTo(responseUser.getUsername()));
  }

}
