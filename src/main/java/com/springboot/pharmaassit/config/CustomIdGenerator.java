package com.springboot.pharmaassit.config;

import java.time.Year;
import java.util.UUID;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;


public class CustomIdGenerator implements IdentifierGenerator{

	@Override
	public  String generate(SharedSessionContractImplementor session, Object object) {
		// TODO Auto-generated method stub
		String uuid =UUID.randomUUID().toString();
		return Year.now().toString()+uuid;
	}

}
