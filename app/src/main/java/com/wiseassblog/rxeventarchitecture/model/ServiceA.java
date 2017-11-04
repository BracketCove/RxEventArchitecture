package com.wiseassblog.rxeventarchitecture.model;

import io.reactivex.Observable;

/**
 * Created by R_KAY on 11/2/2017.
 */

public class ServiceA implements InterfaceA {

    boolean toggle = true;

    @Override
    public Observable<Result> setName(String name) {
        if (toggle){
            toggle = false;
            return Observable.just(new Result(true, ""));
        }
        else {
            toggle = true;
            return Observable.just(new Result(false, "Something went wrong"));
        }
    }
}
