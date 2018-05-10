package io.github.asw.i3a.operators.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.asw.i3a.operators.service.services.OperatorsService;
import io.github.asw.i3a.operators.service.types.Operator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class GetOperatorsController {

	@Autowired
	private OperatorsService service;

	@RequestMapping(value = "/operators")
	public List<Operator> getAllOperators() {
		log.info( "Getting all operators list" );
		return service.findAll();
	}

	@RequestMapping(value = "/operators/{id}")
	public Operator getOperatorByDBId( @PathVariable("id") String id ) {
		log.info( "Getting information for: " + id );
		return service.findById( id );
	}

}
