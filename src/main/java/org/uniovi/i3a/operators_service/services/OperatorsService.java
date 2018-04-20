package org.uniovi.i3a.operators_service.services;

import java.util.List;

import org.uniovi.i3a.operators_service.types.Operator;

public interface OperatorsService {
    
    /**
     * Given the data of a user, checks if there's such an user, and if the password
     * matches
     * 
     * @param identifier
     *            The login email for the user
     * @param password
     *            The password given on the credentials
     * @return Either the proper user, if the user exists and the password matches.
     *         Null otherwise
     */
    String auth(String email, String password);
    
    List<Operator> findAll();
    
    Operator findById(String id);

}
