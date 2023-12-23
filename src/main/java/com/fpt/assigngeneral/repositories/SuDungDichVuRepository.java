package com.fpt.assigngeneral.repositories;


import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpt.assigngeneral.entities.SuDungDichVu;

@Repository
public interface SuDungDichVuRepository extends JpaRepository<SuDungDichVu, Serializable>{

}
