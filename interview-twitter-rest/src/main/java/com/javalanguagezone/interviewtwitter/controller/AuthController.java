package com.javalanguagezone.interviewtwitter.controller;

import com.javalanguagezone.interviewtwitter.domain.User;
import com.javalanguagezone.interviewtwitter.repository.UserRepository;
import com.javalanguagezone.interviewtwitter.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

import java.util.Collection;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class AuthController {

  private UserService userService;
  private UserRepository userRepository;

  public AuthController(UserService userService, UserRepository userRepository) {
    this.userService = userService;
    this.userRepository = userRepository;
  }


  @PostMapping("/register")
  @ResponseStatus(CREATED)
  public void register(@RequestBody User user) {
    userService.createNewUser(user);
  }

}
