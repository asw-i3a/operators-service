package io.github.asw.i3a.operators.service.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.bson.types.ObjectId;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.asw.i3a.operators.service.repositories.OperatorsRepository;
import io.github.asw.i3a.operators.service.types.Operator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AgentsServiceImpl implements OperatorsService {

	@Autowired
	OperatorsRepository repository;

	@Override
	public String auth( String email, String plainPassword ) {
		log.info( "Getting information for... " + email );
		Operator operator = repository.findByEmail( email );
		log.info( "Information found for: " + email + " : " + operator.toString() );

		if (operator != null && new StrongPasswordEncryptor().checkPassword( plainPassword,
				operator.getPassword() )) {
			return operator.get_id().toString();
		}

		return "";
	}

	@Override
	public List<Operator> findAll() {
		return repository.findAll();
	}

	@Override
	public Operator findById( String id ) {
		try {
			return repository.findById( new ObjectId( id ) ).get();
		} catch (NoSuchElementException e) {
			log.error( e.toString() );
			return null;
		}
	}

}
