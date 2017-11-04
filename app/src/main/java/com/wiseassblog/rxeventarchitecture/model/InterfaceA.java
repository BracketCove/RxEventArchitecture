package com.wiseassblog.rxeventarchitecture.model;

import com.wiseassblog.rxeventarchitecture.interactor.ResponseModel;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by R_KAY on 11/2/2017.
 */

public interface InterfaceA {

    Observable<Result> setName(String name);
}
