package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.model.Detalle_compra;

@Repository
public interface DetalleCompraRepository extends JpaRepository <Detalle_compra, Integer>{

}
