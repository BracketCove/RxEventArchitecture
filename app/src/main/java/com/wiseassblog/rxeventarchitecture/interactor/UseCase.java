package com.wiseassblog.rxeventarchitecture.interactor;

import com.wiseassblog.rxeventarchitecture.model.InterfaceA;
import com.wiseassblog.rxeventarchitecture.model.InterfaceB;
import com.wiseassblog.rxeventarchitecture.model.Result;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static io.reactivex.Observable.merge;
import static io.reactivex.Observable.zip;

/**
 * My primary goal here is to use a Use Case to coordinate multiple Services, thus leaving the
 * Presenter to worry about UI Logic instead of backend stuff.
 * Created by R_KAY on 11/2/2017.
 */

public class UseCase {

    //Although the interfaces do the same thing in implementation, I'm trying to emulate situations when a Use Case
    //Must talk to multiple conceptually different services.

    //Likely a Database for example
    private InterfaceA someDataService;

    //Some kind of System Service like AlarmManager.
    private InterfaceB someSystemService;

    public UseCase(InterfaceA someDataService, InterfaceB someSystemService) {
        this.someDataService = someDataService;
        this.someSystemService = someSystemService;
    }

    public Observable<ResponseModel> executeUseCase(RequestModel requestModel) {

        Observable<Result> dataResult = someDataService.setName(requestModel.getName());

        Observable<Result> serviceResult = someSystemService.setName(requestModel.getName());

        //Goal with Zip: Look at results of two operations, and determine a response as a single
        //observable.
        return Observable.zip(
                dataResult.subscribeOn(Schedulers.io()),
                serviceResult.subscribeOn(Schedulers.io()),
                new BiFunction<Result, Result, ResponseModel>() {

                    @Override
                    public ResponseModel apply(@NonNull Result result, @NonNull Result result2) throws Exception {
                        if (result.isSuccessful() && result2.isSuccessful()) {
                            return new ResponseModel(false, true, "Successful");
                        } else {
                            return new ResponseModel(false, false, "Error has occured");
                        }
                    }

                }
        ).subscribeOn(Schedulers.io());
    }
}
