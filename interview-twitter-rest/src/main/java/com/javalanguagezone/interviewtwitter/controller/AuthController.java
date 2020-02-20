package com.javalanguagezone.interviewtwitter.controller;

import com.javalanguagezone.interviewtwitter.domain.User;
import com.javalanguagezone.interviewtwitter.repository.UserRepository;
import com.javalanguagezone.interviewtwitter.service.UserService;
import com.javalanguagezone.interviewtwitter.service.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

import java.util.Collection;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class AuthController {

  private UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }


  /**
   * endpoint for registering new User
   *
   * @param user User bean
   * @return newly created User
   */
  @PostMapping("/register")
  @ResponseStatus(CREATED)
  public User register(@RequestBody User user) {
    return userService.createNewUser(user);
  }

}
