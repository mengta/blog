package com.rcswu.exceptions;


@SuppressWarnings("serial")
public class NameIsUsedException extends UserException {
    public NameIsUsedException(String reason) {
        super(reason);
    }
}
