package com.lichfl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "txn_details")
public class ChequeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long txnId;
	private String txnDetails;
	private String remarks;
	private String txnType;
	private String txnCode;

}
