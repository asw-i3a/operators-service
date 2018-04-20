/*
 * This source file is part of the Agents_i3a open source project.
 *
 * Copyright (c) 2017 Agents_i3a project authors.
 * Licensed under MIT License.
 *
 * See /LICENSE for license information.
 * 
 * This class is based on the AlbUtil project.
 * 
 */
package org.uniovi.i3a.operators_service.types;

import org.bson.types.ObjectId;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Document(collection = "operators")
public class Operator {

    @Id @JsonIgnore
    private ObjectId _id;
    private String name;
    @Indexed
    private String email;
    private String password;
    
    @JsonProperty("operatorId")
    private String operatorId;
    
    public String getOperatorId() {
	return this._id.toString();
    }
  
    public void setPassword(String password) {
	this.password = (password == null) ? new StrongPasswordEncryptor().encryptPassword(password = "")
		: new StrongPasswordEncryptor().encryptPassword(password);
    }
    
    @JsonIgnore
    public String getPassword() {
	return password;
    }
}
