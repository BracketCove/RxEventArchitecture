package com.wiseassblog.rxeventarchitecture.model;

import io.reactivex.Observable;

/**
 * Created by R_KAY on 11/2/2017.
 */

public interface InterfaceB {

    Observable<Result> setName(String name);
}
