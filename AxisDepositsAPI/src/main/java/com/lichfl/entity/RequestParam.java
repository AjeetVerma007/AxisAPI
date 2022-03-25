package com.lichfl.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class RequestParam {

	private String bankLoc;
	 private String custCode;
	 private String prodCode;
	 private String depSlipNo;
	 private String totSlipAmnt;
	 private String depDate;
	 private String adjDate;
	 private String clearingDate;
	 private String creditDate;
	 private String divCode;
	 private String drawnLoc;
	 private String instNo;
	 private String instAmnt;
	 private String realDate;
	 private String returnDate;
	 private String recovDate;
	 private String instDate;
	 private String noOfInst;
	 private String returnCode;
	 private String returnReason;
	 private String instAddnInfo1;
	 private String instAddnInfo3;
	 private String instAddnInfo4;
	 private String createdDate;

}
