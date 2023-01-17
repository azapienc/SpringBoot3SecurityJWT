package com.azapienc.security.demo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azapienc.security.service.UserBasicResponse;
import com.azapienc.security.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController {
  private final UserService userService;

  @GetMapping("/all-users")
  public ResponseEntity<List<UserBasicResponse>> getAll() {
    log.info("Getting all users");
    return ResponseEntity.ok(userService.getAll());
  }
}
