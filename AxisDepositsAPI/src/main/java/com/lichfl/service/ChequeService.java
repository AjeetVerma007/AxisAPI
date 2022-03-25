package com.lichfl.service;

import java.util.HashMap;
import java.util.List;

import com.lichfl.entity.ChequeDetails;
import com.lichfl.entity.RequestParam;

public interface ChequeService {

	public ChequeDetails saveTxns(ChequeDetails chequeDetails) throws Exception ;

	public List<ChequeDetails> getTxns() throws Exception ;

	public ChequeDetails getChequeDtlsById(Long txnId) throws Exception ;

	public void deleteChequeDtlsById(Long txnId);

	public ChequeDetails updateChequeDtls(Long id, ChequeDetails chequeDetails);
	
	public String validateRequestParam(RequestParam requestParam);
	


}
