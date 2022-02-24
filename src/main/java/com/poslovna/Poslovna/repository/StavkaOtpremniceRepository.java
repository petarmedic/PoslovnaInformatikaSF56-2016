package com.poslovna.Poslovna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poslovna.Poslovna.domain.StavkaOtpremnice;


@Repository
public interface StavkaOtpremniceRepository extends JpaRepository<StavkaOtpremnice, Long> {
	
	@Query("select e from StavkaOtpremnice e where e.obrisano=false")
	List<StavkaOtpremnice> findAllOtpremnice();
}
