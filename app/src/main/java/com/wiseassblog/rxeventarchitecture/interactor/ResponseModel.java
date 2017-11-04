package com.wiseassblog.rxeventarchitecture.interactor;

/**
 * Created by R_KAY on 11/2/2017.
 */

public class ResponseModel {

    private boolean inProgress;
    private boolean success;
    private String message;

    public ResponseModel(boolean inProgress, boolean success, String message) {
        this.inProgress = inProgress;
        this.success = success;
        this.message = message;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    static ResponseModel inProgress(){
        return new ResponseModel(true, false, null);
    }
    static ResponseModel success(){
        return new ResponseModel(false, true, "Successfully did the Thing");
    }
    static ResponseModel idle(){
        return new ResponseModel(false, false, null);
    }
    static ResponseModel failure(String errorMessage){
        return new ResponseModel(false, false, "An Error Has Occurred.");
    }
}
