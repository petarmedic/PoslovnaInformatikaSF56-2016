package com.poslovna.Poslovna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.poslovna.Poslovna.domain.StavkaNarudzbenice;


@Repository
public interface StavkaNarudzbeniceRepository extends JpaRepository<StavkaNarudzbenice, Long> {
	
	@Query("FROM StavkaNarudzbenice sn where sn.narudzbenica = :narudzbenica")
    List<StavkaNarudzbenice> findAllByNarudzbenicaId(@Param("narudzbenica") Long narudzbenica);
	
	@Query("select e from StavkaNarudzbenice e where e.obrisano=false")
    List<StavkaNarudzbenice> findAllStavkeNarudzbenice();
}

