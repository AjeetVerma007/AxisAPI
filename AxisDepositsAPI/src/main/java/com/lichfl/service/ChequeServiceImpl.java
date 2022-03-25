package com.lichfl.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lichfl.entity.ChequeDetails;
import com.lichfl.entity.RequestParam;
import com.lichfl.repository.ChequeRepository;

@Service
public class ChequeServiceImpl implements ChequeService {

	private final Logger logger = LoggerFactory.getLogger(ChequeServiceImpl.class);

	@Autowired
	private ChequeRepository chequeRepository;

	@Override
	public ChequeDetails saveTxns(ChequeDetails chequeDetails) throws Exception {
		
	       Date date = new Date();  
           DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");  
           String strDate = dateFormat.format(date);  
		
		//if (chequeDetails.getStatus()==null && chequeDetails.getCreatedDate()==null)
        if (chequeDetails.getCol23()==null)
		{
        	logger.info("date is :"+strDate);
			//chequeDetails.setStatus("S");
			chequeDetails.setCol23(strDate);
		}

		try {
			return chequeRepository.save(chequeDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Value of cause e is  :" + e);
			throw new RuntimeException("Please send valid request paramters");
			// throw new TransactionException("Please send valid request paramters ");
		}

	}

	@Override
	public List<ChequeDetails> getTxns() throws Exception {
		// TODO Auto-generated method stub
		List<ChequeDetails> cheqList = null;

		try {
			cheqList = chequeRepository.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);

		}

		if (cheqList.isEmpty()) {
			throw new Exception("No data values found in Database");
		}
		return cheqList;
	}

	@Override
	public ChequeDetails getChequeDtlsById(Long txnId) throws Exception {
		// TODO Auto-generated method stub

		Optional<ChequeDetails> chOptional = chequeRepository.findById(txnId);

		//if (!chOptional.isPresent() || chOptional.empty()) {
		if (!chOptional.isPresent()){
			throw new Exception("Such transaction does not exist");

		}

		return chOptional.get();

	}

	@Override
	public void deleteChequeDtlsById(Long txnId) {
		
		chequeRepository.deleteById(txnId);

	}

	@Override
	public ChequeDetails updateChequeDtls(Long id, ChequeDetails chequeDetails) {
		// TODO Auto-generated method stub
		ChequeDetails cd = chequeRepository.findById(id).get();

	
		return chequeRepository.save(cd);

	}

	@Override
	public String validateRequestParam(RequestParam requestParam) {
		// TODO Auto-generated method stub
		
		if (requestParam.getDepSlipNo()==null||requestParam.getInstAmnt()==null||requestParam.getBankLoc()==null
				||requestParam.getProdCode()==null||requestParam.getDepDate()==null)
		{
			return "Mandatory parameters cannot be null";
		}
		
		return "success";
		
	}



}
