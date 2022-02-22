package com.poslovna.Poslovna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.Poslovna.domain.PoslovniPartner;

@Repository
public interface PoslovniPartnerRepository extends JpaRepository<PoslovniPartner, Long>{

	public List<PoslovniPartner> findByMestoId(Long mestoId);
	
}
