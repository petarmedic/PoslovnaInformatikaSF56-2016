package com.poslovna.Poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.Poslovna.domain.StopaPdv;


@Repository
public interface StopaPdvRepository extends JpaRepository<StopaPdv, Long>{

}