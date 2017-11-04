package com.wiseassblog.rxeventarchitecture.presenter;

import android.util.Log;

import com.wiseassblog.rxeventarchitecture.interactor.RequestModel;
import com.wiseassblog.rxeventarchitecture.interactor.ResponseModel;
import com.wiseassblog.rxeventarchitecture.interactor.UseCase;
import com.wiseassblog.rxeventarchitecture.model.ServiceA;
import com.wiseassblog.rxeventarchitecture.model.ServiceB;
import com.wiseassblog.rxeventarchitecture.view.ViewInterface;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Presenter:
 * 1. Contains a Use Case for each Event, which returns an Observable of the operation
 * 2. Contains a single Observer which all Use Cases will be added to.
 *
 * When the Observer Fires, all Observables should return the same type of Object, and this Object
 * should be used by the Presenter to determine the appropriate result for the UI. This requires
 * that the Object must contain all the information necessary for the Presenter to infer the
 * correct state of the View.
 *
 * Created by R_KAY on 11/2/2017.
 */

public class Presenter {

    private final ViewInterface view;
    private final UseCase useCase;
    private CompositeDisposable disposables;

    public Presenter(ViewInterface view, ServiceA serviceA, ServiceB serviceB) {
        this.useCase = new UseCase(serviceA, serviceB);
        this.view = view;
        disposables = new CompositeDisposable();
    }

    public void submitName(String name){
                useCase.executeUseCase(new RequestModel(name))
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(
                                getObserver()
                        );
    }

    private Observer<ResponseModel> getObserver(){
        return new Observer<ResponseModel>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseModel responseModel) {
                //TODO: change UI instead of using logging.
                Log.d("RESPONSE", responseModel.getMessage());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

}
