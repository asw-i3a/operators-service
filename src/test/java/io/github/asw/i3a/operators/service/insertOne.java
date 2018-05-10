package io.github.asw.i3a.operators.service;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.github.asw.i3a.operators.service.Service;
import io.github.asw.i3a.operators.service.repositories.OperatorsRepository;
import io.github.asw.i3a.operators.service.services.OperatorsService;
import io.github.asw.i3a.operators.service.types.Operator;

@SpringBootTest(classes = { Service.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class insertOne {

	@Autowired
	OperatorsRepository repo;

	@Autowired
	OperatorsService serv;

	public void testA() {
		Operator o = new Operator();

		o.setName( "Labra Operator" );
		o.setEmail( "labra-operator@unoivi.es" );
		o.setPassword( "1234" );

		repo.save( o );
	}

	public void testB() {
		String id = serv.auth( "colunga91@gmail.com", "1234" );
		Operator o = serv.findById( id );
		assertEquals( "Guillermo Facundo Colunga", o.getName() );
	}

}
