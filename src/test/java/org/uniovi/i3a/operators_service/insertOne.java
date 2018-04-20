package org.uniovi.i3a.operators_service;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.uniovi.i3a.operators_service.repositories.OperatorsRepository;
import org.uniovi.i3a.operators_service.services.OperatorsService;
import org.uniovi.i3a.operators_service.types.Operator;
import org.uniovi.i3a.operators_service.Service;

@SpringBootTest(classes = { Service.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class insertOne {
    
    @Autowired
    OperatorsRepository repo;
    
    @Autowired
    OperatorsService serv;

    
    public void testA() {
	Operator o = new Operator();
	
	o.setName("Guillermo Facundo Colunga");
	o.setEmail("colunga91@gmail.com");
	o.setPassword("1234");
	
	repo.save(o);
    }
    
    
    public void testB() {
	String id = serv.auth("colunga91@gmail.com", "1234");
	Operator o = serv.findById(id);
	assertEquals("Guillermo Facundo Colunga", o.getName());
    }

}
