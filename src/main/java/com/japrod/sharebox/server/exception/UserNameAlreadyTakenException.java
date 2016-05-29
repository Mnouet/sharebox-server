package com.japrod.sharebox.server.exception;

/**
 * Error thrown when trying to create a new user with an already used name
 * @see UserService
 */
public class UserNameAlreadyTakenException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7725187908725625691L;

    /**
     * Instantiates a new user name already taken exception.
     */
    public UserNameAlreadyTakenException() {
        super();
    }
}
