package com.example.agencyservice.repository;

import com.example.agencyservice.entity.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository<Agency, Integer> {
}
