package com.rcswu.exceptions;


@SuppressWarnings("serial")
public class UserIsNotFound extends UserException {

    public UserIsNotFound(String message) {
        super(message);
    }
}
