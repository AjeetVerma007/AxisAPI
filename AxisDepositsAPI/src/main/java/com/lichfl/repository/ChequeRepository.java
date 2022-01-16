package com.lichfl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lichfl.entity.ChequeDetails;

@Repository
public interface ChequeRepository extends JpaRepository<ChequeDetails, Long> {

}
