package com.wiseassblog.rxeventarchitecture.interactor;

/**
 * Action: A ServiceA which contains data required to execute a given Action
 * Created by R_KAY on 11/2/2017.
 */

public class RequestModel {
    private final String name;

    public RequestModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
