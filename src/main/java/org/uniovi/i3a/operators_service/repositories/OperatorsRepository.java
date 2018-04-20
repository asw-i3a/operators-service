package org.uniovi.i3a.operators_service.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.uniovi.i3a.operators_service.types.Operator;


public interface OperatorsRepository extends MongoRepository<Operator, ObjectId> {
    
    /**
     * Find a user by its email address.
     * 
     * @param id
     *            address of the user to look for.
     * @return the user if exists, null otherwise.
     */
    Optional<Operator> findById(ObjectId id);
    
    Operator findByEmail(String email);
}
