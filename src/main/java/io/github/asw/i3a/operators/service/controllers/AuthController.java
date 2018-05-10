package io.github.asw.i3a.operators.service.controllers;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.asw.i3a.operators.service.services.OperatorsService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AuthController {

	@Autowired
	OperatorsService service;

	@RequestMapping(value = "/auth", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> auth( @RequestBody Map<String, Object> payload ) {

		Map<String, Object> result = new HashMap<String, Object>();

		String operatorId = service.auth( payload.get( "email" ).toString(),
				payload.get( "password" ).toString() );

		System.out.println( operatorId );

		if (operatorId != null && operatorId != "") {
			result.put( "operatorId", operatorId );
			log.info( "Login succesful for : " + operatorId );
			return new ResponseEntity<String>( new JSONObject( result ).toString(), HttpStatus.OK );
		}

		result.put( "operatorId", "" );
		log.warn( "Unauthorized access attemp: " + new JSONObject( payload ).toString() );
		return new ResponseEntity<String>( new JSONObject( result ).toString(),
				HttpStatus.UNAUTHORIZED );
	}
}
