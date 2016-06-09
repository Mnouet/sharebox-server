package com.japrod.sharebox.server.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MissingFixtureException extends Exception{

	private final Logger log = LoggerFactory.getLogger(MissingFixtureException.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -5311655508346285197L;
	
	/**
     * Instantiates a new user name already taken exception.
     */
    public MissingFixtureException(String message) {
        super(message);
        log.error("Missing fixture : {}", message);
    }

}
