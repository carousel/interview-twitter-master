package com.javalanguagezone.interviewtwitter.controller;

import com.javalanguagezone.interviewtwitter.controller.dto.ErrorMessage;
import com.javalanguagezone.interviewtwitter.facade.UserProfileFacade;
import com.javalanguagezone.interviewtwitter.facade.UserProfileFacade.UnknownUsernameException;
import com.javalanguagezone.interviewtwitter.facade.dto.UserProfileDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@Slf4j
public class UserProfileController {

  private UserProfileFacade userProfileFacade;

  public UserProfileController(UserProfileFacade userProfileFacade) {
    this.userProfileFacade = userProfileFacade;
  }

  @GetMapping("/profile")
  public UserProfileDTO getUserProfile(Principal principal) {
    return userProfileFacade.getUserProfile(principal);
  }

  @ExceptionHandler
  @ResponseStatus(BAD_REQUEST)
  public ErrorMessage handleUnknownUsernameException(UnknownUsernameException e) {
    log.info(e.getUsername() + " was trying to fetch profile data", e);
    log.warn("", e);
    return new ErrorMessage(String.format("Unknown user '%s'", e.getUsername()));
  }
}
