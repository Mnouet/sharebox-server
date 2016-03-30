package com.japrod.sharebox.server.service;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public abstract class AbstractService {
	
	/** Propriété du Mapper. */
	protected Mapper dozerMapper = new DozerBeanMapper();


}
