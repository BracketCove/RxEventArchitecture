package com.wiseassblog.rxeventarchitecture.model;

/**
 * Created by R_KAY on 11/2/2017.
 */

public class Result {
   final boolean successful;
   final  String errorMessage;

    public Result(boolean successful, String errorMessage) {
        this.successful = successful;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
