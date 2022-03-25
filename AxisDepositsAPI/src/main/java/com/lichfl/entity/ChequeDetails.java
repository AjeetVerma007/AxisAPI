package com.lichfl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Table(name = "axis_reco_stg")
@Table(name = "bank_reco_stg")
// table name in database is  axis_reco_stg schema in LICHFLDBTEST - testserver
public class ChequeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bank_txn_id")
	private Long bankTxnId;

	@NotNull
	private String bankLoc;

	@NotNull
	// custCode
	String col1;

	// prodCode
	@NotNull
	String col2;

	// depSlipNo
	@NotNull
	String col3;

	// totSlipAmnt
	@NotNull
	String col4;

	// depDate
	@NotNull
	String col5;

	// adjDate
	String col6;

	// clearingDate
	@NotNull
	String col7;

	// creditDate
	@NotNull
	String col8;

	// divCode
	@NotNull
	String col9;

	// drawnLoc
	String col10;

	// instNo
	@NotNull
	String col11;

	// instAmnt
	@NotNull
	String col12;

	// realDate
	String col13;

	// returnDate
	String col14;

	// recovDate
	String col15;

	// instDate
	@NotNull
	String col16;

	// noOfInst
	String col17;

	// returnCode
	String col18;

	// returnReason
	String col19;

	// instAddnInfo1
	@NotNull
	String col20;

	// instAddnInfo3
	@NotNull
	String col21;

	// instAddnInfo4
	@NotNull(message = "Mandatory field")
	String col22;

	// String createdDate;
	String col23;

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO)
	 * 
	 * @Column(name = "txn_id") private Long txnId;
	 * 
	 * @NotNull String custCode;
	 * 
	 * @NotNull String prodCode;
	 * 
	 * @NotNull String depSlipNo;
	 * 
	 * @NotNull String totSlipAmnt;
	 * 
	 * @NotNull String depDate; String adjDate;
	 * 
	 * @NotNull String clearingDate;
	 * 
	 * @NotNull String creditDate;
	 * 
	 * @NotNull String divCode; String drawnLoc;
	 * 
	 * @NotNull String instNo;
	 * 
	 * @NotNull String instAmnt; String realDate; String returnDate; String
	 * recovDate;
	 * 
	 * @NotNull String instDate; String noOfInst; String returnCode; String
	 * returnReason;
	 * 
	 * @NotNull String instAddnInfo1;
	 * 
	 * @NotNull String instAddnInfo3;
	 * 
	 * @NotNull(message = "Mandatory field") String instAddnInfo4; //String
	 * instAddnInfo5; String createdDate;
	 */

}
