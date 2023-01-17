package com.azapienc.security.demo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azapienc.security.service.UserBasicResponse;
import com.azapienc.security.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
  private final UserService userService;

  @GetMapping("/all-users")
  public ResponseEntity<List<UserBasicResponse>> getAll() {
    return ResponseEntity.ok(userService.getAll());
  }
}
