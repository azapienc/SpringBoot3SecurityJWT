package com.azapienc.security.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.azapienc.security.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository repository;

  public List<UserBasicResponse> getAll() {
    return repository.findAll().stream().map(user -> {
      return UserBasicResponse.builder()
          .id(user.getId())
          .firstname(user.getFirstname())
          .lastname(user.getLastname())
          .email(user.getEmail())
          .build();
    }).collect(Collectors.toList());
  }
}
