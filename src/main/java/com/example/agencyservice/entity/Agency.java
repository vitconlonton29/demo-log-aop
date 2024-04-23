package com.example.agencyservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Agency {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String address;
  private String email;
}
