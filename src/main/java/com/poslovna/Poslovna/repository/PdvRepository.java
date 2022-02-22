package com.poslovna.Poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.Poslovna.domain.Pdv;



@Repository
public interface PdvRepository extends JpaRepository<Pdv, Long> {

}