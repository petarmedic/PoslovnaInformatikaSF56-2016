package com.poslovna.Poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.Poslovna.domain.Otpremnica;



@Repository
public interface OtpremnicaRepository extends JpaRepository<Otpremnica, Long> {
	

}
