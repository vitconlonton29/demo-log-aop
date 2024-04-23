package com.example.agencyservice.controller;

import com.example.agencyservice.entity.Agency;
import com.example.agencyservice.repository.AgencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agencies")
@RequiredArgsConstructor
public class AgencyController {
  private final AgencyRepository agencyRepository;

  @GetMapping("{id}")
  public ResponseEntity<Agency> findById(@PathVariable int id) {
    return ResponseEntity.of(agencyRepository.findById(id));
  }

}
