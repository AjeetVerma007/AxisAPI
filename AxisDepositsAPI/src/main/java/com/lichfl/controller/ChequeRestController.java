package com.lichfl.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lichfl.entity.ChequeDetails;
import com.lichfl.entity.CustomUserDetails;
import com.lichfl.entity.JwtRequest;
import com.lichfl.entity.JwtResponse;
import com.lichfl.service.ChequeService;
import com.lichfl.service.CustomUserDetailsService;
import com.lichfl.service.UserInfoService;
import com.lichfl.utility.JwtUtil;

@RestController
@Validated
public class ChequeRestController {

	@Autowired
	ChequeService chequeService;

	@Autowired
	UserInfoService userInfoService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	private final Logger logger = LoggerFactory.getLogger(ChequeRestController.class);


	@PostMapping("/txns")
	public ResponseEntity<ChequeDetails> saveChequeDtls( @RequestBody ChequeDetails chequeDetails) throws Exception   {

		logger.info("Inside save method");
		

		ChequeDetails chequeDetails2 = chequeService.saveTxns(chequeDetails);

		return new ResponseEntity<ChequeDetails>(chequeDetails2, HttpStatus.CREATED);
	}

	@GetMapping("/txns")
	public ResponseEntity<List<ChequeDetails>> getChequeDtls() throws Exception  {

		logger.info("Inside get method");
		List<ChequeDetails> chequeDetails = chequeService.getTxns();

		return new ResponseEntity<List<ChequeDetails>>(chequeDetails, HttpStatus.OK);
	}

	@GetMapping("/txns/{id}")
	public ResponseEntity<ChequeDetails> getChequeDtlsById(@PathVariable("id") Long txnId) throws Exception  {
		logger.info("Inside get by ID method");

		ChequeDetails chequeDetails = chequeService.getChequeDtlsById(txnId);

		return new ResponseEntity<ChequeDetails>(chequeDetails, HttpStatus.OK);
	}

	@DeleteMapping("/txns/{id}")
	public ResponseEntity<String> deleteChequeDtlsById(@PathVariable("id") Long txnId) {
		chequeService.deleteChequeDtlsById(txnId);
		String message ="Transaction has been deleted";
		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}

	@PutMapping("/txns/{id}")
	public ResponseEntity<ChequeDetails> updateChequeDtls(@PathVariable("id") Long id,
			@RequestBody ChequeDetails chequeDetails) {

		ChequeDetails chequeDetails2 = chequeService.updateChequeDtls(id, chequeDetails);
		return new ResponseEntity<ChequeDetails>(chequeDetails2, HttpStatus.CREATED);
	}

	@RequestMapping("/saveUser")
	public ResponseEntity<CustomUserDetails> saveUser( @RequestBody CustomUserDetails customUserDetails) {
		
		System.out.println("customer user details" +customUserDetails);
		

		customUserDetails = userInfoService.saveUser(customUserDetails);

		return new ResponseEntity<CustomUserDetails>(customUserDetails, HttpStatus.CREATED);
	}

	@RequestMapping("/authenticate")
	public ResponseEntity<?> generateJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception  {
		System.out.println("jwtRequest" + jwtRequest);
		
		try {
			
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword()));
			
		} catch (UsernameNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		
	UserDetails userDetails=this.customUserDetailsService.loadUserByUsername(jwtRequest.getUserName());
	String token = this.jwtUtil.generateToken(userDetails);
	System.out.println("token :"+token);
	
	return new ResponseEntity<>(new JwtResponse(token),HttpStatus.OK);
	}

	/*
	 * @Autowired SecurityUserRepository securityUserRepository;
	 * 
	 * @RequestMapping("/") public void saveUserDetails() { UserConfig userConfig =
	 * UserConfig.builder().username("lichfl") .password(new
	 * BCryptPasswordEncoder().encode("lichfl")).remarks("LICHFL user details")
	 * .moduleName("AXIS_API ").status("A").build();
	 * 
	 * securityUserRepository.save(userConfig); }
	 */

}
