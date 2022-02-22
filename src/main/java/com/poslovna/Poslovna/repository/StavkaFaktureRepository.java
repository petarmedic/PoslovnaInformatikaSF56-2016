package com.poslovna.Poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.Poslovna.domain.StavkaFakture;

@Repository
public interface StavkaFaktureRepository extends JpaRepository<StavkaFakture, Long>{

}
