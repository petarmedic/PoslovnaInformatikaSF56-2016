package com.poslovna.Poslovna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poslovna.Poslovna.domain.Otpremnica;



@Repository
public interface OtpremnicaRepository extends JpaRepository<Otpremnica, Long> {
	
	@Query("select e from Otpremnica e where e.obrisano=false")
    List<Otpremnica> findAllOtpremnice();
}
