package com.backendproject.backendproject.repositorio;

import com.backendproject.backendproject.model.Firma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmaRepositorio extends JpaRepository <Firma, Long>{
}
