package io.github.asw.i3a.operators.service.types;

import static org.junit.Assert.*;

import org.bson.types.ObjectId;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.junit.Before;
import org.junit.Test;

public class OperatorTest {
	
	private Operator operator;
	
	@Before
	public void setUp() {
		operator = new Operator();
	}

	@Test
	public void _idTest() {
		ObjectId id = new ObjectId();
		operator.set_id( id );
		assertEquals( id, operator.get_id() );
		assertEquals( id.toString(), operator.getOperatorId() );
	}
	
	@Test
	public void nameTest() {
		String name = "pepe";
		operator.setName( name );
		assertEquals( name, operator.getName() );
	}
	
	@Test
	public void emailTest() {
		String email = "email@mail.com";
		operator.setEmail( email );
		assertEquals( email, operator.getEmail() );
	}
	
	@Test
	public void passwordTest() {
		operator.setPassword( null );
		assertTrue( new StrongPasswordEncryptor().checkPassword( "", operator.getPassword() ) );
		String password = "secure";
		operator.setPassword( password );
		assertTrue( new StrongPasswordEncryptor().checkPassword( password, operator.getPassword() ) );
	}

}
