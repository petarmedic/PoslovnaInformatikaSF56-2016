package com.poslovna.Poslovna.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poslovna.Poslovna.domain.Narudzbenica;


@Repository
public interface NarudzbenicaRepository extends JpaRepository<Narudzbenica, Long> {

	@Query("select e from Narudzbenica e where e.obrisano=false")
    List<Narudzbenica> findAllNarudzbenice();
}

