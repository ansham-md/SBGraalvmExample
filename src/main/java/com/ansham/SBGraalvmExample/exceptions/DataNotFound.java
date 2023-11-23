package com.ansham.SBGraalvmExample.exceptions;

public class DataNotFound extends RuntimeException {

    public DataNotFound(String message) {
        super(message);
    }
}
