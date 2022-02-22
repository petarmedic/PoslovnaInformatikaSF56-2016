package com.poslovna.Poslovna.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.Poslovna.domain.Mesto;


@Repository
public interface MestoRepository extends JpaRepository<Mesto, Long> {

}
