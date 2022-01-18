 package com.lichfl.entity;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "axis_reco_stg")
// table name in database is  txn_details schema is feedback in local 
public class ChequeDetails {
	

	private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String valueDate;
	private String description;
	private String instrumentRefNo;
	private long debitAmount;
	private long creditAmount;
	@Column(name = "created_date")
    @CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(columnDefinition = "varchar(1) default 'A'")
	private String status;
	
	

}
