 package com.lichfl.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "axis_reco_stg")
// table name in database is  axis_reco_stg schema in LICHFLDBTEST - testserver
public class ChequeDetails {
	

	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "txn_id")
	private Long txnId;
	
	@Column(name = "value_date")	
	private String valueDate;
	
	private String description;
	
	@Column(name ="instrument_ref_no")
	private String instrumentRefNo;
	
	@Column(name = "debit_amount")
	private long debitAmount;
	
	@Column(name = "credit_amount")
	private long creditAmount;
	
	@Column(name = "created_date")
	private String createdDate;
	
	//@Column(columnDefinition = "varchar2(1) default 'A'")
	private String status;
	
	

}
