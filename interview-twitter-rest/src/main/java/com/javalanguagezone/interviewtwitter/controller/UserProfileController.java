package com.javalanguagezone.interviewtwitter.controller;

import com.javalanguagezone.interviewtwitter.controller.dto.ErrorMessage;
import com.javalanguagezone.interviewtwitter.domain.User;
import com.javalanguagezone.interviewtwitter.facade.UserProfileFacade;
import com.javalanguagezone.interviewtwitter.facade.UserProfileFacade.UnknownUsernameException;
import com.javalanguagezone.interviewtwitter.facade.dto.UserProfileDTO;
import com.javalanguagezone.interviewtwitter.repository.UserRepository;
import com.javalanguagezone.interviewtwitter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.security.Principal;


import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@Slf4j
public class UserProfileController {

  private UserProfileFacade userProfileFacade;
  private UserService userService;

  public UserProfileController(UserProfileFacade userProfileFacade) {
    this.userProfileFacade = userProfileFacade;
  }

  @GetMapping("/profile")
  public UserProfileDTO getUserProfile(Principal principal) {
    return userProfileFacade.getUserProfile(principal);
  }

  /**
   * log.info is here for admin informative purposes(good practice)
   */
  @ExceptionHandler
  @ResponseStatus(BAD_REQUEST)
  public ErrorMessage handleUnknownUsernameException(UnknownUsernameException e) {
    log.info(e.getUsername() + " was trying to fetch profile data", e);
    log.warn("", e);
    return new ErrorMessage(String.format("Unknown user '%s'", e.getUsername()));
  }
}
