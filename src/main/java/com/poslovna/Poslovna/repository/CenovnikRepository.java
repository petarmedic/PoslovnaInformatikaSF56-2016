package com.poslovna.Poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.Poslovna.domain.Cenovnik;



@Repository
public interface CenovnikRepository extends JpaRepository<Cenovnik, Long> {

}
