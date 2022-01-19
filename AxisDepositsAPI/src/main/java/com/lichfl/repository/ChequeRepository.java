package com.lichfl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lichfl.entity.ChequeDetails;

@Repository
public interface ChequeRepository extends JpaRepository<ChequeDetails, Long> {
	
	
	/*
	 * @Modifying
	 * 
	 * @Query( value = "update  axis_reco_stg set  status='D' where txn_id = :id",
	 * nativeQuery = true) public long updateTxn(@Param("id") Long txnID);
	 */


}
