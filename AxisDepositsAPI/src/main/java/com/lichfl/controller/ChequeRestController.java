package com.lichfl.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lichfl.entity.ChequeDetails;
import com.lichfl.entity.RequestParam;
import com.lichfl.entity.ResponseText;
import com.lichfl.service.ChequeService;

@RestController
@Validated
public class ChequeRestController {

	@Autowired
	ChequeService chequeService;

	@Autowired
	ResponseText responseText;

	private String msg;

	private final Logger logger = LoggerFactory.getLogger(ChequeRestController.class);

	@PostMapping("/txns")
	public ResponseEntity<ResponseText> saveChequeDtls(
			// @Valid @RequestBody HashMap<String, String> requestData
			@Valid @RequestBody RequestParam requestParam

	/*
	 * @RequestBody ChequeDetails chequeDetails
	 */

	) throws Exception {

		logger.info("Inside save method");

//		String custCode = requestData.get("custCode");
//		String bankLoc = requestData.get("bankLoc");
//		String prodCode = requestData.get("prodCode");
//		String depSlipNo = requestData.get("depSlipNo");
//		String totSlipAmnt = requestData.get("totSlipAmnt");
//		String depDate = requestData.get("depDate");
//		String adjDate = requestData.get("adjDate");
//		String clearingDate = requestData.get("clearingDate");
//		String creditDate = requestData.get("creditDate");
//		String divCode = requestData.get("divCode");
//		String drawnLoc = requestData.get("drawnLoc");
//		String instNo = requestData.get("instNo");
//		String instAmnt = requestData.get("instAmnt");
//		String realDate = requestData.get("realDate");
//		String returnDate = requestData.get("returnDate");
//		String recovDate = requestData.get("recovDate");
//		String instDate = requestData.get("instDate");
//		String noOfInst = requestData.get("noOfInst");
//		String returnCode = requestData.get("returnCode");
//		String returnReason = requestData.get("returnReason");
//		String instAddnInfo1 = requestData.get("instAddnInfo1");
//		String instAddnInfo3 = requestData.get("instAddnInfo3");
//		String instAddnInfo4 = requestData.get("instAddnInfo4");

		String validationResp = chequeService.validateRequestParam(requestParam);

		logger.info("validationResp:" + validationResp);

		/*
		 * String custCode = requestData.get("customer code"); String prodCode =
		 * requestData.get("product code"); String depSlipNo =
		 * requestData.get("deposit slip_no"); String totSlipAmnt =
		 * requestData.get("total slip_amt"); String depDate =
		 * requestData.get("deposit date"); String adjDate =
		 * requestData.get("adjustment date"); String clearingDate =
		 * requestData.get("clearing date"); String creditDate =
		 * requestData.get("credit date"); String divCode = requestData.get("div code");
		 * String drawnLoc = requestData.get("drawn on location"); String instNo =
		 * requestData.get("instrument number"); String instAmnt =
		 * requestData.get("instrument amount"); String realDate =
		 * requestData.get("realisation date"); String returnDate =
		 * requestData.get("return date"); String recovDate =
		 * requestData.get("recovered date"); String instDate =
		 * requestData.get("instrument date"); String noOfInst =
		 * requestData.get("number of instruments"); String returnCode =
		 * requestData.get("return code"); String returnReason =
		 * requestData.get("return reason"); String instAddnInfo1 =
		 * requestData.get("inst_addn_info1"); String instAddnInfo3 =
		 * requestData.get("inst_addn_info3"); String instAddnInfo4 =
		 * requestData.get("inst_addn_info4"); //String instAddnInfo5 =
		 * requestData.get("inst_addn_info5");
		 */
		/*
		 * ChequeDetails chequeDetails =
		 * ChequeDetails.builder().custCode(custCode).prodCode(prodCode).depSlipNo(
		 * depSlipNo)
		 * .totSlipAmnt(totSlipAmnt).depDate(depDate).adjDate(adjDate).clearingDate(
		 * clearingDate)
		 * .creditDate(creditDate).divCode(divCode).drawnLoc(drawnLoc).instNo(instNo).
		 * instAmnt(instAmnt)
		 * .realDate(realDate).returnDate(returnDate).recovDate(recovDate).instDate(
		 * instDate).noOfInst(noOfInst)
		 * .returnCode(returnCode).returnReason(returnReason).instAddnInfo1(
		 * instAddnInfo1)
		 * .instAddnInfo3(instAddnInfo3).instAddnInfo4(instAddnInfo4).build();
		 */

		if (validationResp.equalsIgnoreCase("success")) {
			ChequeDetails chequeDetails = ChequeDetails.builder().bankLoc(requestParam.getBankLoc())
					.col1(requestParam.getCustCode()).col2(requestParam.getProdCode()).col3(requestParam.getDepSlipNo())
					.col4(requestParam.getTotSlipAmnt()).col5(requestParam.getDepDate()).col6(requestParam.getAdjDate())
					.col7(requestParam.getClearingDate()).col8(requestParam.getCreditDate())
					.col9(requestParam.getDivCode()).col10(requestParam.getDrawnLoc()).col11(requestParam.getInstNo())
					.col12(requestParam.getInstAmnt()).col13(requestParam.getRealDate())
					.col14(requestParam.getReturnDate()).col15(requestParam.getRecovDate())
					.col16(requestParam.getInstDate()).col17(requestParam.getNoOfInst())
					.col18(requestParam.getReturnCode()).col19(requestParam.getReturnReason())
					.col20(requestParam.getInstAddnInfo1()).col21(requestParam.getInstAddnInfo3())
					.col22(requestParam.getInstAddnInfo4()).build();

			/*
			 * ChequeDetails chequeDetails =
			 * ChequeDetails.builder().bankLoc(bankLoc).col1(custCode).col2(prodCode).col3(
			 * depSlipNo) .col4(totSlipAmnt).col5(depDate).col6(adjDate).col7(clearingDate)
			 * .col8(creditDate).col9(divCode).col10(drawnLoc).col11(instNo).col12(instAmnt)
			 * .col13(realDate).col14(returnDate).col15(recovDate).col16(instDate).col17(
			 * noOfInst) .col18(returnCode).col19(returnReason).col20(instAddnInfo1)
			 * .col21(instAddnInfo3).col22(instAddnInfo4).build();
			 */

			logger.info("ChequeDetails :" + chequeDetails.toString());

			chequeService.saveTxns(chequeDetails);

			msg = "Data has been saved successfully";

			ResponseText responseText2 = ResponseText.builder().status("SUCCESS").message(msg).build();

			return new ResponseEntity<ResponseText>(responseText2, HttpStatus.OK);
		} else
			msg = "Please check the mandatory parameters";
		ResponseText responseText = ResponseText.builder().status("FAILURE").message(msg).build();
		return new ResponseEntity<ResponseText>(responseText,HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/txns")
	public ResponseEntity<List<ChequeDetails>> getChequeDtls() throws Exception {

		logger.info("Inside get method");
		List<ChequeDetails> chequeDetails = chequeService.getTxns();

		return new ResponseEntity<List<ChequeDetails>>(chequeDetails, HttpStatus.OK);
	}

	@GetMapping("/txns/{id}")
	public ResponseEntity<ChequeDetails> getChequeDtlsById(@PathVariable("id") Long txnId) throws Exception {
		logger.info("Inside get by ID method");

		ChequeDetails chequeDetails = chequeService.getChequeDtlsById(txnId);

		return new ResponseEntity<ChequeDetails>(chequeDetails, HttpStatus.OK);
	}

	@DeleteMapping("/txns/{id}")
	public ResponseEntity<String> deleteChequeDtlsById(@PathVariable("id") Long txnId) {
		String message = null;

		try {
			chequeService.deleteChequeDtlsById(txnId);
			message = "Transaction has been deleted";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(" ID does not exists in Database");
		}
		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}

	@PutMapping("/txns/{id}")
	public ResponseEntity<ChequeDetails> updateChequeDtls(@PathVariable("id") Long id,
			@RequestBody ChequeDetails chequeDetails) {

		ChequeDetails chequeDetails2 = chequeService.updateChequeDtls(id, chequeDetails);
		return new ResponseEntity<ChequeDetails>(chequeDetails2, HttpStatus.CREATED);
	}

}
